package com.trionesdev.payment.wechatpay.v3.payment.enums;

import com.google.gson.annotations.SerializedName;

public enum RefundStatus {
    @SerializedName("SUCCESS")
    SUCCESS,
    @SerializedName("CLOSED")
    CLOSED,
    @SerializedName("PROCESSING")
    PROCESSING,
    @SerializedName("ABNORMAL")
    ABNORMAL;
}
