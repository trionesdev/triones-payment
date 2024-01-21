package com.trionesdev.payment.wxpay.v3.payment.h5;

import com.trionesdev.payment.wxpay.v3.payment.WxPayBase;
import com.trionesdev.payment.wxpay.v3.payment.WxPayConfig;
import com.trionesdev.payment.wxpay.v3.payment.h5.model.*;
import com.wechat.pay.java.service.payments.h5.H5Service;
import com.wechat.pay.java.service.payments.h5.model.PrepayResponse;
import com.wechat.pay.java.service.payments.model.Transaction;

/**
 * H5支付
 */
public class WxPayH5 extends WxPayBase {
    private final H5Service h5Service;

    public WxPayH5(WxPayConfig wxPayConfig) {
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
    public WxPayH5CreateOrderResponse createOrder(WxPayH5CreateOrderRequest request) {
        PrepayResponse response = h5Service.prepay(request.toSdkRequest(wxPayConfig));
        return WxPayH5CreateOrderResponse.builder().h5Url(response.getH5Url()).build();
    }

    /**
     * 微信支付订单号查询
     *
     * @param request
     * @return
     */
    public WxPayH5QueryOrderResponse queryOrderById(WxPayH5QueryOrderByIdRequest request) {
        Transaction transaction = h5Service.queryOrderById(request.toSdkRequest());
        return WxPayH5ConvertMapper.INSTANCE.from(transaction);
    }

    /**
     * 商户订单号查询
     *
     * @param request
     * @return
     */
    public WxPayH5QueryOrderResponse queryOrderByOutTradeNo(WxPayH5QueryOrderByOutTradeNoRequest request) {
        Transaction transaction = h5Service.queryOrderByOutTradeNo(request.toSdkRequest());
        return WxPayH5ConvertMapper.INSTANCE.from(transaction);
    }

    /**
     * 关闭订单API
     *
     * @param request
     * @link <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_4_3.shtml">...</a>
     */
    public void closeOrder(WxPayH5CloseOrderRequest request) {
        h5Service.closeOrder(request.toSdkRequest());
    }

}
