package com.trionesdev.payment.wxpay.v3.payment.jsapi;

import com.trionesdev.payment.wxpay.v3.payment.jsapi.model.WxPayJsApiCreateOrderRequest;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayRequest;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface WxPayJsApiConvertMapper {
    WxPayJsApiConvertMapper INSTANCE = Mappers.getMapper(WxPayJsApiConvertMapper.class);

    @Mappings(value = {
            @Mapping(source = "appId", target = "appid"),
            @Mapping(source = "mchId", target = "mchid")
    })
    PrepayRequest from(WxPayJsApiCreateOrderRequest args);
}
