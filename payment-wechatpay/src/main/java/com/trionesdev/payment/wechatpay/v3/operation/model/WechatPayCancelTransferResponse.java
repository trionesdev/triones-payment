package com.trionesdev.payment.wechatpay.v3.operation.model;

import com.google.gson.annotations.SerializedName;
import com.trionesdev.payment.wechatpay.v3.operation.enums.TransferState;
import lombok.Data;

import java.io.Serializable;

@Data
public class WechatPayCancelTransferResponse implements Serializable {
    @SerializedName(value = "out_bill_no")
    private String outBillNo;
    @SerializedName(value = "transfer_bill_no")
    private String transferBillNo;
    private TransferState state;
    @SerializedName(value = "update_time")
    private String updateTime;
}
