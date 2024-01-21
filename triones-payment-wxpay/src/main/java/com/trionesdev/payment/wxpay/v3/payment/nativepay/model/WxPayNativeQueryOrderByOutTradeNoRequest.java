package com.trionesdev.payment.wxpay.v3.payment.nativepay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trionesdev.payment.wxpay.v3.payment.nativepay.WxPayNativeConvertMapper;
import com.wechat.pay.java.service.payments.nativepay.model.QueryOrderByOutTradeNoRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayNativeQueryOrderByOutTradeNoRequest implements Serializable {
    @JsonProperty(value = "out_trade_no")
    private String outTradeNo;
    @JsonProperty(value = "mchId")
    private String mchId;

    public QueryOrderByOutTradeNoRequest toSdkRequest() {
        return WxPayNativeConvertMapper.INSTANCE.from(this);
    }
}
