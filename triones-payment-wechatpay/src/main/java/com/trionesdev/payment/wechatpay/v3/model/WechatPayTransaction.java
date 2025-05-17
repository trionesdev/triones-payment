package com.trionesdev.payment.wechatpay.v3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.trionesdev.payment.wechatpay.v3.enums.TradeState;
import com.trionesdev.payment.wechatpay.v3.enums.TradeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * 回调resource解密对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WechatPayTransaction implements Serializable {
    @JsonProperty(value = "mchid")
    @SerializedName("mchid")
    private String mchId;
    @JsonProperty(value = "appid")
    @SerializedName("appid")
    private String appId;
    @JsonProperty(value = "out_trade_no")
    @SerializedName("out_trade_no")
    private String outTradeNo;
    @JsonProperty(value = "transaction_id")
    @SerializedName(value = "transaction_id")
    private String transactionId;
    @JsonProperty(value = "trade_type")
    @SerializedName(value = "trade_type")
    private TradeType tradeType;
    @JsonProperty(value = "trade_state")
    @SerializedName(value = "trade_state")
    private TradeState tradeState;
    @JsonProperty(value = "trade_state_desc")
    @SerializedName(value = "trade_state_desc")
    private String tradeStateDesc;
    @JsonProperty(value = "bank_type")
    @SerializedName(value = "bank_type")
    private String bankType;
    private String attach;
    @JsonProperty(value = "success_time")
    @SerializedName(value = "success_time")
    private String successTime;
    private Payer payer;
    private TransactionAmount amount;
}
