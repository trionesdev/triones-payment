package com.trionesdev.payment.wechatpay.v3.payment.h5.model;

import com.trionesdev.payment.wechatpay.v3.model.WechatPayBaseCreateOrderRequest;
import com.trionesdev.payment.wechatpay.v3.payment.WechatPayConfig;
import com.trionesdev.payment.wechatpay.v3.payment.h5.WechatPayH5Convert;
import com.wechat.pay.java.service.payments.h5.model.PrepayRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class WechatPayH5CreateOrderRequest extends WechatPayBaseCreateOrderRequest {


    public PrepayRequest toSdkRequest(WechatPayConfig wxPayConfig) {
        this.fill(wxPayConfig);
        return WechatPayH5Convert.INSTANCE.from(this);
    }
}
