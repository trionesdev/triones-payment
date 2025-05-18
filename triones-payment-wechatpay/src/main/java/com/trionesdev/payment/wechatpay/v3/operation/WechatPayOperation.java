package com.trionesdev.payment.wechatpay.v3.operation;

import com.trionesdev.payment.wechatpay.v3.WechatPayBase;
import com.trionesdev.payment.wechatpay.v3.WechatPayConfig;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayNotifyParseRequest;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayRefoundNotifyParseResponse;
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
     * 发起转账
     *
     * @param request
     * @return
     * @link https://pay.weixin.qq.com/doc/v3/merchant/4012716434
     */
    public WechatPayCreateTransferResponse createTransfer(WechatPayCreateTransferRequest request) {
        String requestPath = "https://api.mch.weixin.qq.com/v3/fund-app/mch-transfer/transfer-bills";

        if (this.hostName != null) {
            requestPath = requestPath.replaceFirst(HostName.API.getValue(), this.hostName.getValue());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.addHeader("Accept", MediaType.APPLICATION_JSON.getValue());
        headers.addHeader("Content-Type", MediaType.APPLICATION_JSON.getValue());
        HttpRequest httpRequest = (new HttpRequest.Builder()).httpMethod(HttpMethod.POST).url(requestPath).headers(headers).build();
        HttpResponse<WechatPayCreateTransferResponse> httpResponse = this.httpClient.execute(httpRequest, WechatPayCreateTransferResponse.class);
        return httpResponse.getServiceResponse();
    }

    /**
     * 撤销转账
     *
     * @param request
     * @return
     * @link https://pay.weixin.qq.com/doc/v3/merchant/4012716458
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
     * 商家转账回调通知
     *
     * @param wxPayNotifyRequest
     * @return
     * @link https://pay.weixin.qq.com/doc/v3/merchant/4012712115
     */
    public WechatPayTransferNotifyParseResponse transferNotify(WechatPayNotifyParseRequest wxPayNotifyRequest) {
        return notificationParser.parse(wxPayNotifyRequest.toRequestParam(), WechatPayTransferNotifyParseResponse.class);
    }

}
