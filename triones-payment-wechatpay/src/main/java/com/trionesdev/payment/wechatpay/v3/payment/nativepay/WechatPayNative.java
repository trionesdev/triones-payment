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
     * Native下单API
     *
     * @param request
     * @return
     * @link <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_4_1.shtml">...</a>
     */
    public WechatPayNativeCreateOrderResponse createOrder(WechatPayNativeCreateOrderRequest request) {
        PrepayResponse response = nativePayService.prepay(request.toSdkRequest(wxPayConfig));
        return WechatPayNativeCreateOrderResponse.builder().codeUrl(response.getCodeUrl()).build();
    }

}
