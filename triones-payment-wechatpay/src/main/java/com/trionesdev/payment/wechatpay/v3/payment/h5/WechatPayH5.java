package com.trionesdev.payment.wechatpay.v3.payment.h5;

import com.trionesdev.payment.wechatpay.v3.WechatPayConfig;
import com.trionesdev.payment.wechatpay.v3.payment.WechatPayPaymentCommons;
import com.trionesdev.payment.wechatpay.v3.payment.h5.model.WechatPayH5CreateOrderRequest;
import com.trionesdev.payment.wechatpay.v3.payment.h5.model.WechatPayH5CreateOrderResponse;
import com.wechat.pay.java.service.payments.h5.H5Service;
import com.wechat.pay.java.service.payments.h5.model.PrepayResponse;

/**
 * H5支付
 */
public class WechatPayH5 extends WechatPayPaymentCommons {
    private final H5Service h5Service;

    public WechatPayH5(WechatPayConfig wxPayConfig) {
        super(wxPayConfig);
        h5Service = new H5Service.Builder().config(config).build();
    }

    /**
     * 创建订单
     *
     * @param request
     * @return
     * @link <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_3_1.shtml">...</a>
     */
    public WechatPayH5CreateOrderResponse createOrder(WechatPayH5CreateOrderRequest request) {
        PrepayResponse response = h5Service.prepay(request.toSdkRequest(wxPayConfig));
        return WechatPayH5CreateOrderResponse.builder().h5Url(response.getH5Url()).build();
    }


}
