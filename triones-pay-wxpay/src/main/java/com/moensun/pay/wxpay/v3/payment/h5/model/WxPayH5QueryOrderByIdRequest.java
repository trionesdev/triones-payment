package com.moensun.pay.wxpay.v3.payment.h5.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moensun.pay.wxpay.v3.payment.h5.WxPayH5ConvertMapper;
import com.wechat.pay.java.service.payments.h5.model.QueryOrderByIdRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayH5QueryOrderByIdRequest implements Serializable {
    @JsonProperty(value = "transaction_id")
    private String transactionId;
    @JsonProperty(value = "mchid")
    private String mchId;

    public QueryOrderByIdRequest toSdkRequest() {
        return WxPayH5ConvertMapper.INSTANCE.from(this);
    }
}
