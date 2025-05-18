package com.trionesdev.payment.wechatpay.v3.payment.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WechatPayCloseOrderRequest implements Serializable {
    private String outTradeNo;
    @SerializedName(value = "mchid")
    private String mchId;
}
