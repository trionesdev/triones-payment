package com.trionesdev.payment.wechatpay.v3.payment.jsapi;

import com.trionesdev.payment.wechatpay.v3.WechatPayConfig;
import com.trionesdev.payment.wechatpay.v3.payment.WechatPayPaymentCommons;
import com.trionesdev.payment.wechatpay.v3.payment.jsapi.model.WechatPayJsApiCreateOrderRequest;
import com.trionesdev.payment.wechatpay.v3.payment.jsapi.model.WechatPayJsApiCreateOrderResponse;
import com.trionesdev.payment.wechatpay.v3.payment.jsapi.model.WechatPayJsApiCreateOrderWithRequestPaymentResponse;
import com.wechat.pay.java.service.payments.jsapi.JsapiService;
import com.wechat.pay.java.service.payments.jsapi.JsapiServiceExtension;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayResponse;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayWithRequestPaymentResponse;

/**
 * 支付JSAPI
 */
public class WechatPayJsApi extends WechatPayPaymentCommons {
    private final JsapiService jsapiService;
    private final JsapiServiceExtension jsapiServiceExtension;

    public WechatPayJsApi(WechatPayConfig wxPayConfig) {
        super(wxPayConfig);
        this.jsapiService = new JsapiService.Builder().config(config).build();
        this.jsapiServiceExtension = new JsapiServiceExtension.Builder().config(config).build();
    }

    /**
     * 创建订单
     *
     * @param request
     * @return
     * @link <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_1.shtml">...</a>
     */
    public WechatPayJsApiCreateOrderResponse createOrder(WechatPayJsApiCreateOrderRequest request) {
        PrepayResponse response = jsapiService.prepay(request.toPrepayRequest(wxPayConfig));
        return WechatPayJsApiCreateOrderResponse.builder().prepayId(response.getPrepayId()).build();
    }

    /**
     * JSAPI调起支付API
     *
     * @param request
     * @return
     * @link <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_4.shtml">...</a>
     */
    public WechatPayJsApiCreateOrderWithRequestPaymentResponse createOrderWithRequestPayment(WechatPayJsApiCreateOrderRequest request) {
        PrepayWithRequestPaymentResponse response = jsapiServiceExtension.prepayWithRequestPayment(request.toPrepayRequest(wxPayConfig));
        return WechatPayJsApiCreateOrderWithRequestPaymentResponse.builder()
                .appId(response.getAppId())
                .timeStamp(response.getTimeStamp())
                .nonceStr(response.getNonceStr())
                .packageStr(response.getPackageVal())
                .paySign(response.getPaySign())
                .signType("RSA")
                .build();
    }


}
