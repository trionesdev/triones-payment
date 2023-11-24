package com.moensun.pay.wxpay.v3;

import com.moensun.pay.wxpay.v3.payment.app.WxPayApp;
import com.moensun.pay.wxpay.v3.payment.h5.WxPayH5;
import com.moensun.pay.wxpay.v3.payment.jsapi.WxPayJsApi;
import com.moensun.pay.wxpay.v3.payment.nativepay.WxPayNative;

public interface WxPayTemplate {

    WxPayH5 getH5Instance();

    WxPayJsApi getJsApiInstance();

    WxPayNative getNativeInstance();

    WxPayApp getAppInstance();
}
