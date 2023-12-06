package com.trionesdev.pay.wxpay.v3.convert;

import com.trionesdev.pay.wxpay.v3.model.notify.WxPayRefoundNotifyResponse;
import com.trionesdev.pay.wxpay.v3.model.notify.WxPayTransactionNotifyResponse;
import com.wechat.pay.java.service.payments.model.Transaction;
import com.wechat.pay.java.service.refund.model.RefundNotification;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface WxPayConvertMapper {
    public WxPayConvertMapper INSTANCE = Mappers.getMapper(WxPayConvertMapper.class);

    WxPayTransactionNotifyResponse from(Transaction args);

    WxPayRefoundNotifyResponse from(RefundNotification args);
}
