package com.trionesdev.payment.wechatpay.v3.convert;

import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayRefoundNotifyResponse;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayTransactionNotifyResponse;
import com.wechat.pay.java.service.payments.model.Transaction;
import com.wechat.pay.java.service.refund.model.RefundNotification;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface WechatPayConvert {
    WechatPayConvert INSTANCE = Mappers.getMapper(WechatPayConvert.class);

    WechatPayTransactionNotifyResponse from(Transaction args);

    WechatPayRefoundNotifyResponse from(RefundNotification args);
}
