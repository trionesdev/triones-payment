package com.trionesdev.pay.wxpay.v3.payment.h5.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trionesdev.pay.wxpay.v3.payment.h5.WxPayH5ConvertMapper;
import com.wechat.pay.java.service.payments.h5.model.QueryOrderByOutTradeNoRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayH5QueryOrderByOutTradeNoRequest implements Serializable {
    @JsonProperty(value = "out_trade_no")
    private String outTradeNo;
    @JsonProperty(value = "mchId")
    private String mchId;

    public QueryOrderByOutTradeNoRequest toSdkRequest() {
        return WxPayH5ConvertMapper.INSTANCE.from(this);
    }
}
