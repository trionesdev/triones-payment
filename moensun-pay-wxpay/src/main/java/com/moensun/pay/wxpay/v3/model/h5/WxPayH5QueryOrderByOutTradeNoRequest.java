package com.moensun.pay.wxpay.v3.model.h5;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moensun.pay.wxpay.v3.convert.WxPayH5ConvertMapper;
import com.wechat.pay.java.service.payments.h5.model.QueryOrderByIdRequest;
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
    private String mchid;

    public QueryOrderByOutTradeNoRequest toSdkRequest() {
        return WxPayH5ConvertMapper.INSTANCE.from(this);
    }
}
