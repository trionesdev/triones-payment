package com.trionesdev.pay.wxpay.v3.payment.nativepay;

import com.trionesdev.pay.wxpay.v3.payment.nativepay.model.WxPayNativeCloseOrderRequest;
import com.trionesdev.pay.wxpay.v3.payment.nativepay.model.WxPayNativeCreateOrderRequest;
import com.trionesdev.pay.wxpay.v3.model.notify.WxPayNativeQueryOrderResponse;
import com.trionesdev.pay.wxpay.v3.payment.nativepay.model.WxPayNativeQueryOrderByIdRequest;
import com.trionesdev.pay.wxpay.v3.payment.nativepay.model.WxPayNativeQueryOrderByOutTradeNoRequest;
import com.wechat.pay.java.service.payments.model.Transaction;
import com.wechat.pay.java.service.payments.nativepay.model.CloseOrderRequest;
import com.wechat.pay.java.service.payments.nativepay.model.PrepayRequest;
import com.wechat.pay.java.service.payments.nativepay.model.QueryOrderByIdRequest;
import com.wechat.pay.java.service.payments.nativepay.model.QueryOrderByOutTradeNoRequest;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface WxPayNativeConvertMapper {
    WxPayNativeConvertMapper INSTANCE = Mappers.getMapper(WxPayNativeConvertMapper.class);

    @Mappings(value = {
            @Mapping(source = "appId", target = "appid"),
            @Mapping(source = "mchId", target = "mchid")
    })
    PrepayRequest from(WxPayNativeCreateOrderRequest args);

    @Mappings(value = {
            @Mapping(source = "mchId", target = "mchid")
    })
    QueryOrderByIdRequest from(WxPayNativeQueryOrderByIdRequest args);

    @Mappings(value = {
            @Mapping(source = "mchId", target = "mchid")
    })
    QueryOrderByOutTradeNoRequest from(WxPayNativeQueryOrderByOutTradeNoRequest args);

    @Mappings(value = {
            @Mapping(source = "appid", target = "appId"),
            @Mapping(source = "mchid", target = "mchId"),
            @Mapping(source = "payer.openid", target = "payer.openId"),
    })
    WxPayNativeQueryOrderResponse from(Transaction args);

    @Mappings(value = {
            @Mapping(source = "mchId", target = "mchid")
    })
    CloseOrderRequest from(WxPayNativeCloseOrderRequest args);
}
