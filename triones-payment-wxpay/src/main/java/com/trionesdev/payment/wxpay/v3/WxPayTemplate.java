package com.trionesdev.payment.wxpay.v3;

import com.trionesdev.payment.wxpay.v3.model.notify.WxPayNotifyRequest;
import com.trionesdev.payment.wxpay.v3.model.notify.WxPayRefoundNotifyResponse;
import com.trionesdev.payment.wxpay.v3.model.notify.WxPayTransactionNotifyResponse;
import com.trionesdev.payment.wxpay.v3.payment.app.WxPayApp;
import com.trionesdev.payment.wxpay.v3.payment.h5.WxPayH5;
import com.trionesdev.payment.wxpay.v3.payment.jsapi.WxPayJsApi;
import com.trionesdev.payment.wxpay.v3.payment.nativepay.WxPayNative;

public interface WxPayTemplate {

    String transactionNotifyUrl(String code);

    String refundNotifyUrl(String code);

    WxPayH5 getH5();

    WxPayJsApi getJsApi();

    WxPayNative getNative();

    WxPayApp getApp();

    WxPayTransactionNotifyResponse transactionNotify(WxPayNotifyRequest wxPayNotifyRequest);

    WxPayRefoundNotifyResponse refundNotify(WxPayNotifyRequest wxPayNotifyRequest);
}
