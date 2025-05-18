package com.trionesdev.payment.wechatpay.v3.payment;

import com.trionesdev.payment.wechatpay.v3.WechatPayConfig;
import com.trionesdev.payment.wechatpay.v3.payment.app.WechatPayApp;
import com.trionesdev.payment.wechatpay.v3.payment.h5.WechatPayH5;
import com.trionesdev.payment.wechatpay.v3.payment.jsapi.WechatPayJsApi;
import com.trionesdev.payment.wechatpay.v3.payment.nativepay.WechatPayNative;

/**
 * 微信支付产品
 */
public class WechatPayPayment extends WechatPayPaymentCommons{
    private final WechatPayH5 h5Instance;
    private final WechatPayJsApi jsApiInstance;
    private final WechatPayNative nativeInstance;
    private final WechatPayApp appInstance;
    private final WechatPayConfig wxPayConfig;

    public WechatPayPayment(WechatPayConfig config) {
        super(config);
        this.wxPayConfig = config;
        this.h5Instance = new WechatPayH5(wxPayConfig);
        this.jsApiInstance = new WechatPayJsApi(wxPayConfig);
        this.nativeInstance = new WechatPayNative(wxPayConfig);
        this.appInstance = new WechatPayApp(wxPayConfig);
    }

    public WechatPayPayment(WechatPayH5 h5Instance, WechatPayJsApi jsApiInstance, WechatPayNative nativeInstance, WechatPayApp appInstance, WechatPayConfig wxPayConfig) {
        super(wxPayConfig);
        this.h5Instance = h5Instance;
        this.jsApiInstance = jsApiInstance;
        this.nativeInstance = nativeInstance;
        this.appInstance = appInstance;
        this.wxPayConfig = wxPayConfig;
    }

    public WechatPayH5 getH5() {
        return h5Instance;
    }

    public WechatPayJsApi getJsApi() {
        return jsApiInstance;
    }

    public WechatPayNative getNative() {
        return nativeInstance;
    }
    public WechatPayApp getApp() {
        return appInstance;
    }
}
