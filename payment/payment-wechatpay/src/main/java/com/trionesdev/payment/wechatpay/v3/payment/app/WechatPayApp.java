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
     * 调用微信支付APP下单接口。
     * <p>
     * 该方法用于创建微信支付APP支付订单，并返回预支付交易单信息。
     * </p>
     * 
     * @param request APP下单请求参数，包含支付相关详情，详见 {@link WechatPayAppCreateOrderRequest}
     * @return 返回APP下单响应对象，包含预支付交易单ID，详见 {@link WechatPayAppCreateOrderResponse}
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
