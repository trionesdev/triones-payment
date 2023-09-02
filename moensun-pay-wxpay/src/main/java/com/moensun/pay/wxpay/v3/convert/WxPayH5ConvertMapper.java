package com.moensun.pay.wxpay.v3.convert;

import com.moensun.pay.wxpay.v3.model.h5.WxPayH5CreateOrderRequest;
import com.moensun.pay.wxpay.v3.model.h5.WxPayH5QueryOrderByIdRequest;
import com.moensun.pay.wxpay.v3.model.h5.WxPayH5QueryOrderByOutTradeNoRequest;
import com.moensun.pay.wxpay.v3.model.h5.WxPayH5QueryOrderResponse;
import com.wechat.pay.java.service.payments.h5.model.PrepayRequest;
import com.wechat.pay.java.service.payments.h5.model.QueryOrderByIdRequest;
import com.wechat.pay.java.service.payments.h5.model.QueryOrderByOutTradeNoRequest;
import com.wechat.pay.java.service.payments.model.Transaction;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface WxPayH5ConvertMapper {
    WxPayH5ConvertMapper INSTANCE = Mappers.getMapper(WxPayH5ConvertMapper.class);

    PrepayRequest from(WxPayH5CreateOrderRequest args);

    QueryOrderByIdRequest from(WxPayH5QueryOrderByIdRequest args);

    QueryOrderByOutTradeNoRequest from(WxPayH5QueryOrderByOutTradeNoRequest args);

    WxPayH5QueryOrderResponse from(Transaction args);
}
