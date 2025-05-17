package com.trionesdev.payment.wechatpay.v3.payment.h5;

import com.trionesdev.payment.wechatpay.v3.payment.h5.model.*;
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
public interface WechatPayH5Convert {
    WechatPayH5Convert INSTANCE = Mappers.getMapper(WechatPayH5Convert.class);

    @Mappings(value = {
            @Mapping(source = "appId", target = "appid"),
            @Mapping(source = "mchId", target = "mchid")
    })
    PrepayRequest from(WechatPayH5CreateOrderRequest args);

    @Mappings(value = {
            @Mapping(source = "mchId", target = "mchid")
    })
    QueryOrderByIdRequest from(WechatPayH5QueryOrderByIdRequest args);

    @Mappings(value = {
            @Mapping(source = "mchId", target = "mchid")
    })
    QueryOrderByOutTradeNoRequest from(WechatPayH5QueryOrderByOutTradeNoRequest args);

    @Mappings(value = {
            @Mapping(source = "appid", target = "appId"),
            @Mapping(source = "mchid", target = "mchId"),
            @Mapping(source = "payer.openid", target = "payer.openId"),
    })
    WechatPayH5QueryOrderResponse from(Transaction args);

    @Mappings(value = {
            @Mapping(source = "mchId", target = "mchid")
    })
    CloseOrderRequest from(WechatPayH5CloseOrderRequest args);
}
