package com.trionesdev.payment.wechatpay.v3.payment.app.model;

import com.trionesdev.payment.wechatpay.v3.model.Payer;
import com.trionesdev.payment.wechatpay.v3.model.WechatPayBaseCreateOrderRequest;
import com.trionesdev.payment.wechatpay.v3.payment.WechatPayConfig;
import com.trionesdev.payment.wechatpay.v3.payment.app.WechatPayAppConvert;
import com.wechat.pay.java.service.payments.app.model.PrepayRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@SuperBuilder
public class WechatPayAppCreateOrderRequest extends WechatPayBaseCreateOrderRequest {
    private Payer payer;
    public PrepayRequest toSdkRequest(WechatPayConfig config) {
        this.fill(config);
        return WechatPayAppConvert.INSTANCE.from(this);
    }
}
