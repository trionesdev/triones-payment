package com.trionesdev.pay.wxpay.v3.payment.nativepay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trionesdev.pay.wxpay.v3.payment.nativepay.WxPayNativeConvertMapper;
import com.wechat.pay.java.service.payments.nativepay.model.CloseOrderRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayNativeCloseOrderRequest implements Serializable {
    @JsonProperty(value = "out_trade_no")
    private String outTradeNo;

    @JsonProperty(value = "mchid")
    private String mchId;

    public CloseOrderRequest toSdkRequest() {
        return WxPayNativeConvertMapper.INSTANCE.from(this);
    }
}
