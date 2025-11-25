package com.trionesdev.payment.wechatpay.v3.payment.enums;

import com.google.gson.annotations.SerializedName;

public enum Type {
    @SerializedName("COUPON")
    COUPON,
    @SerializedName("DISCOUNT")
    DISCOUNT;
}
