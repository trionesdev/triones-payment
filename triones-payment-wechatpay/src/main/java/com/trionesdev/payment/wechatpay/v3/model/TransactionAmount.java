package com.trionesdev.payment.wechatpay.v3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@Data
@Accessors(chain = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionAmount {
    private int total;
    @JsonProperty(value = "payer_total")
    @SerializedName(value = "payer_total")
    private int payerTotal;
    private String currency;
    @JsonProperty(value = "payer_currency")
    @SerializedName(value = "payer_currency")
    private String payerCurrency;
}
