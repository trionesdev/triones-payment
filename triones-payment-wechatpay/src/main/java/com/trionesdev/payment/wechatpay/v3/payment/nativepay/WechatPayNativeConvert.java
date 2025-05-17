package com.trionesdev.payment.wechatpay.v3.payment.nativepay;

import com.trionesdev.payment.wechatpay.v3.payment.nativepay.model.WechatPayNativeCloseOrderRequest;
import com.trionesdev.payment.wechatpay.v3.payment.nativepay.model.WechatPayNativeCreateOrderRequest;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayNativeQueryOrderResponse;
import com.trionesdev.payment.wechatpay.v3.payment.nativepay.model.WechatPayNativeQueryOrderByIdRequest;
import com.trionesdev.payment.wechatpay.v3.payment.nativepay.model.WechatPayNativeQueryOrderByOutTradeNoRequest;
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
public interface WechatPayNativeConvert {
    WechatPayNativeConvert INSTANCE = Mappers.getMapper(WechatPayNativeConvert.class);

    @Mappings(value = {
            @Mapping(source = "appId", target = "appid"),
            @Mapping(source = "mchId", target = "mchid")
    })
    PrepayRequest from(WechatPayNativeCreateOrderRequest args);

    @Mappings(value = {
            @Mapping(source = "mchId", target = "mchid")
    })
    QueryOrderByIdRequest from(WechatPayNativeQueryOrderByIdRequest args);

    @Mappings(value = {
            @Mapping(source = "mchId", target = "mchid")
    })
    QueryOrderByOutTradeNoRequest from(WechatPayNativeQueryOrderByOutTradeNoRequest args);

    @Mappings(value = {
            @Mapping(source = "appid", target = "appId"),
            @Mapping(source = "mchid", target = "mchId"),
            @Mapping(source = "payer.openid", target = "payer.openId"),
    })
    WechatPayNativeQueryOrderResponse from(Transaction args);

    @Mappings(value = {
            @Mapping(source = "mchId", target = "mchid")
    })
    CloseOrderRequest from(WechatPayNativeCloseOrderRequest args);
}
