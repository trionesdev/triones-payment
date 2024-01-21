package com.trionesdev.payment.wxpay.v3.payment.app;

import com.trionesdev.payment.wxpay.v3.payment.app.model.WxPayAppCreateOrderRequest;
import com.trionesdev.payment.wxpay.v3.payment.app.model.WxPayAppCreateOrderResponse;
import com.wechat.pay.java.service.payments.app.model.PrepayRequest;
import com.wechat.pay.java.service.payments.app.model.PrepayResponse;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface WxPayAppConvertMapper {
    WxPayAppConvertMapper INSTANCE = Mappers.getMapper(WxPayAppConvertMapper.class);

    @Mappings(value = {
            @Mapping(source = "appId", target = "appid"),
            @Mapping(source = "mchId", target = "mchid")
    })
    PrepayRequest from(WxPayAppCreateOrderRequest args);

    WxPayAppCreateOrderResponse from(PrepayResponse args);
}
