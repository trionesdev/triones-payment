package com.trionesdev.payment.wechatpay.v3.operation.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class TransferSceneReportInfo {
    @SerializedName(value = "info_type")
    private String infoType;
    @SerializedName(value = "info_content")
    private String infoContent;
}
