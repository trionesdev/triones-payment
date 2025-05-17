package com.trionesdev.payment.wechatpay.v3.payment;

import com.trionesdev.payment.util.JsonUtils;
import com.trionesdev.payment.wechatpay.v3.convert.WechatPayConvert;
import com.trionesdev.payment.wechatpay.v3.model.WechatPayCloseOrderRequest;
import com.trionesdev.payment.wechatpay.v3.model.WechatPayQueryOrderByIdRequest;
import com.trionesdev.payment.wechatpay.v3.model.WechatPayTransaction;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayNotifyRequest;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayRefoundNotifyResponse;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayTransactionNotifyResponse;
import com.wechat.pay.java.core.Config;
import com.wechat.pay.java.core.RSAAutoCertificateConfig;
import com.wechat.pay.java.core.http.*;
import com.wechat.pay.java.core.notification.NotificationConfig;
import com.wechat.pay.java.core.notification.NotificationParser;
import com.wechat.pay.java.core.util.GsonUtil;
import com.wechat.pay.java.core.util.PemUtil;
import com.wechat.pay.java.service.payments.app.model.QueryOrderByIdRequest;
import com.wechat.pay.java.service.payments.model.Transaction;
import com.wechat.pay.java.service.refund.model.RefundNotification;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.cert.X509Certificate;

public abstract class WechatPayBase {
    private static final Logger log = LoggerFactory.getLogger(WechatPayBase.class);
    protected final WechatPayConfig wxPayConfig;
    protected final Config config;
    protected final HttpClient httpClient;
    protected final HostName hostName;

    protected final NotificationParser notificationParser;

    public WechatPayBase(WechatPayConfig wxPayConfig) {
        this.wxPayConfig = wxPayConfig;
        this.config = buildConfig(wxPayConfig);
        this.httpClient = (new DefaultHttpClientBuilder()).config(config).build();
        this.hostName = null;
        this.notificationParser = new NotificationParser((NotificationConfig) config);
    }

    private Config buildConfig(WechatPayConfig wxPayConfig) {
        RSAAutoCertificateConfig.Builder builder = new RSAAutoCertificateConfig
                .Builder()
                .merchantId(wxPayConfig.getMchId())
                .merchantSerialNumber(wxPayConfig.getMerchantSerialNo())
                .apiV3Key(wxPayConfig.getApiV3Key());
        if (StringUtils.isBlank(wxPayConfig.getMerchantSerialNo())) {
            builder.merchantSerialNumber(getMerchantSerialNumber(wxPayConfig.getPrivateCertPath(), wxPayConfig.getPrivateCert()));
        }
        if (StringUtils.isNoneBlank(wxPayConfig.getPrivateKey())) {
            builder.privateKey(wxPayConfig.getPrivateKey());
        } else {
            builder.privateKeyFromPath(wxPayConfig.getPrivateKeyPath());
        }
        return builder.build();
    }

    private RequestBody createRequestBody(Object request) {
        return (new JsonRequestBody.Builder()).body(GsonUtil.toJson(request)).build();
    }

    private String getMerchantSerialNumber(String privateCertPath, String privateCert) {
        X509Certificate certificate = null;
        if (StringUtils.isNoneBlank(privateCert)) {
            certificate = PemUtil.loadX509FromString(privateCert);
        } else {
            certificate = PemUtil.loadX509FromPath(privateCertPath);
        }
        return certificate.getSerialNumber().toString(16).toUpperCase();
    }

    /**
     * 关闭订单
     *
     * @param request
     */
    public void closeOrder(WechatPayCloseOrderRequest request) {
        String requestPath = "https://api.mch.weixin.qq.com/v3/pay/transactions/out-trade-no/{out_trade_no}/close";
        requestPath = requestPath.replace("{out_trade_no}", UrlEncoder.urlEncode(request.getOutTradeNo()));
        if (this.hostName != null) {
            requestPath = requestPath.replaceFirst(HostName.API.getValue(), this.hostName.getValue());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.addHeader("Accept", MediaType.APPLICATION_JSON.getValue());
        headers.addHeader("Content-Type", MediaType.APPLICATION_JSON.getValue());
        HttpRequest httpRequest = (new HttpRequest.Builder()).httpMethod(HttpMethod.POST).url(requestPath).headers(headers).body(this.createRequestBody(request)).build();
        this.httpClient.execute(httpRequest, null);
    }

    /**
     * 微信支付订单号查询订单
     *
     * @param request
     * @return
     */
    public WechatPayTransaction queryOrderById(WechatPayQueryOrderByIdRequest request) {
        String requestPath = "https://api.mch.weixin.qq.com/v3/pay/transactions/id/{transaction_id}";
        requestPath = requestPath.replace("{transaction_id}", UrlEncoder.urlEncode(request.getTransactionId()));
        QueryParameter queryParameter = new QueryParameter();
        if (request.getMchId() != null) {
            queryParameter.add("mchid", UrlEncoder.urlEncode(request.getMchId()));
        }

        requestPath = requestPath + queryParameter.getQueryStr();
        if (this.hostName != null) {
            requestPath = requestPath.replaceFirst(HostName.API.getValue(), this.hostName.getValue());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.addHeader("Accept", MediaType.APPLICATION_JSON.getValue());
        headers.addHeader("Content-Type", MediaType.APPLICATION_JSON.getValue());
        HttpRequest httpRequest = (new HttpRequest.Builder()).httpMethod(HttpMethod.GET).url(requestPath).headers(headers).build();
        HttpResponse<WechatPayTransaction> httpResponse = this.httpClient.execute(httpRequest, WechatPayTransaction.class);
        return httpResponse.getServiceResponse();
    }

    /**
     * 交易成功回调通知
     *
     * @param wxPayNotifyRequest
     */
    public WechatPayTransactionNotifyResponse transactionNotify(WechatPayNotifyRequest wxPayNotifyRequest) {
        return notificationParser.parse(wxPayNotifyRequest.toRequestParam(), WechatPayTransactionNotifyResponse.class);
    }

    /**
     * 退款成功回调
     *
     * @param wxPayNotifyRequest
     * @return
     */
    public WechatPayRefoundNotifyResponse refundNotify(WechatPayNotifyRequest wxPayNotifyRequest) {
        return notificationParser.parse(wxPayNotifyRequest.toRequestParam(), WechatPayRefoundNotifyResponse.class);
    }


}
