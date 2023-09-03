package com.moensun.pay.wxpay.v3;

import com.moensun.pay.wxpay.v3.h5.WxPayH5;
import com.moensun.pay.wxpay.v3.h5.model.WxPayH5CreateOrderRequest;
import com.moensun.pay.wxpay.v3.h5.model.WxPayH5CreateOrderResponse;
import com.moensun.pay.wxpay.v3.model.Amount;
import com.moensun.pay.wxpay.v3.model.SceneInfo;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

public class WxPayH5Test extends WxPayTest {

    @Test
    public void createOrder() {
        WxPayConfig config = wxPayConfig();
        WxPayH5 wxPayH5 = new WxPayH5(config);
        WxPayH5CreateOrderRequest createOrderRequest = WxPayH5CreateOrderRequest.builder()
                .outTradeNo(RandomStringUtils.randomAlphabetic(32))
                .amount(Amount.builder().total(1).build())
                .description("H5支付测试")
                .sceneInfo(SceneInfo.builder().payerClientIp("222.93.50.12").build())
                .build();
        WxPayH5CreateOrderResponse response = wxPayH5.createOrder(createOrderRequest);
        System.out.println(response);
    }
}
