package com.trionesdev.payment.wxpay.v3.payment;

import com.trionesdev.payment.wxpay.v3.convert.WxPayConvert;
import com.trionesdev.payment.wxpay.v3.model.notify.WxPayNotifyRequest;
import com.trionesdev.payment.wxpay.v3.model.notify.WxPayRefoundNotifyResponse;
import com.trionesdev.payment.wxpay.v3.model.notify.WxPayTransactionNotifyResponse;
import com.wechat.pay.java.service.payments.model.Transaction;
import com.wechat.pay.java.service.refund.model.RefundNotification;

public class WxPayNotify extends WxPayBase{
    public WxPayNotify(WxPayConfig wxPayConfig) {
        super(wxPayConfig);
    }

    /**
     * 交易成功回调通知
     *
     * @param wxPayNotifyRequest
     */
    public WxPayTransactionNotifyResponse transactionNotify(WxPayNotifyRequest wxPayNotifyRequest) {
        Transaction transaction = notificationParser.parse(wxPayNotifyRequest.toRequestParam(), Transaction.class);
        return WxPayConvert.INSTANCE.from(transaction);
    }

    /**
     * 退款成功回调
     *
     * @param wxPayNotifyRequest
     * @return
     */
    public WxPayRefoundNotifyResponse refundNotify(WxPayNotifyRequest wxPayNotifyRequest) {
        RefundNotification refundNotification = notificationParser.parse(wxPayNotifyRequest.toRequestParam(), RefundNotification.class);
        return WxPayConvert.INSTANCE.from(refundNotification);
    }

}
