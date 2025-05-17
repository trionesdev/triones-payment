package com.trionesdev.payment.wechatpay.v3.payment.app;

import com.trionesdev.payment.wechatpay.v3.payment.app.model.WechatPayAppCreateOrderRequest;
import com.trionesdev.payment.wechatpay.v3.payment.app.model.WechatPayAppCreateOrderResponse;
import com.wechat.pay.java.service.payments.app.model.PrepayRequest;
import com.wechat.pay.java.service.payments.app.model.PrepayResponse;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface WechatPayAppConvert {
    WechatPayAppConvert INSTANCE = Mappers.getMapper(WechatPayAppConvert.class);

    @Mappings(value = {
            @Mapping(source = "appId", target = "appid"),
            @Mapping(source = "mchId", target = "mchid")
    })
    PrepayRequest from(WechatPayAppCreateOrderRequest args);

    WechatPayAppCreateOrderResponse from(PrepayResponse args);
}
