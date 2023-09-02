package com.moensun.pay.wxpay.v3.convert;

import com.moensun.pay.wxpay.v3.model.nativepay.WxPayNativeCreateOrderRequest;
import com.wechat.pay.java.service.payments.nativepay.model.PrepayRequest;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface WxPayNativeConvertMapper {
    WxPayNativeConvertMapper INSTANCE = Mappers.getMapper(WxPayNativeConvertMapper.class);

    PrepayRequest from(WxPayNativeCreateOrderRequest args);
}
