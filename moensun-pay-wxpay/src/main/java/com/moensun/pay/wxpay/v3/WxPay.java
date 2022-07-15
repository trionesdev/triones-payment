package com.moensun.pay.wxpay.v3;

import com.moensun.pay.util.JsonUtils;
import com.moensun.pay.wxpay.WxPayException;
import com.moensun.pay.wxpay.v3.model.WxPayNotify;
import com.moensun.pay.wxpay.v3.model.WxPayNotifyResourceDecrypt;
import com.moensun.pay.wxpay.v3.request.WxPayBaseCreateOrderRequest;
import com.moensun.pay.wxpay.v3.response.WxPayBaseResponse;
import com.moensun.pay.wxpay.v3.response.WxPayCreateOrderGeneralResponse;
import com.moensun.pay.wxpay.v3.util.WxPayUtils;
import com.wechat.pay.contrib.apache.httpclient.auth.Verifier;
import com.wechat.pay.contrib.apache.httpclient.util.AesUtil;
import lombok.SneakyThrows;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class WxPay {

    private static final Logger log = LoggerFactory.getLogger(WxPay.class);

    final String BASE_URL = "https://api.mch.weixin.qq.com";

    private final WxPayIntegrationConfig wxPayIntegrationConfig;
    private final CloseableHttpClient httpClient;
    private final PrivateKey privateKey;
    private final X509Certificate certificate;
    private final AesUtil aesUtil;
    private final Verifier verifier;

    public WxPay(WxPayIntegrationConfig wxPayIntegrationConfig) {
        this.wxPayIntegrationConfig = wxPayIntegrationConfig;
        try {
            this.privateKey = WxPayUtils.loadPrivateKey(wxPayIntegrationConfig.getPrivateKeyPath(), wxPayIntegrationConfig.getPrivateKeyContent());
            this.certificate = WxPayUtils.loadCertificate(wxPayIntegrationConfig.getPrivateCertPath(), wxPayIntegrationConfig.getPrivateCertContent());
            this.verifier = WxPayUtils.verifier(wxPayIntegrationConfig);
            this.httpClient = WxPayUtils.buildHttpClient(wxPayIntegrationConfig,privateKey,certificate,verifier);
            this.aesUtil = new AesUtil(StringUtils.getBytes(wxPayIntegrationConfig.getApiV3Key(),StandardCharsets.UTF_8));
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }
    }

    public String getAppId() {
        return wxPayIntegrationConfig.getAppId();
    }

    private <T extends WxPayBaseCreateOrderRequest> void requestBody(T orderRequest) {
        if (StringUtils.isBlank(orderRequest.getAppId())) {
            orderRequest.setAppId(wxPayIntegrationConfig.getAppId());
        }
        if (StringUtils.isBlank(orderRequest.getMchId())) {
            orderRequest.setMchId(wxPayIntegrationConfig.getMchId());
        }
        if (StringUtils.isBlank(orderRequest.getNotifyUrl())) {
            orderRequest.setNotifyUrl(wxPayIntegrationConfig.getNotifyUrl());
        }
    }

    /**
     * 通用下单(直连商户)
     *
     * @param tradeType
     * @param orderRequest
     * @return
     */
    @SneakyThrows
    public <T extends WxPayBaseCreateOrderRequest> WxPayCreateOrderGeneralResponse createOrderGeneral(TradeTypeEnum tradeType, T orderRequest) {
        requestBody(orderRequest);
        HttpPost httpPost = new HttpPost(BASE_URL + tradeType.getUri());
        httpPost.addHeader("Accept", "application/json");
        httpPost.addHeader("Content-type", "application/json; charset=utf-8");
        httpPost.setEntity(new StringEntity(JsonUtils.writeValueAsString(orderRequest), StandardCharsets.UTF_8));
        CloseableHttpResponse response = httpClient.execute(httpPost);
        String bodyAsString = EntityUtils.toString(response.getEntity());
        WxPayCreateOrderGeneralResponse response1 = JsonUtils.readValue(bodyAsString, WxPayCreateOrderGeneralResponse.class);
        return responseInterceptor(response1);
    }

    public String signatureGeneral(String message) {
        try {
            Signature sign = Signature.getInstance("SHA256withRSA");
            sign.initSign(privateKey);
            sign.update(StringUtils.getBytes(message, StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(sign.sign());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("当前Java环境不支持SHA256withRSA", e);
        } catch (SignatureException e) {
            throw new RuntimeException("签名计算失败", e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException("无效的私钥", e);
        }
    }

    /**
     * 应答验签
     * @param timestamp
     * @param nonce
     * @param serialNo
     * @param body
     * @param signature
     * @return
     */
    @SneakyThrows
    public boolean signVerify(String timestamp, String nonce, String serialNo, String body, String signature){
        String message = Stream.of(timestamp,nonce,body).collect(Collectors.joining("\n","","\n"));
        return this.verifier.verify(serialNo,StringUtils.getBytes(message, StandardCharsets.UTF_8),signature);
    }


    /**
     * 根据回调内容解密出内容
     * @param wxPayNotify
     * @return
     */
    public WxPayNotifyResourceDecrypt decryptNotifyCiphertext(WxPayNotify wxPayNotify){
        WxPayNotify.Resource resource = wxPayNotify.getResource();
        if(Objects.isNull(resource)){
            throw new WxPayException();
        }
        return decryptNotifyCiphertext(resource.getAssociatedData(),resource.getNonce(),resource.getCiphertext());
    }

    /**
     * 解密回调密文
     * @param associatedData
     * @param nonce
     * @param ciphertext
     * @return
     */
    public WxPayNotifyResourceDecrypt decryptNotifyCiphertext(String associatedData, String nonce, String ciphertext) {
        try {
            String str = aesUtil.decryptToString(StringUtils.getBytes(associatedData,StandardCharsets.UTF_8),StringUtils.getBytes(nonce,StandardCharsets.UTF_8),ciphertext);
            return JsonUtils.readValue(str, WxPayNotifyResourceDecrypt.class);
        } catch (GeneralSecurityException | IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public String notifyUrl(String key){
        Map<String,String> notifyUrls = wxPayIntegrationConfig.getNotifyUrls();
        if(MapUtils.isEmpty(notifyUrls)){
            return null;
        }
        return notifyUrls.get(key);
    }

    public <T extends WxPayBaseResponse> T responseInterceptor(T response){
        return response;
    }

}
