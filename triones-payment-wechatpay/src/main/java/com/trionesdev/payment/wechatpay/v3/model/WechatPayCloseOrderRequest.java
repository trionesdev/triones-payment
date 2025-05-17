package com.trionesdev.payment.wechatpay.v3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WechatPayCloseOrderRequest {
    private String outTradeNo;
    @JsonProperty(value = "mchid")
    @SerializedName(value = "mchid")
    private String mchId;
}
