package com.moensun.pay.wxpay.v3.payment.app.model;

import com.moensun.pay.wxpay.v3.model.WxPayBaseCreateOrderRequest;
import com.moensun.pay.wxpay.v3.payment.WxPayConfig;
import com.moensun.pay.wxpay.v3.payment.app.WxPayAppConvertMapper;
import com.wechat.pay.java.service.payments.app.model.PrepayRequest;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class WxPayAppCreateOrderRequest extends WxPayBaseCreateOrderRequest {
    public PrepayRequest toSdkRequest(WxPayConfig config) {
        this.fill(config);
        return WxPayAppConvertMapper.INSTANCE.from(this);
    }
}
