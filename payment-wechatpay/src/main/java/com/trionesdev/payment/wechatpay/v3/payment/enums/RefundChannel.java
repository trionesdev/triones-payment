package com.trionesdev.payment.wechatpay.v3.payment.enums;

import com.google.gson.annotations.SerializedName;

public enum RefundChannel {
    @SerializedName("ORIGINAL")
    ORIGINAL,
    @SerializedName("BALANCE")
    BALANCE,
    @SerializedName("OTHER_BALANCE")
    OTHER_BALANCE,
    @SerializedName("OTHER_BANKCARD")
    OTHER_BANKCARD;
}
