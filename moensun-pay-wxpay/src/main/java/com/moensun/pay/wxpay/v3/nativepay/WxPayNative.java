package com.moensun.pay.wxpay.v3.nativepay;

import com.moensun.pay.wxpay.v3.WxPayBase;
import com.moensun.pay.wxpay.v3.WxPayConfig;
import com.moensun.pay.wxpay.v3.nativepay.model.WxPayNativeCreateOrderRequest;
import com.moensun.pay.wxpay.v3.nativepay.model.WxPayNativeCreateOrderResponse;
import com.moensun.pay.wxpay.v3.model.notify.WxPayNativeQueryOrderByIdRequest;
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
        PrepayResponse response = nativePayService.prepay(request.toPrepayRequest(wxPayConfig));
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
}
