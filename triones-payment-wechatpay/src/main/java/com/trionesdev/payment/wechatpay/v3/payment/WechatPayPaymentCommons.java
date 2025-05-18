package com.trionesdev.payment.wechatpay.v3.payment;

import com.trionesdev.payment.wechatpay.v3.WechatPayBase;
import com.trionesdev.payment.wechatpay.v3.WechatPayConfig;
import com.trionesdev.payment.wechatpay.v3.model.WechatPayTransaction;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayNotifyParseRequest;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayRefoundNotifyParseResponse;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayTransactionNotifyParseResponse;
import com.trionesdev.payment.wechatpay.v3.operation.model.WechatPayCancelTransferResponse;
import com.trionesdev.payment.wechatpay.v3.payment.model.*;
import com.wechat.pay.java.core.http.*;

/**
 * 支付产品
 */
public class WechatPayPaymentCommons extends WechatPayBase {
    public WechatPayPaymentCommons(WechatPayConfig wxPayConfig) {
        super(wxPayConfig);
    }

    /**
     * 微信支付订单号查询订单
     *
     * @param request
     * @return
     */
    public WechatPayTransaction queryOrderById(WechatPayQueryOrderByIdRequest request) {
        String requestPath = "https://api.mch.weixin.qq.com/v3/pay/transactions/id/" + UrlEncoder.urlEncode(request.getTransactionId());
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
     * 商户订单号查询订单
     *
     * @param request
     * @return
     */
    public WechatPayTransaction queryOrderByOutTradeNo(WechatPayQueryOrderByOutTradeNoRequest request) {
        String requestPath = "https://api.mch.weixin.qq.com/v3/pay/transactions/out-trade-no/" + UrlEncoder.urlEncode(request.getOutTradeNo());
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
     * 关闭订单
     *
     * @param request
     */
    public void closeOrder(WechatPayCloseOrderRequest request) {
        String requestPath = "https://api.mch.weixin.qq.com/v3/pay/transactions/out-trade-no/" + UrlEncoder.urlEncode(request.getOutTradeNo()) + "/close";
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
     * 交易成功回调通知
     *
     * @param wxPayNotifyRequest
     */
    public WechatPayTransactionNotifyParseResponse transactionNotify(WechatPayNotifyParseRequest wxPayNotifyRequest) {
        return notificationParser.parse(wxPayNotifyRequest.toRequestParam(), WechatPayTransactionNotifyParseResponse.class);
    }


    /**
     * 申请退款
     *
     * @param request
     * @return
     */
    public WechatPayRefund createRefund(WechatPayRefundCreateRequest request) {
        String requestPath = "https://api.mch.weixin.qq.com/v3/refund/domestic/refunds";
        if (this.hostName != null) {
            requestPath = requestPath.replaceFirst(HostName.API.getValue(), this.hostName.getValue());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.addHeader("Accept", MediaType.APPLICATION_JSON.getValue());
        headers.addHeader("Content-Type", MediaType.APPLICATION_JSON.getValue());
        HttpRequest httpRequest = (new HttpRequest.Builder()).httpMethod(HttpMethod.POST).url(requestPath).headers(headers).body(this.createRequestBody(request)).build();
        HttpResponse<WechatPayRefund> httpResponse = this.httpClient.execute(httpRequest, WechatPayRefund.class);
        return httpResponse.getServiceResponse();
    }

    /**
     * 查询单笔退款（通过商户退款单号）
     *
     * @param request
     * @return
     */
    public WechatPayRefund queryRefundByOutRefundNo(WechatPayQueryRefundByOutNoRequest request) {
        String requestPath = "https://api.mch.weixin.qq.com/v3/refund/domestic/refunds/" + UrlEncoder.urlEncode(request.getOutRefundNo());
        QueryParameter queryParameter = new QueryParameter();
//        if (request.getSubMchid() != null) {
//            queryParameter.add("sub_mchid", UrlEncoder.urlEncode(request.getSubMchid()));
//        }

        requestPath = requestPath + queryParameter.getQueryStr();
        if (this.hostName != null) {
            requestPath = requestPath.replaceFirst(HostName.API.getValue(), this.hostName.getValue());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.addHeader("Accept", MediaType.APPLICATION_JSON.getValue());
        headers.addHeader("Content-Type", MediaType.APPLICATION_JSON.getValue());
        HttpRequest httpRequest = (new HttpRequest.Builder()).httpMethod(HttpMethod.GET).url(requestPath).headers(headers).build();
        HttpResponse<WechatPayRefund> httpResponse = this.httpClient.execute(httpRequest, WechatPayRefund.class);
        return httpResponse.getServiceResponse();
    }


    /**
     * 退款成功回调
     *
     * @param wxPayNotifyRequest
     * @return
     */
    public WechatPayRefoundNotifyParseResponse refundNotify(WechatPayNotifyParseRequest wxPayNotifyRequest) {
        return notificationParser.parse(wxPayNotifyRequest.toRequestParam(), WechatPayRefoundNotifyParseResponse.class);
    }


}
