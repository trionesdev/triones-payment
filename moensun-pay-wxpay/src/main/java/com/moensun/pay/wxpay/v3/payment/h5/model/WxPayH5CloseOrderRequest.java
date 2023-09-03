package com.moensun.pay.wxpay.v3.payment.h5.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moensun.pay.wxpay.v3.payment.h5.WxPayH5ConvertMapper;
import com.wechat.pay.java.service.payments.h5.model.CloseOrderRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayH5CloseOrderRequest implements Serializable {
    @JsonProperty(value = "out_trade_no")
    private String outTradeNo;

    @JsonProperty(value = "mchid")
    private String mchId;

    public CloseOrderRequest toSdkRequest() {
        return WxPayH5ConvertMapper.INSTANCE.from(this);
    }
}
