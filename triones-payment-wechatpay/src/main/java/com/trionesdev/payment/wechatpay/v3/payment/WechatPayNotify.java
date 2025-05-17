package com.trionesdev.payment.wechatpay.v3.payment;

import com.trionesdev.payment.wechatpay.v3.convert.WechatPayConvert;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayNotifyRequest;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayRefoundNotifyResponse;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayTransactionNotifyResponse;
import com.wechat.pay.java.service.payments.model.Transaction;
import com.wechat.pay.java.service.refund.model.RefundNotification;

public class WechatPayNotify extends WechatPayBase {
    public WechatPayNotify(WechatPayConfig wxPayConfig) {
        super(wxPayConfig);
    }

    /**
     * 交易成功回调通知
     *
     * @param wxPayNotifyRequest
     */
    public WechatPayTransactionNotifyResponse transactionNotify(WechatPayNotifyRequest wxPayNotifyRequest) {
        Transaction transaction = notificationParser.parse(wxPayNotifyRequest.toRequestParam(), Transaction.class);
        return WechatPayConvert.INSTANCE.from(transaction);
    }

    /**
     * 退款成功回调
     *
     * @param wxPayNotifyRequest
     * @return
     */
    public WechatPayRefoundNotifyResponse refundNotify(WechatPayNotifyRequest wxPayNotifyRequest) {
        RefundNotification refundNotification = notificationParser.parse(wxPayNotifyRequest.toRequestParam(), RefundNotification.class);
        return WechatPayConvert.INSTANCE.from(refundNotification);
    }

}
