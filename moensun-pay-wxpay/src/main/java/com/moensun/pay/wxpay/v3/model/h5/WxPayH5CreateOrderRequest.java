package com.moensun.pay.wxpay.v3.model.h5;

import com.moensun.pay.wxpay.v3.convert.WxPayH5ConvertMapper;
import com.moensun.pay.wxpay.v3.model.WxPayBaseCreateOrderRequest;
import com.wechat.pay.java.service.payments.h5.model.PrepayRequest;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class WxPayH5CreateOrderRequest extends WxPayBaseCreateOrderRequest {

    public PrepayRequest toPrepayRequest() {
        return WxPayH5ConvertMapper.INSTANCE.from(this);
    }
}
