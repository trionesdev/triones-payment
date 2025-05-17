package com.trionesdev.payment.wechatpay.v3.payment.h5;

import com.trionesdev.payment.wechatpay.v3.payment.WechatPayBase;
import com.trionesdev.payment.wechatpay.v3.payment.WechatPayConfig;
import com.trionesdev.payment.wechatpay.v3.payment.h5.model.*;
import com.wechat.pay.java.service.payments.h5.H5Service;
import com.wechat.pay.java.service.payments.h5.model.PrepayResponse;
import com.wechat.pay.java.service.payments.model.Transaction;

/**
 * H5支付
 */
public class WechatPayH5 extends WechatPayBase {
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

    /**
     * 微信支付订单号查询
     *
     * @param request
     * @return
     */
    public WechatPayH5QueryOrderResponse queryOrderById(WechatPayH5QueryOrderByIdRequest request) {
        Transaction transaction = h5Service.queryOrderById(request.toSdkRequest());
        return WechatPayH5Convert.INSTANCE.from(transaction);
    }

    /**
     * 商户订单号查询
     *
     * @param request
     * @return
     */
    public WechatPayH5QueryOrderResponse queryOrderByOutTradeNo(WechatPayH5QueryOrderByOutTradeNoRequest request) {
        Transaction transaction = h5Service.queryOrderByOutTradeNo(request.toSdkRequest());
        return WechatPayH5Convert.INSTANCE.from(transaction);
    }

    /**
     * 关闭订单API
     *
     * @param request
     * @link <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_4_3.shtml">...</a>
     */
    public void closeOrder(WechatPayH5CloseOrderRequest request) {
        h5Service.closeOrder(request.toSdkRequest());
    }

}
