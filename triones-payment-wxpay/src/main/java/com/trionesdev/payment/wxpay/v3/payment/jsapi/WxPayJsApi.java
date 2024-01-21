package com.trionesdev.payment.wxpay.v3.payment.jsapi;

import com.trionesdev.payment.wxpay.v3.payment.WxPayBase;
import com.trionesdev.payment.wxpay.v3.payment.WxPayConfig;
import com.trionesdev.payment.wxpay.v3.payment.jsapi.model.WxPayJsApiCreateOrderRequest;
import com.trionesdev.payment.wxpay.v3.payment.jsapi.model.WxPayJsApiCreateOrderResponse;
import com.trionesdev.payment.wxpay.v3.payment.jsapi.model.WxPayJsApiCreateOrderWithRequestPaymentResponse;
import com.wechat.pay.java.service.payments.jsapi.JsapiService;
import com.wechat.pay.java.service.payments.jsapi.JsapiServiceExtension;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayResponse;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayWithRequestPaymentResponse;

/**
 * 支付JSAPI
 */
public class WxPayJsApi extends WxPayBase {
    private final JsapiService jsapiService;
    private final JsapiServiceExtension jsapiServiceExtension;

    public WxPayJsApi(WxPayConfig wxPayConfig) {
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
    public WxPayJsApiCreateOrderResponse createOrder(WxPayJsApiCreateOrderRequest request) {
        PrepayResponse response = jsapiService.prepay(request.toPrepayRequest());
        return WxPayJsApiCreateOrderResponse.builder().prepayId(response.getPrepayId()).build();
    }

    /**
     * JSAPI调起支付API
     *
     * @param request
     * @return
     * @link <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_4.shtml">...</a>
     */
    public WxPayJsApiCreateOrderWithRequestPaymentResponse createOrderWithRequestPayment(WxPayJsApiCreateOrderRequest request) {
        PrepayWithRequestPaymentResponse response = jsapiServiceExtension.prepayWithRequestPayment(request.toPrepayRequest());
        return WxPayJsApiCreateOrderWithRequestPaymentResponse.builder()
                .appId(response.getAppId())
                .timeStamp(response.getTimeStamp())
                .nonceStr(response.getNonceStr())
                .packageStr(response.getNonceStr())
                .paySign(response.getPaySign())
                .build();
    }


}
