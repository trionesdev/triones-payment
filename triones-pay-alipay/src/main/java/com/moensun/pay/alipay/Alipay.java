package com.moensun.pay.alipay;

import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayResponse;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.moensun.pay.alipay.request.AlipayTradePreCreateEasyRequest;
import com.moensun.pay.alipay.util.AlipaySignatureUtils;
import lombok.SneakyThrows;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Objects;


public abstract class Alipay {
    protected final AlipayClient alipayClient;
    protected final AlipayIntegrationConfig alipayConfig;

    @SneakyThrows
    public Alipay(AlipayIntegrationConfig alipayConfig) {
        this.alipayConfig = alipayConfig;
        alipayClient = new DefaultAlipayClient(alipayConfig);
    }

    @SneakyThrows
    public AlipayTradePrecreateResponse preCreate(AlipayTradePreCreateEasyRequest easyRequest) {
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        if(StringUtils.isNotBlank(easyRequest.getNotifyUrl())){
            request.setNotifyUrl(easyRequest.getNotifyUrl());
        }else {
            request.setNotifyUrl(alipayConfig.getNotifyUrl());
        }
        request.setBizModel(easyRequest.getBizModel());
        AlipayTradePrecreateResponse response;
        if(certRequest()){
            response = this.alipayClient.certificateExecute(request);
        }else {
            response = this.alipayClient.execute(request);
        }
        return responseInterceptor(response);
    }

    public String notifyUrl(String key){
        Map<String,String> notifyUrls = alipayConfig.getNotifyUrls();
        if(MapUtils.isEmpty(notifyUrls)){
            return null;
        }
        return notifyUrls.get(key);
    }

    public boolean certRequest() {
        return StringUtils.isBlank(alipayConfig.getAlipayPublicKey());
    }

    /**
     * 此方法会去掉sign_type做验签，暂时除生活号（原服务窗）激活开发者模式外都使用V1。
     * @param params
     * @return
     */
    @SneakyThrows
    public boolean rsaCheckV1(Map<String, String> params){
        if(certRequest()){
            if (StringUtils.isNotBlank(alipayConfig.getAlipayPublicCertContent())) {
                return AlipaySignatureUtils.rsaCertContentCheckV1(params, alipayConfig.getAlipayPublicCertContent(), alipayConfig.getCharset(), alipayConfig.getSignType());
            }else {
                return AlipaySignature.rsaCertCheckV1(params, alipayConfig.getAlipayPublicCertPath(), alipayConfig.getCharset(), alipayConfig.getSignType());
            }
        }else {
            return AlipaySignature.rsaCheckV1(params, alipayConfig.getAlipayPublicKey(), alipayConfig.getCharset(), alipayConfig.getSignType());
        }
    }

    /**
     * 此方法不会去掉sign_type验签，用于生活号（原服务窗）激活开发者模式
     * @param params
     * @return
     */
    @SneakyThrows
    public boolean rsaCheckV2(Map<String, String> params) {
        if (certRequest()) {
            if (StringUtils.isNotBlank(alipayConfig.getAlipayPublicCertContent())) {
                return AlipaySignatureUtils.rsaCertContentCheckV2(params, alipayConfig.getAlipayPublicCertContent(), alipayConfig.getCharset(), alipayConfig.getSignType());
            } else {
                return AlipaySignature.rsaCertCheckV2(params, alipayConfig.getAlipayPublicCertPath(), alipayConfig.getCharset(), alipayConfig.getSignType());
            }
        } else {
            return AlipaySignature.rsaCheckV2(params, alipayConfig.getAlipayPublicKey(), alipayConfig.getCharset(), alipayConfig.getSignType());
        }
    }

    private  <T extends AlipayResponse> T responseInterceptor(T response ){
        if(!Objects.equals("10000",response.getCode())){
            throw new AliPayException(response.getCode(), response.getMsg()+":"+response.getSubMsg());
        }
        return response;
    }

}
