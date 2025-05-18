package com.trionesdev.payment.wechatpay.v3.operation.model;

import com.google.gson.annotations.SerializedName;
import com.trionesdev.payment.wechatpay.v3.operation.enums.TransferState;
import lombok.Data;

import java.io.Serializable;

@Data
public class WechatPayCreateTransferResponse implements Serializable {
    @SerializedName(value = "out_bill_no")
    private String outBillNo;
    @SerializedName(value = "transfer_bill_no")
    private String transferBillNo;
    @SerializedName(value = "create_time")
    private String createTime;
    private TransferState state;
    @SerializedName(value = "package_info")
    private String packageInfo;
}
