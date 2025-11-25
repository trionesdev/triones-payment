package com.trionesdev.payment.alipay.v3.modal;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class SubMerchant {
    @SerializedName("merchant_id")
    private String merchantId;
    @SerializedName("merchant_type")
    private String merchantType;
}
