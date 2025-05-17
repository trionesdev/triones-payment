package com.trionesdev.payment.wechatpay.v3.payment.jsapi;

import com.trionesdev.payment.wechatpay.v3.payment.jsapi.model.WechatPayJsApiCreateOrderRequest;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayRequest;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface WechatPayJsApiConvert {
    WechatPayJsApiConvert INSTANCE = Mappers.getMapper(WechatPayJsApiConvert.class);

    @Mappings(value = {
            @Mapping(source = "appId", target = "appid"),
            @Mapping(source = "mchId", target = "mchid"),
            @Mapping(source = "payer.openId",target = "payer.openid")
    })
    PrepayRequest from(WechatPayJsApiCreateOrderRequest args);
}
