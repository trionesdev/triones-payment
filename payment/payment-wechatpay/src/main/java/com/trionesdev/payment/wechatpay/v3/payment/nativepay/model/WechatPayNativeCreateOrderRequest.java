package com.trionesdev.payment.wechatpay.v3.payment.nativepay.model;

import com.trionesdev.payment.wechatpay.v3.model.Payer;
import com.trionesdev.payment.wechatpay.v3.WechatPayConfig;
import com.trionesdev.payment.wechatpay.v3.payment.nativepay.WechatPayNativeConvert;
import com.trionesdev.payment.wechatpay.v3.model.WechatPayBaseCreateOrderRequest;
import com.wechat.pay.java.service.payments.nativepay.model.PrepayRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WechatPayNativeCreateOrderRequest extends WechatPayBaseCreateOrderRequest {
    private Payer payer;
    public PrepayRequest toSdkRequest(WechatPayConfig config) {
        this.fill(config);
        return WechatPayNativeConvert.INSTANCE.from(this);
    }
}
