package com.trionesdev.payment.wechatpay.v3.payment.nativepay;

import com.trionesdev.payment.wechatpay.v3.WechatPayConfig;
import com.trionesdev.payment.wechatpay.v3.payment.WechatPayPaymentCommons;
import com.trionesdev.payment.wechatpay.v3.payment.nativepay.model.WechatPayNativeCreateOrderRequest;
import com.trionesdev.payment.wechatpay.v3.payment.nativepay.model.WechatPayNativeCreateOrderResponse;
import com.wechat.pay.java.service.payments.nativepay.NativePayService;
import com.wechat.pay.java.service.payments.nativepay.model.PrepayResponse;

/**
 * Native支付
 */
public class WechatPayNative extends WechatPayPaymentCommons {
    private final NativePayService nativePayService;

    public WechatPayNative(WechatPayConfig wxPayConfig) {
        super(wxPayConfig);
        this.nativePayService = new NativePayService.Builder().config(config).build();
    }

    /**
     * 调用微信支付Native下单接口。
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_4_1.shtml">官方文档</a>
     * <p>
     * 该方法用于创建微信支付Native支付订单，并返回二维码链接供用户扫码支付。
     * </p>
     * 
     * @param request Native下单请求参数，包含支付相关详情，详见 {@link WechatPayNativeCreateOrderRequest}
     * @return 返回Native下单响应对象，包含二维码链接信息，详见 {@link WechatPayNativeCreateOrderResponse}
     */
    public WechatPayNativeCreateOrderResponse createOrder(WechatPayNativeCreateOrderRequest request) {
        PrepayResponse response = nativePayService.prepay(request.toSdkRequest(wxPayConfig));
        return WechatPayNativeCreateOrderResponse.builder().codeUrl(response.getCodeUrl()).build();
    }

}
