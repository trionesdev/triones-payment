package com.trionesdev.payment.wxpay.v3;

import com.trionesdev.payment.wxpay.v3.payment.WxPayConfig;
import com.trionesdev.payment.wxpay.v3.payment.app.WxPayApp;
import com.trionesdev.payment.wxpay.v3.payment.h5.WxPayH5;
import com.trionesdev.payment.wxpay.v3.payment.jsapi.WxPayJsApi;
import com.trionesdev.payment.wxpay.v3.payment.nativepay.WxPayNative;

import java.util.Map;
import java.util.Optional;

public class WxPay implements WxPayTemplate {
    private final WxPayH5 h5Instance;
    private final WxPayJsApi jsApiInstance;
    private final WxPayNative nativeInstance;
    private final WxPayApp appInstance;
    private final WxPayConfig wxPayConfig;

    public WxPay(WxPayConfig wxPayConfig) {
        this.wxPayConfig = wxPayConfig;
        this.h5Instance = new WxPayH5(wxPayConfig);
        this.jsApiInstance = new WxPayJsApi(wxPayConfig);
        this.nativeInstance = new WxPayNative(wxPayConfig);
        this.appInstance = new WxPayApp(wxPayConfig);
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
    public WxPayH5 getH5() {
        return this.h5Instance;
    }

    @Override
    public WxPayJsApi getJsApi() {
        return this.jsApiInstance;
    }

    @Override
    public WxPayNative getNative() {
        return this.nativeInstance;
    }

    @Override
    public WxPayApp getApp() {
        return this.appInstance;
    }
}
