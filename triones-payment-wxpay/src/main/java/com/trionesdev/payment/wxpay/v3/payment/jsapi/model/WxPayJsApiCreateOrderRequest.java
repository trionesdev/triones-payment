package com.trionesdev.payment.wxpay.v3.payment.jsapi.model;

import com.trionesdev.payment.wxpay.v3.model.Payer;
import com.trionesdev.payment.wxpay.v3.model.WxPayBaseCreateOrderRequest;
import com.trionesdev.payment.wxpay.v3.payment.jsapi.WxPayJsApiConvertMapper;
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
public class WxPayJsApiCreateOrderRequest extends WxPayBaseCreateOrderRequest {

    private Payer payer;

    public PrepayRequest toPrepayRequest() {
        return WxPayJsApiConvertMapper.INSTANCE.from(this);
    }

}
