package com.trionesdev.payment.wechatpay.v3.payment.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class GoodsDetail {
    @SerializedName(value = "merchant_goods_id")
    private String merchantGoodsId;
    @SerializedName(value = "wechatpay_goods_id")
    private String wechatpayGoodsId;
    @SerializedName(value = "goods_name")
    private String goodsName;
    @SerializedName(value = "unit_price")
    private Integer unitPrice;
    @SerializedName(value = "refund_amount")
    private Integer refundAmount;
    @SerializedName(value = "refund_quantity")
    private Integer refundQuantity;
}
