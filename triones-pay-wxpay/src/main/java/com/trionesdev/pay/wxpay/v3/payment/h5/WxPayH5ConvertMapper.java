package com.trionesdev.pay.wxpay.v3.payment.h5;

import com.trionesdev.pay.wxpay.v3.payment.h5.model.*;
import com.wechat.pay.java.service.payments.h5.model.CloseOrderRequest;
import com.wechat.pay.java.service.payments.h5.model.PrepayRequest;
import com.wechat.pay.java.service.payments.h5.model.QueryOrderByIdRequest;
import com.wechat.pay.java.service.payments.h5.model.QueryOrderByOutTradeNoRequest;
import com.wechat.pay.java.service.payments.model.Transaction;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface WxPayH5ConvertMapper {
    WxPayH5ConvertMapper INSTANCE = Mappers.getMapper(WxPayH5ConvertMapper.class);

    @Mappings(value = {
            @Mapping(source = "appId", target = "appid"),
            @Mapping(source = "mchId", target = "mchid")
    })
    PrepayRequest from(WxPayH5CreateOrderRequest args);

    @Mappings(value = {
            @Mapping(source = "mchId", target = "mchid")
    })
    QueryOrderByIdRequest from(WxPayH5QueryOrderByIdRequest args);

    @Mappings(value = {
            @Mapping(source = "mchId", target = "mchid")
    })
    QueryOrderByOutTradeNoRequest from(WxPayH5QueryOrderByOutTradeNoRequest args);

    @Mappings(value = {
            @Mapping(source = "appid", target = "appId"),
            @Mapping(source = "mchid", target = "mchId"),
            @Mapping(source = "payer.openid", target = "payer.openId"),
    })
    WxPayH5QueryOrderResponse from(Transaction args);

    @Mappings(value = {
            @Mapping(source = "mchId", target = "mchid")
    })
    CloseOrderRequest from(WxPayH5CloseOrderRequest args);
}
