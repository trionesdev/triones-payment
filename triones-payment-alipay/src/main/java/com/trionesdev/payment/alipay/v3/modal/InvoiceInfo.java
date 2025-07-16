package com.trionesdev.payment.alipay.v3.modal;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class InvoiceInfo {
    @SerializedName("key_info")
    private keyInfo keyInfo;
    private String details;
}
