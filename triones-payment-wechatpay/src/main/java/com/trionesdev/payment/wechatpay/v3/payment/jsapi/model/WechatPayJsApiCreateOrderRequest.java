package com.trionesdev.payment.wechatpay.v3.payment.jsapi.model;

import com.trionesdev.payment.wechatpay.v3.model.Payer;
import com.trionesdev.payment.wechatpay.v3.model.WechatPayBaseCreateOrderRequest;
import com.trionesdev.payment.wechatpay.v3.WechatPayConfig;
import com.trionesdev.payment.wechatpay.v3.payment.jsapi.WechatPayJsApiConvert;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayRequest;
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
@NoArgsConstructor
@AllArgsConstructor
public class WechatPayJsApiCreateOrderRequest extends WechatPayBaseCreateOrderRequest {

    private Payer payer;

    public PrepayRequest toPrepayRequest(WechatPayConfig config) {
        this.fill(config);
        return WechatPayJsApiConvert.INSTANCE.from(this);
    }

}
