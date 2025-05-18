package com.trionesdev.payment.wechatpay.v3;

import com.trionesdev.payment.wechatpay.v3.operation.WechatPayOperation;
import com.trionesdev.payment.wechatpay.v3.payment.WechatPayPayment;
import com.trionesdev.payment.wechatpay.v3.payment.app.WechatPayApp;
import com.trionesdev.payment.wechatpay.v3.payment.h5.WechatPayH5;
import com.trionesdev.payment.wechatpay.v3.payment.jsapi.WechatPayJsApi;
import com.trionesdev.payment.wechatpay.v3.payment.nativepay.WechatPayNative;
import lombok.Getter;

import java.util.Optional;

public class WechatPay  {

    private final WechatPayConfig wxPayConfig;
    @Getter
    private final WechatPayPayment payment;
    @Getter
    private final WechatPayOperation operation;

    public WechatPay(WechatPayConfig wxPayConfig) {
        this.wxPayConfig = wxPayConfig;
        this.payment = new WechatPayPayment(wxPayConfig);
        this.operation = new WechatPayOperation(wxPayConfig);
    }


    public String transactionNotifyUrl(String code) {
        return Optional.ofNullable(wxPayConfig.getTransactionNotifyUrls()).map(t -> t.get(code)).orElse(null);
    }


    public String refundNotifyUrl(String code) {
        return Optional.ofNullable(wxPayConfig.getRefundNotifyUrls()).map(t -> t.get(code)).orElse(null);
    }

}
