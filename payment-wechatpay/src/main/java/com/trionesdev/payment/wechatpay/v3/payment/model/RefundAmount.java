package com.trionesdev.payment.wechatpay.v3.payment.model;

import com.google.gson.annotations.SerializedName;
import com.wechat.pay.java.service.refund.model.FundsFromItem;
import lombok.Data;

import java.util.List;

@Data
public class RefundAmount {
    @SerializedName("total")
    private Long total;
    @SerializedName("refund")
    private Long refund;
    @SerializedName("from")
    private List<FundsFromItem> from;
    @SerializedName("payer_total")
    private Long payerTotal;
    @SerializedName("payer_refund")
    private Long payerRefund;
    @SerializedName("settlement_refund")
    private Long settlementRefund;
    @SerializedName("settlement_total")
    private Long settlementTotal;
    @SerializedName("discount_refund")
    private Long discountRefund;
    @SerializedName("currency")
    private String currency;
    @SerializedName("refund_fee")
    private Long refundFee;
}
