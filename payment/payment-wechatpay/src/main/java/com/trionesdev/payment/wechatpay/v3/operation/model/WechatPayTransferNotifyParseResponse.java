package com.trionesdev.payment.wechatpay.v3.operation.model;

import com.google.gson.annotations.SerializedName;
import com.trionesdev.payment.wechatpay.v3.operation.enums.TransferState;
import lombok.Data;

import java.io.Serializable;

@Data
public class WechatPayTransferNotifyParseResponse implements Serializable {
    @SerializedName(value = "out_bill_no")
    private String outBillNo;
    @SerializedName(value = "transfer_bill_no")
    private String transferBillNo;
    private TransferState state;
    @SerializedName(value = "mch_id")
    private String mchId;
    @SerializedName(value = "transfer_amount")
    private Integer transferAmount;
    @SerializedName(value = "openid")
    private String openId;
    @SerializedName(value = "fail_reason")
    private String failReason;
    @SerializedName(value = "create_time")
    private String createTime;
    @SerializedName(value = "update_time")
    private String updateTime;
}
