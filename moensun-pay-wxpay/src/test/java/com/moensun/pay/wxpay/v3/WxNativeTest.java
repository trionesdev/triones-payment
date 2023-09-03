package com.moensun.pay.wxpay.v3;

import com.moensun.pay.wxpay.v3.model.Amount;
import com.moensun.pay.wxpay.v3.nativepay.WxPayNative;
import com.moensun.pay.wxpay.v3.nativepay.model.WxPayNativeCreateOrderRequest;
import com.moensun.pay.wxpay.v3.nativepay.model.WxPayNativeCreateOrderResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

public class WxNativeTest extends WxPayTest{

    @Test
    public void createOrder(){
        WxPayConfig config = wxPayConfig();
        WxPayNative wxPayNative = new WxPayNative(config);
        WxPayNativeCreateOrderRequest request = WxPayNativeCreateOrderRequest.builder()
                .outTradeNo(RandomStringUtils.randomAlphabetic(32))
                .amount(Amount.builder().total(1).build())
                .description("Native支付测试")
                .build();
        WxPayNativeCreateOrderResponse response = wxPayNative.createOrder(request);
        System.out.println(response);
    }
}
