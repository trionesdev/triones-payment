package com.moensun.pay.wxpay.v3.model.nativepay;

import com.moensun.pay.wxpay.v3.convert.WxPayNativeConvertMapper;
import com.moensun.pay.wxpay.v3.model.WxPayBaseCreateOrderRequest;
import com.wechat.pay.java.service.payments.nativepay.model.PrepayRequest;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class WxPayNativeCreateOrderRequest extends WxPayBaseCreateOrderRequest {
    public PrepayRequest toPrepayRequest() {
        return WxPayNativeConvertMapper.INSTANCE.from(this);
    }
}
