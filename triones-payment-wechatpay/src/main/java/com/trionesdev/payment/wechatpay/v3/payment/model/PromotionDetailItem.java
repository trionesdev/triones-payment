package com.trionesdev.payment.wechatpay.v3.payment.model;

import com.google.gson.annotations.SerializedName;
import com.trionesdev.payment.wechatpay.v3.payment.enums.Scope;
import com.trionesdev.payment.wechatpay.v3.payment.enums.Type;
import lombok.Data;

import java.util.List;

@Data
public class PromotionDetailItem {
    @SerializedName("promotion_id")
    private String promotionId;
    @SerializedName("amount")
    private Long amount;
    @SerializedName("refund_amount")
    private Long refundAmount;
    @SerializedName("goods_detail")
    private List<GoodsDetail> goodsDetail;
    @SerializedName("scope")
    private Scope scope;
    @SerializedName("type")
    private Type type;
}
