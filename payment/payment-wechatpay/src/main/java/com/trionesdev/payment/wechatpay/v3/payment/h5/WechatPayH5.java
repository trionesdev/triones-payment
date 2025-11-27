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
     * 调用微信支付H5下单接口。
     * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_3_1.shtml">官方文档</a>
     * <p>
     * 该方法用于创建微信支付H5支付订单，并返回支付页面跳转链接。
     * </p>
     * 
     * @param request H5下单请求参数，包含支付相关详情，详见 {@link WechatPayH5CreateOrderRequest}
     * @return 返回H5下单响应对象，包含支付页面跳转链接，详见 {@link WechatPayH5CreateOrderResponse}
     */
    public WechatPayH5CreateOrderResponse createOrder(WechatPayH5CreateOrderRequest request) {
        PrepayResponse response = h5Service.prepay(request.toSdkRequest(wxPayConfig));
        return WechatPayH5CreateOrderResponse.builder().h5Url(response.getH5Url()).build();
    }


}
