package com.trionesdev.payment.wechatpay.v3.payment.app;

import com.trionesdev.payment.wechatpay.v3.payment.WechatPayConfig;
import com.trionesdev.payment.wechatpay.v3.payment.WechatPayNotify;
import com.trionesdev.payment.wechatpay.v3.payment.app.model.WechatPayAppCreateOrderRequest;
import com.trionesdev.payment.wechatpay.v3.payment.app.model.WechatPayAppCreateOrderResponse;
import com.wechat.pay.java.service.payments.app.AppService;
import com.wechat.pay.java.service.payments.app.model.PrepayResponse;

public class WechatPayApp extends WechatPayNotify {
    private final AppService appService;

    public WechatPayApp(WechatPayConfig wxPayConfig) {
        super(wxPayConfig);
        this.appService = new AppService.Builder().config(config).build();
    }

    /**
     * APP下单API
     * @param request
     * @return
     */
    public WechatPayAppCreateOrderResponse createOrder(WechatPayAppCreateOrderRequest request) {
        PrepayResponse response = appService.prepay(request.toSdkRequest(wxPayConfig));
        return WechatPayAppConvert.INSTANCE.from(response);
    }
}
