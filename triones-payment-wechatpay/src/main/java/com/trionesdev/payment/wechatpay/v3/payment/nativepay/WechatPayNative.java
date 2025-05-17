package com.trionesdev.payment.wechatpay.v3.payment.nativepay;

import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayNativeQueryOrderResponse;
import com.trionesdev.payment.wechatpay.v3.payment.WechatPayBase;
import com.trionesdev.payment.wechatpay.v3.payment.WechatPayConfig;
import com.trionesdev.payment.wechatpay.v3.payment.nativepay.model.*;
import com.wechat.pay.java.service.payments.model.Transaction;
import com.wechat.pay.java.service.payments.nativepay.NativePayService;
import com.wechat.pay.java.service.payments.nativepay.model.PrepayResponse;

/**
 * Native支付
 */
public class WechatPayNative extends WechatPayBase {
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

    /**
     * 微信支付订单号查询
     *
     * @param request
     * @return
     */
    public WechatPayNativeQueryOrderResponse queryOrderById(WechatPayNativeQueryOrderByIdRequest request) {
        Transaction transaction = nativePayService.queryOrderById(request.toSdkRequest());
        return WechatPayNativeConvert.INSTANCE.from(transaction);
    }

    public WechatPayNativeQueryOrderResponse queryOrderByOutTradeNo(WechatPayNativeQueryOrderByOutTradeNoRequest request) {
        Transaction transaction = nativePayService.queryOrderByOutTradeNo(request.toSdkRequest());
        return WechatPayNativeConvert.INSTANCE.from(transaction);
    }

    public void closeOrder(WechatPayNativeCloseOrderRequest request) {
        nativePayService.closeOrder(request.toSdkRequest());
    }
}
