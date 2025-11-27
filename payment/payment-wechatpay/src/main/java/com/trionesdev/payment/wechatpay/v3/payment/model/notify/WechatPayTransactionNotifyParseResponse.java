package com.trionesdev.payment.wechatpay.v3.payment.model.notify;

import com.google.gson.annotations.SerializedName;
import com.trionesdev.payment.wechatpay.v3.enums.TradeState;
import com.trionesdev.payment.wechatpay.v3.enums.TradeType;
import com.trionesdev.payment.wechatpay.v3.model.Payer;
import com.trionesdev.payment.wechatpay.v3.model.TransactionAmount;
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
public class WechatPayTransactionNotifyParseResponse implements Serializable {

    @SerializedName("mchid")
    private String mchId;

    @SerializedName("appid")
    private String appId;

    @SerializedName("out_trade_no")
    private String outTradeNo;

    @SerializedName(value = "transaction_id")
    private String transactionId;

    @SerializedName(value = "trade_type")
    private TradeType tradeType;

    @SerializedName(value = "trade_state")
    private TradeState tradeState;

    @SerializedName(value = "trade_state_desc")
    private String tradeStateDesc;

    @SerializedName(value = "bank_type")
    private String bankType;
    private String attach;

    @SerializedName(value = "success_time")
    private String successTime;
    private Payer payer;
    private TransactionAmount amount;
}
