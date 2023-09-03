package com.moensun.pay.wxpay.v3.model.notify;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moensun.pay.wxpay.v3.nativepay.WxPayNativeConvertMapper;
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
    private String mchid;

    public QueryOrderByOutTradeNoRequest toSdkRequest() {
        return WxPayNativeConvertMapper.INSTANCE.from(this);
    }
}
