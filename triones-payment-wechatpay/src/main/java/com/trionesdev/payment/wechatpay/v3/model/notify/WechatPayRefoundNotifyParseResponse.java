package com.trionesdev.payment.wechatpay.v3.model.notify;

import com.google.gson.annotations.SerializedName;
import com.trionesdev.payment.wechatpay.v3.model.TransactionAmount;
import com.trionesdev.payment.wechatpay.v3.payment.enums.RefundStatus;
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
public class WechatPayRefoundNotifyParseResponse implements Serializable {

    @SerializedName(value = "mchid")
    private String mchId;

    @SerializedName(value = "out_trade_no")
    private String outTradeNo;
    @SerializedName(value = "transaction_id")
    private String transactionId;
    @SerializedName(value = "out_refund_no")
    private String outRefundNo;
    @SerializedName(value = "refund_id")
    private String refundId;
    @SerializedName(value = "refund_status")
    private RefundStatus refundStatus;
    @SerializedName(value = "success_time")
    private String successTime;

    @SerializedName(value = "user_received_account ")
    private String userReceivedAccount;
    private TransactionAmount amount;

}
