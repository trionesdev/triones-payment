package com.trionesdev.payment.wechatpay.v3;

import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayNotifyParseRequest;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayRefoundNotifyParseResponse;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayTransactionNotifyParseResponse;
import com.trionesdev.payment.wechatpay.v3.payment.app.WechatPayApp;
import com.trionesdev.payment.wechatpay.v3.payment.h5.WechatPayH5;
import com.trionesdev.payment.wechatpay.v3.payment.jsapi.WechatPayJsApi;
import com.trionesdev.payment.wechatpay.v3.payment.model.WechatPayCloseOrderRequest;
import com.trionesdev.payment.wechatpay.v3.payment.nativepay.WechatPayNative;

public interface WechatPayTemplate {

    String transactionNotifyUrl(String code);

    String refundNotifyUrl(String code);

    WechatPayH5 getH5();

    WechatPayJsApi getJsApi();

    WechatPayNative getNative();

    WechatPayApp getApp();


    void closeOrder(WechatPayCloseOrderRequest request);

    WechatPayTransactionNotifyParseResponse transactionNotify(WechatPayNotifyParseRequest wxPayNotifyRequest);

    WechatPayRefoundNotifyParseResponse refundNotify(WechatPayNotifyParseRequest wxPayNotifyRequest);
}
