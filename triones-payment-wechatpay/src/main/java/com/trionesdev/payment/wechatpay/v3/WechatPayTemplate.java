package com.trionesdev.payment.wechatpay.v3;

import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayNotifyRequest;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayRefoundNotifyResponse;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayTransactionNotifyResponse;
import com.trionesdev.payment.wechatpay.v3.payment.app.WechatPayApp;
import com.trionesdev.payment.wechatpay.v3.payment.h5.WechatPayH5;
import com.trionesdev.payment.wechatpay.v3.payment.jsapi.WechatPayJsApi;
import com.trionesdev.payment.wechatpay.v3.payment.nativepay.WechatPayNative;

public interface WechatPayTemplate {

    String transactionNotifyUrl(String code);

    String refundNotifyUrl(String code);

    WechatPayH5 getH5();

    WechatPayJsApi getJsApi();

    WechatPayNative getNative();

    WechatPayApp getApp();

    WechatPayTransactionNotifyResponse transactionNotify(WechatPayNotifyRequest wxPayNotifyRequest);

    WechatPayRefoundNotifyResponse refundNotify(WechatPayNotifyRequest wxPayNotifyRequest);
}
