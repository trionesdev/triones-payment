package com.trionesdev.payment.wechatpay.v3.operation;

import com.trionesdev.payment.wechatpay.v3.WechatPayBase;
import com.trionesdev.payment.wechatpay.v3.WechatPayConfig;
import com.trionesdev.payment.wechatpay.v3.payment.model.notify.WechatPayNotifyParseRequest;
import com.trionesdev.payment.wechatpay.v3.operation.model.*;
import com.wechat.pay.java.core.http.*;

/**
 * 运营工具
 */
public class WechatPayOperation extends WechatPayBase {
    public WechatPayOperation(WechatPayConfig wxPayConfig) {
        super(wxPayConfig);
    }

    /**
     * 发起转账操作。
     * <a href="https://pay.weixin.qq.com/doc/v3/merchant/4012716434">官方文档</a>
     * <p>
     * 该方法通过微信支付API发起转账请求，支持自定义主机名配置。
     * </p>
     *
     * @param request 转账请求参数，包含必要的转账详情，详见 {@link WechatPayCreateTransferRequest}
     * @return 返回转账操作的响应对象，包含处理结果和状态信息，详见 {@link WechatPayCreateTransferResponse}
     */
    public WechatPayCreateTransferResponse createTransfer(WechatPayCreateTransferRequest request) {
        String requestPath = "https://api.mch.weixin.qq.com/v3/fund-app/mch-transfer/transfer-bills";

        if (this.hostName != null) {
            requestPath = requestPath.replaceFirst(HostName.API.getValue(), this.hostName.getValue());
        }
        request.initialize(this.wxPayConfig);
        HttpHeaders headers = new HttpHeaders();
        headers.addHeader("Accept", MediaType.APPLICATION_JSON.getValue());
        headers.addHeader("Content-Type", MediaType.APPLICATION_JSON.getValue());
        HttpRequest httpRequest = (new HttpRequest.Builder()).httpMethod(HttpMethod.POST).url(requestPath).headers(headers).body(createRequestBody(request)).build();
        HttpResponse<WechatPayCreateTransferResponse> httpResponse = this.httpClient.execute(httpRequest, WechatPayCreateTransferResponse.class);
        return httpResponse.getServiceResponse();
    }

    /**
     * 撤销已发起的转账操作。
     * <a href="https://pay.weixin.qq.com/doc/v3/merchant/4012716458">官方文档</a>
     * <p>
     * 该方法通过微信支付API撤销指定商户转账单号的转账交易，支持自定义主机名配置。
     * </p>
     *
     * @param request 撤销转账请求参数，包含商户转账单号等信息，详见 {@link WechatPayCancelTransferRequest}
     * @return 返回撤销转账操作的响应对象，包含撤销结果信息，详见 {@link WechatPayCancelTransferResponse}
     */
    public WechatPayCancelTransferResponse cancelTransfer(WechatPayCancelTransferRequest request) {
        String requestPath = "https://api.mch.weixin.qq.com/v3/fund-app/mch-transfer/transfer-bills/out-bill-no/" + UrlEncoder.urlEncode(request.getOutBillNo()) + "/cancel";

        if (this.hostName != null) {
            requestPath = requestPath.replaceFirst(HostName.API.getValue(), this.hostName.getValue());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.addHeader("Accept", MediaType.APPLICATION_JSON.getValue());
        headers.addHeader("Content-Type", MediaType.APPLICATION_JSON.getValue());
        HttpRequest httpRequest = (new HttpRequest.Builder()).httpMethod(HttpMethod.POST).url(requestPath).headers(headers).build();
        HttpResponse<WechatPayCancelTransferResponse> httpResponse = this.httpClient.execute(httpRequest, WechatPayCancelTransferResponse.class);
        return httpResponse.getServiceResponse();
    }

    /**
     * 处理商家转账回调通知。
     * <a href="https://pay.weixin.qq.com/doc/v3/merchant/4012712115">官方文档</a>
     * <p>
     * 该方法用于解析微信支付商家转账的异步回调通知数据。
     * </p>
     *
     * @param wxPayNotifyRequest 微信支付回调通知请求参数，包含原始通知数据，详见 {@link WechatPayNotifyParseRequest}
     * @return 返回解析后的回调通知响应对象，包含结构化通知数据，详见 {@link WechatPayTransferNotifyParseResponse}
     */
    public WechatPayTransferNotifyParseResponse transferNotify(WechatPayNotifyParseRequest wxPayNotifyRequest) {
        return notificationParser.parse(wxPayNotifyRequest.toRequestParam(), WechatPayTransferNotifyParseResponse.class);
    }

}
