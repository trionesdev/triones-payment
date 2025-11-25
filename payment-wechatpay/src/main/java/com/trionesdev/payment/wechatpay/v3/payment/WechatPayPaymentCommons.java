package com.trionesdev.payment.wechatpay.v3.payment;

import com.trionesdev.payment.wechatpay.v3.WechatPayBase;
import com.trionesdev.payment.wechatpay.v3.WechatPayConfig;
import com.trionesdev.payment.wechatpay.v3.model.WechatPayTransaction;
import com.trionesdev.payment.wechatpay.v3.payment.model.notify.WechatPayNotifyParseRequest;
import com.trionesdev.payment.wechatpay.v3.payment.model.notify.WechatPayRefoundNotifyParseResponse;
import com.trionesdev.payment.wechatpay.v3.payment.model.notify.WechatPayTransactionNotifyParseResponse;
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
     * 使用微信支付订单号查询订单详情。
     * <p>
     * 该方法通过微信支付API查询指定订单号的交易详情，支持自定义主机名配置。
     * </p>
     * 
     * @param request 查询订单请求参数，包含微信支付订单号及商户号等信息，详见 {@link WechatPayQueryOrderByIdRequest}
     * @return 返回查询到的交易详情对象，包含订单状态、金额等信息，详见 {@link WechatPayTransaction}
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
     * 使用商户订单号查询订单详情。
     * <p>
     * 该方法通过微信支付API查询指定商户订单号的交易详情，支持自定义主机名配置。
     * </p>
     * 
     * @param request 查询订单请求参数，包含商户订单号及商户号等信息，详见 {@link WechatPayQueryOrderByOutTradeNoRequest}
     * @return 返回查询到的交易详情对象，包含订单状态、金额等信息，详见 {@link WechatPayTransaction}
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
     * 关闭指定商户订单号的订单。
     * <p>
     * 该方法通过微信支付API关闭指定商户订单号的交易。
     * </p>
     * 
     * @param request 关闭订单请求参数，包含商户订单号等信息，详见 {@link WechatPayCloseOrderRequest}
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
     * 处理交易成功回调通知。
     * <p>
     * 该方法用于解析微信支付交易成功的异步回调通知数据。
     * </p>
     * 
     * @param wxPayNotifyRequest 微信支付回调通知请求参数，包含原始通知数据，详见 {@link WechatPayNotifyParseRequest}
     * @return 返回解析后的回调通知响应对象，包含结构化通知数据，详见 {@link WechatPayTransactionNotifyParseResponse}
     */
    public WechatPayTransactionNotifyParseResponse transactionNotify(WechatPayNotifyParseRequest wxPayNotifyRequest) {
        return notificationParser.parse(wxPayNotifyRequest.toRequestParam(), WechatPayTransactionNotifyParseResponse.class);
    }


    /**
     * 申请微信支付退款。
     * <p>
     * 该方法通过微信支付API发起退款申请，支持自定义主机名配置。
     * </p>
     * 
     * @param request 退款申请请求参数，包含退款详情信息，详见 {@link WechatPayRefundCreateRequest}
     * @return 返回退款申请的响应对象，包含退款处理结果，详见 {@link WechatPayRefund}
     */
    public WechatPayRefund createRefund(WechatPayRefundCreateRequest request) {
        String requestPath = "https://api.mch.weixin.qq.com/v3/refund/domestic/refunds";
        if (this.hostName != null) {
            requestPath = requestPath.replaceFirst(HostName.API.getValue(), this.hostName.getValue());
        }
        request.fill(this.wxPayConfig);
        HttpHeaders headers = new HttpHeaders();
        headers.addHeader("Accept", MediaType.APPLICATION_JSON.getValue());
        headers.addHeader("Content-Type", MediaType.APPLICATION_JSON.getValue());
        HttpRequest httpRequest = (new HttpRequest.Builder()).httpMethod(HttpMethod.POST).url(requestPath).headers(headers).body(this.createRequestBody(request)).build();
        HttpResponse<WechatPayRefund> httpResponse = this.httpClient.execute(httpRequest, WechatPayRefund.class);
        return httpResponse.getServiceResponse();
    }

    /**
     * 通过商户退款单号查询单笔退款详情。
     * <p>
     * 该方法通过微信支付API查询指定商户退款单号的退款处理状态和详情，支持自定义主机名配置。
     * </p>
     * 
     * @param request 查询退款请求参数，包含商户退款单号等信息，详见 {@link WechatPayQueryRefundByOutNoRequest}
     * @return 返回查询到的退款详情对象，包含退款状态、金额等信息，详见 {@link WechatPayRefund}
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
     * 处理退款成功回调通知。
     * <p>
     * 该方法用于解析微信支付退款成功的异步回调通知数据。
     * </p>
     * 
     * @param wxPayNotifyRequest 微信支付回调通知请求参数，包含原始通知数据，详见 {@link WechatPayNotifyParseRequest}
     * @return 返回解析后的退款回调通知响应对象，包含结构化通知数据，详见 {@link WechatPayRefoundNotifyParseResponse}
     */
    public WechatPayRefoundNotifyParseResponse refundNotify(WechatPayNotifyParseRequest wxPayNotifyRequest) {
        return notificationParser.parse(wxPayNotifyRequest.toRequestParam(), WechatPayRefoundNotifyParseResponse.class);
    }


}
