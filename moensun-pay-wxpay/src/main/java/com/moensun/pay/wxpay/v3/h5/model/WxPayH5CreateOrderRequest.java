package com.moensun.pay.wxpay.v3.h5.model;

import com.moensun.pay.wxpay.v3.WxPayConfig;
import com.moensun.pay.wxpay.v3.h5.WxPayH5ConvertMapper;
import com.moensun.pay.wxpay.v3.model.WxPayBaseCreateOrderRequest;
import com.wechat.pay.java.service.payments.h5.model.PrepayRequest;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class WxPayH5CreateOrderRequest extends WxPayBaseCreateOrderRequest {


    public PrepayRequest toSdkRequest(WxPayConfig wxPayConfig) {
        this.fill(wxPayConfig);
        return WxPayH5ConvertMapper.INSTANCE.from(this);
    }
}
