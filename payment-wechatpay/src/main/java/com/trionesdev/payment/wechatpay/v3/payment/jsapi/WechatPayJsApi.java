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
     * 调用微信支付JSAPI下单接口。
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_1.shtml">官方文档</a>
     * <p>
     * 该方法用于创建微信支付JSAPI支付订单，并返回预支付交易单信息。
     * </p>
     * 
     * @param request JSAPI下单请求参数，包含支付相关详情，详见 {@link WechatPayJsApiCreateOrderRequest}
     * @return 返回JSAPI下单响应对象，包含预支付交易单ID，详见 {@link WechatPayJsApiCreateOrderResponse}
     */
    public WechatPayJsApiCreateOrderResponse createOrder(WechatPayJsApiCreateOrderRequest request) {
        PrepayResponse response = jsapiService.prepay(request.toPrepayRequest(wxPayConfig));
        return WechatPayJsApiCreateOrderResponse.builder().prepayId(response.getPrepayId()).build();
    }

    /**
     * 调用微信支付JSAPI调起支付接口。
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_4.shtml">官方文档</a>
     * <p>
     * 该方法用于创建微信支付JSAPI支付订单并返回调起支付所需的参数信息。
     * </p>
     * 
     * @param request JSAPI调起支付请求参数，包含支付相关详情，详见 {@link WechatPayJsApiCreateOrderRequest}
     * @return 返回JSAPI调起支付响应对象，包含调起微信支付所需的签名、时间戳、随机字符串等信息，详见 {@link WechatPayJsApiCreateOrderWithRequestPaymentResponse}
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
