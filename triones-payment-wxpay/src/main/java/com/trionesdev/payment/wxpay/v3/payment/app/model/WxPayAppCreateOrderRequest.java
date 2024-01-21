package com.trionesdev.payment.wxpay.v3.payment.app.model;

import com.trionesdev.payment.wxpay.v3.model.Payer;
import com.trionesdev.payment.wxpay.v3.model.WxPayBaseCreateOrderRequest;
import com.trionesdev.payment.wxpay.v3.payment.WxPayConfig;
import com.trionesdev.payment.wxpay.v3.payment.app.WxPayAppConvertMapper;
import com.wechat.pay.java.service.payments.app.model.PrepayRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@SuperBuilder
public class WxPayAppCreateOrderRequest extends WxPayBaseCreateOrderRequest {
    private Payer payer;
    public PrepayRequest toSdkRequest(WxPayConfig config) {
        this.fill(config);
        return WxPayAppConvertMapper.INSTANCE.from(this);
    }
}
