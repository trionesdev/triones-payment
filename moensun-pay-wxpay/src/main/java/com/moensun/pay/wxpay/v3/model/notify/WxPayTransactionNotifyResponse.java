package com.moensun.pay.wxpay.v3.model.notify;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class WxPayTransactionNotifyResponse implements Serializable {
    @JsonProperty(value = "mchid")
    private String mchId;
    @JsonProperty(value = "appid")
    private String appId;
    @JsonProperty(value = "out_trade_no")
    private String outTradeNo;
    @JsonProperty(value = "transaction_id")
    private String transactionId;
    @JsonProperty(value = "trade_type")
    private TradeTypeEnum tradeType;
    @JsonProperty(value = "trade_state")
    private TradeStateEnum tradeState;
    @JsonProperty(value = "trade_state_desc")
    private String tradeStateDesc;
    @JsonProperty(value = "bank_type")
    private String bankType;
    private String attach;
    @JsonProperty(value = "success_time")
    private String successTime;
    private Payer payer;
    private Amount amount;


    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Payer{
        @JsonProperty(value = "openid")
        private String openId;
    }

    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Amount{
        private int total;
        @JsonProperty(value = "payer_total")
        private int payerTotal;
        private String currency;
        @JsonProperty(value = "payer_currency")
        private String payerCurrency;
    }

    public enum TradeStateEnum {
        SUCCESS,
        REFUND,
        NOTPAY,
        CLOSED,
        REVOKED,
        USERPAYING,
        PAYERROR,
        ACCEPT
    }

    public enum TradeTypeEnum {
        JSAPI,
        NATIVE,
        APP,
        MICROPAY,
        MWEB,
        FACEPAY
    }
}
