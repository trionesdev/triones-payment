package com.trionesdev.payment.wechatpay.v3.payment.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;


@Data
public class WechatPayQueryOrderByOutTradeNoRequest implements Serializable {
    private String outTradeNo;
    @SerializedName(value = "mchid")
    private String mchId;
}
