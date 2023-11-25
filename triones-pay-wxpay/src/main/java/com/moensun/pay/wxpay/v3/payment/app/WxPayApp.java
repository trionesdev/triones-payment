package com.moensun.pay.wxpay.v3.payment.app;

import com.moensun.pay.wxpay.v3.payment.WxPayBase;
import com.moensun.pay.wxpay.v3.payment.WxPayConfig;
import com.moensun.pay.wxpay.v3.payment.app.model.WxPayAppCreateOrderRequest;
import com.moensun.pay.wxpay.v3.payment.app.model.WxPayAppCreateOrderResponse;
import com.wechat.pay.java.service.payments.app.AppService;
import com.wechat.pay.java.service.payments.app.model.PrepayResponse;

public class WxPayApp extends WxPayBase {
    private final AppService appService;

    public WxPayApp(WxPayConfig wxPayConfig) {
        super(wxPayConfig);
        this.appService = new AppService.Builder().config(config).build();
    }

    /**
     * APP下单API
     * @param request
     * @return
     */
    public WxPayAppCreateOrderResponse createOrder(WxPayAppCreateOrderRequest request) {
        PrepayResponse response = appService.prepay(request.toSdkRequest(wxPayConfig));
        return WxPayAppConvertMapper.INSTANCE.from(response);
    }
}
