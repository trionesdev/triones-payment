package com.moensun.pay.wxpay.v3;

import com.moensun.pay.wxpay.v3.model.nativepay.WxPayNativeCreateOrderRequest;
import com.moensun.pay.wxpay.v3.model.nativepay.WxPayNativeCreateOrderResponse;
import com.wechat.pay.java.service.payments.nativepay.NativePayService;
import com.wechat.pay.java.service.payments.nativepay.model.PrepayResponse;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Native支付
 */
public class WxPayNative extends WxPayBase {
    private  NativePayService nativePayService;

    /**
     * Native下单API
     *
     * @param request
     * @return
     * @link <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_4_1.shtml">...</a>
     */
    public WxPayNativeCreateOrderResponse createOrder(WxPayNativeCreateOrderRequest request) {
        PrepayResponse response = nativePayService.prepay(request.toPrepayRequest());
        return WxPayNativeCreateOrderResponse.builder().codeUrl(response.getCodeUrl()).build();
    }
}
