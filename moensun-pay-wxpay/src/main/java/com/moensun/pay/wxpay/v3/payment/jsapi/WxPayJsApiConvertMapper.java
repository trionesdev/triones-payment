package com.moensun.pay.wxpay.v3.payment.jsapi;

import com.moensun.pay.wxpay.v3.payment.jsapi.model.WxPayJsApiCreateOrderRequest;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayRequest;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface WxPayJsApiConvertMapper {
    WxPayJsApiConvertMapper INSTANCE = Mappers.getMapper(WxPayJsApiConvertMapper.class);

    PrepayRequest from(WxPayJsApiCreateOrderRequest args);
}
