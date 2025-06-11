package com.trionesdev.payment.wechatpay.v3.payment.app;

import com.trionesdev.payment.wechatpay.v3.WechatPayConfig;
import com.trionesdev.payment.wechatpay.v3.payment.WechatPayPaymentCommons;
import com.trionesdev.payment.wechatpay.v3.payment.app.model.WechatPayAppCreateOrderRequest;
import com.trionesdev.payment.wechatpay.v3.payment.app.model.WechatPayAppCreateOrderResponse;
import com.trionesdev.payment.wechatpay.v3.payment.app.model.WechatPayAppCreateOrderWithRequestPaymentResponse;
import com.wechat.pay.java.service.payments.app.AppService;
import com.wechat.pay.java.service.payments.app.AppServiceExtension;
import com.wechat.pay.java.service.payments.app.model.PrepayResponse;
import com.wechat.pay.java.service.payments.app.model.PrepayWithRequestPaymentResponse;

public class WechatPayApp extends WechatPayPaymentCommons {
    private final AppService appService;
    private final AppServiceExtension appServiceExtension;

    public WechatPayApp(WechatPayConfig wxPayConfig) {
        super(wxPayConfig);
        this.appService = new AppService.Builder().config(config).build();
        this.appServiceExtension = new AppServiceExtension.Builder().config(config).build();
    }

    /**
     * APP下单API
     *
     * @param request
     * @return
     */
    public WechatPayAppCreateOrderResponse createOrder(WechatPayAppCreateOrderRequest request) {
        PrepayResponse response = appService.prepay(request.toSdkRequest(wxPayConfig));
        return WechatPayAppCreateOrderResponse.builder().prepayId(response.getPrepayId()).build();
    }

    public WechatPayAppCreateOrderWithRequestPaymentResponse createOrderWithRequestPayment(WechatPayAppCreateOrderRequest request) {
        PrepayWithRequestPaymentResponse response = appServiceExtension.prepayWithRequestPayment(request.toSdkRequest(wxPayConfig));
        return WechatPayAppCreateOrderWithRequestPaymentResponse.builder()
                .prePayId(response.getPrepayId())
                .appId(response.getAppid())
                .timeStamp(response.getTimestamp())
                .nonceStr(response.getNonceStr())
                .packageStr(response.getPackageVal())
                .paySign(response.getSign())
                .signType("RSA")
                .build();
    }
}
