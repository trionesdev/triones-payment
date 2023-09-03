package com.moensun.pay.wxpay.v3.nativepay;

import com.moensun.pay.wxpay.v3.nativepay.model.WxPayNativeCreateOrderRequest;
import com.moensun.pay.wxpay.v3.model.notify.WxPayNativeQueryOrderByIdRequest;
import com.moensun.pay.wxpay.v3.model.notify.WxPayNativeQueryOrderByOutTradeNoRequest;
import com.moensun.pay.wxpay.v3.model.notify.WxPayNativeQueryOrderResponse;
import com.wechat.pay.java.service.payments.model.Transaction;
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

    @Mappings(
            value = {
                    @Mapping(source = "appId", target = "appid"),
                    @Mapping(source = "mchId", target = "mchid")
            }
    )
    PrepayRequest from(WxPayNativeCreateOrderRequest args);

    QueryOrderByIdRequest from(WxPayNativeQueryOrderByIdRequest args);

    QueryOrderByOutTradeNoRequest from(WxPayNativeQueryOrderByOutTradeNoRequest args);

    WxPayNativeQueryOrderResponse from(Transaction args);
}
