package com.moensun.pay.wxpay.v3;

import com.moensun.pay.wxpay.v3.convert.WxPayConvertMapper;
import com.moensun.pay.wxpay.v3.model.notify.WxPayNotifyRequest;
import com.moensun.pay.wxpay.v3.model.notify.WxPayRefoundNotifyResponse;
import com.moensun.pay.wxpay.v3.model.notify.WxPayTransactionNotifyResponse;
import com.wechat.pay.java.core.notification.NotificationParser;
import com.wechat.pay.java.service.payments.model.Transaction;
import com.wechat.pay.java.service.refund.model.RefundNotification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class WxPayBase {
    private static final Logger log = LoggerFactory.getLogger(WxPayBase.class);

    private NotificationParser notificationParser;

    /**
     * 交易成功回调通知
     *
     * @param wxPayNotifyRequest
     */
    public WxPayTransactionNotifyResponse transactionNotify(WxPayNotifyRequest wxPayNotifyRequest) {
        Transaction transaction = notificationParser.parse(wxPayNotifyRequest.toRequestParam(), Transaction.class);
        return WxPayConvertMapper.INSTANCE.from(transaction);
    }

    /**
     * 退款成功回调
     *
     * @param wxPayNotifyRequest
     * @return
     */
    public WxPayRefoundNotifyResponse refundNotify(WxPayNotifyRequest wxPayNotifyRequest) {
        RefundNotification refundNotification = notificationParser.parse(wxPayNotifyRequest.toRequestParam(), RefundNotification.class);
        return WxPayConvertMapper.INSTANCE.from(refundNotification);
    }

}
