package com.trionesdev.payment.wxpay.v3;

import com.trionesdev.payment.wxpay.v3.payment.WxPayConfig;
import com.trionesdev.payment.wxpay.v3.payment.app.WxPayApp;
import com.trionesdev.payment.wxpay.v3.payment.h5.WxPayH5;
import com.trionesdev.payment.wxpay.v3.payment.jsapi.WxPayJsApi;
import com.trionesdev.payment.wxpay.v3.payment.nativepay.WxPayNative;

public class WxPay implements WxPayTemplate {
    private final WxPayH5 h5Instance;
    private final WxPayJsApi jsApiInstance;
    private final WxPayNative nativeInstance;
    private final WxPayApp appInstance;

    public WxPay(WxPayConfig wxPayConfig) {
        this.h5Instance = new WxPayH5(wxPayConfig);
        this.jsApiInstance = new WxPayJsApi(wxPayConfig);
        this.nativeInstance = new WxPayNative(wxPayConfig);
        this.appInstance = new WxPayApp(wxPayConfig);
    }

    @Override
    public WxPayH5 getH5Instance() {
        return this.h5Instance;
    }

    @Override
    public WxPayJsApi getJsApiInstance() {
        return this.jsApiInstance;
    }

    @Override
    public WxPayNative getNativeInstance() {
        return this.nativeInstance;
    }

    @Override
    public WxPayApp getAppInstance() {
        return this.appInstance;
    }
}
