package com.trionesdev.payment.wechatpay.v3;

import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayNotifyRequest;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayRefoundNotifyResponse;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayTransactionNotifyResponse;
import com.trionesdev.payment.wechatpay.v3.payment.WechatPayConfig;
import com.trionesdev.payment.wechatpay.v3.payment.WechatPayNotify;
import com.trionesdev.payment.wechatpay.v3.payment.app.WechatPayApp;
import com.trionesdev.payment.wechatpay.v3.payment.h5.WechatPayH5;
import com.trionesdev.payment.wechatpay.v3.payment.jsapi.WechatPayJsApi;
import com.trionesdev.payment.wechatpay.v3.payment.nativepay.WechatPayNative;

import java.util.Optional;

public class WechatPay implements WechatPayTemplate {
    private final WechatPayH5 h5Instance;
    private final WechatPayJsApi jsApiInstance;
    private final WechatPayNative nativeInstance;
    private final WechatPayApp appInstance;
    private final WechatPayNotify wxPayNotify;
    private final WechatPayConfig wxPayConfig;

    public WechatPay(WechatPayConfig wxPayConfig) {
        this.wxPayConfig = wxPayConfig;
        this.h5Instance = new WechatPayH5(wxPayConfig);
        this.jsApiInstance = new WechatPayJsApi(wxPayConfig);
        this.nativeInstance = new WechatPayNative(wxPayConfig);
        this.appInstance = new WechatPayApp(wxPayConfig);
        this.wxPayNotify = new WechatPayNotify(wxPayConfig);
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

    /**
     * 交易成功回调通知
     *
     * @param wxPayNotifyRequest
     */
    public WechatPayTransactionNotifyResponse transactionNotify(WechatPayNotifyRequest wxPayNotifyRequest) {
        return wxPayNotify.transactionNotify(wxPayNotifyRequest);
    }

    /**
     * 退款成功回调
     *
     * @param wxPayNotifyRequest
     * @return
     */
    public WechatPayRefoundNotifyResponse refundNotify(WechatPayNotifyRequest wxPayNotifyRequest) {
        return wxPayNotify.refundNotify(wxPayNotifyRequest);
    }

}
