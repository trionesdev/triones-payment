package com.moensun.pay.wxpay.v3.payment.nativepay.model;

import com.moensun.pay.wxpay.v3.payment.WxPayConfig;
import com.moensun.pay.wxpay.v3.payment.nativepay.WxPayNativeConvertMapper;
import com.moensun.pay.wxpay.v3.model.WxPayBaseCreateOrderRequest;
import com.wechat.pay.java.service.payments.nativepay.model.PrepayRequest;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class WxPayNativeCreateOrderRequest extends WxPayBaseCreateOrderRequest {
    public PrepayRequest toSdkRequest(WxPayConfig config) {
        this.fill(config);
        return WxPayNativeConvertMapper.INSTANCE.from(this);
    }
}
