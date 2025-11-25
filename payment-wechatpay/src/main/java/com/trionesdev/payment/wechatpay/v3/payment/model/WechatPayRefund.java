package com.trionesdev.payment.wechatpay.v3.payment.model;

import com.google.gson.annotations.SerializedName;
import com.trionesdev.payment.wechatpay.v3.payment.enums.RefundChannel;
import com.trionesdev.payment.wechatpay.v3.payment.enums.RefundStatus;
import com.wechat.pay.java.service.refund.model.FundsAccount;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class WechatPayRefund implements Serializable {
    @SerializedName("refund_id")
    private String refundId;
    @SerializedName("out_refund_no")
    private String outRefundNo;
    @SerializedName("transaction_id")
    private String transactionId;
    @SerializedName("out_trade_no")
    private String outTradeNo;
    @SerializedName("user_received_account")
    private String userReceivedAccount;
    @SerializedName("success_time")
    private String successTime;
    @SerializedName("create_time")
    private String createTime;
    @SerializedName("promotion_detail")
    private List<PromotionDetailItem> promotionDetail;
    @SerializedName("amount")
    private RefundAmount amount;
    @SerializedName("channel")
    private RefundChannel channel;
    @SerializedName("funds_account")
    private FundsAccount fundsAccount;
    @SerializedName("status")
    private RefundStatus status;
}
