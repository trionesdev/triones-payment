package com.trionesdev.payment.wechatpay.v3.convert;

import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayRefoundNotifyParseResponse;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayTransactionNotifyParseResponse;
import com.wechat.pay.java.service.payments.model.Transaction;
import com.wechat.pay.java.service.refund.model.RefundNotification;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface WechatPayConvert {
    WechatPayConvert INSTANCE = Mappers.getMapper(WechatPayConvert.class);

    WechatPayTransactionNotifyParseResponse from(Transaction args);

    WechatPayRefoundNotifyParseResponse from(RefundNotification args);
}
