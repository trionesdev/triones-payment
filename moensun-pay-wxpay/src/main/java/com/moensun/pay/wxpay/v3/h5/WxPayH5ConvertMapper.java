package com.moensun.pay.wxpay.v3.h5;

import com.moensun.pay.wxpay.v3.h5.model.*;
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

    @Mappings(
            value = {
                    @Mapping(source = "appId", target = "appid"),
                    @Mapping(source = "mchId", target = "mchid")
            }
    )
    PrepayRequest from(WxPayH5CreateOrderRequest args);

    QueryOrderByIdRequest from(WxPayH5QueryOrderByIdRequest args);

    QueryOrderByOutTradeNoRequest from(WxPayH5QueryOrderByOutTradeNoRequest args);

    WxPayH5QueryOrderResponse from(Transaction args);

    CloseOrderRequest from(WxPayH5CloseOrderRequest args);
}
