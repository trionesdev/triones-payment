package com.trionesdev.payment.wechatpay.v3;

import com.trionesdev.payment.wechatpay.v3.payment.app.WechatPayApp;
import com.trionesdev.payment.wechatpay.v3.payment.h5.WechatPayH5;
import com.trionesdev.payment.wechatpay.v3.payment.jsapi.WechatPayJsApi;
import com.trionesdev.payment.wechatpay.v3.payment.nativepay.WechatPayNative;

import java.util.Optional;

public class WechatPay extends WechatPayBase implements WechatPayTemplate {
    private final WechatPayH5 h5Instance;
    private final WechatPayJsApi jsApiInstance;
    private final WechatPayNative nativeInstance;
    private final WechatPayApp appInstance;
    private final WechatPayConfig wxPayConfig;

    public WechatPay(WechatPayConfig wxPayConfig) {
        super(wxPayConfig);
        this.wxPayConfig = wxPayConfig;
        this.h5Instance = new WechatPayH5(wxPayConfig);
        this.jsApiInstance = new WechatPayJsApi(wxPayConfig);
        this.nativeInstance = new WechatPayNative(wxPayConfig);
        this.appInstance = new WechatPayApp(wxPayConfig);
    }

    @Override
    public String transactionNotifyUrl(String code) {
        return Optional.ofNullable(wxPayConfig.getTransactionNotifyUrls()).map(t -> t.get(code)).orElse(null);
    }

    @Override
    public String refundNotifyUrl(String code) {
        return Optional.ofNullable(wxPayConfig.getRefundNotifyUrls()).map(t -> t.get(code)).orElse(null);
    }

    @Override
    public WechatPayH5 getH5() {
        return this.h5Instance;
    }

    @Override
    public WechatPayJsApi getJsApi() {
        return this.jsApiInstance;
    }

    @Override
    public WechatPayNative getNative() {
        return this.nativeInstance;
    }

    @Override
    public WechatPayApp getApp() {
        return this.appInstance;
    }

}
