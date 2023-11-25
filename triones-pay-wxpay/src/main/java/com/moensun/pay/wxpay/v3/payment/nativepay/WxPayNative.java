package com.moensun.pay.wxpay.v3.payment.nativepay;

import com.moensun.pay.wxpay.v3.payment.WxPayBase;
import com.moensun.pay.wxpay.v3.payment.WxPayConfig;
import com.moensun.pay.wxpay.v3.payment.nativepay.model.*;
import com.moensun.pay.wxpay.v3.model.notify.WxPayNativeQueryOrderResponse;
import com.wechat.pay.java.service.payments.model.Transaction;
import com.wechat.pay.java.service.payments.nativepay.NativePayService;
import com.wechat.pay.java.service.payments.nativepay.model.PrepayResponse;

/**
 * Native支付
 */
public class WxPayNative extends WxPayBase {
    private final NativePayService nativePayService;

    public WxPayNative(WxPayConfig wxPayConfig) {
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
    public WxPayNativeCreateOrderResponse createOrder(WxPayNativeCreateOrderRequest request) {
        PrepayResponse response = nativePayService.prepay(request.toSdkRequest(wxPayConfig));
        return WxPayNativeCreateOrderResponse.builder().codeUrl(response.getCodeUrl()).build();
    }

    /**
     * 微信支付订单号查询
     *
     * @param request
     * @return
     */
    public WxPayNativeQueryOrderResponse queryOrderById(WxPayNativeQueryOrderByIdRequest request) {
        Transaction transaction = nativePayService.queryOrderById(request.toSdkRequest());
        return WxPayNativeConvertMapper.INSTANCE.from(transaction);
    }

    public WxPayNativeQueryOrderResponse queryOrderByOutTradeNo(WxPayNativeQueryOrderByOutTradeNoRequest request) {
        Transaction transaction = nativePayService.queryOrderByOutTradeNo(request.toSdkRequest());
        return WxPayNativeConvertMapper.INSTANCE.from(transaction);
    }

    public void closeOrder(WxPayNativeCloseOrderRequest request) {
        nativePayService.closeOrder(request.toSdkRequest());
    }
}
