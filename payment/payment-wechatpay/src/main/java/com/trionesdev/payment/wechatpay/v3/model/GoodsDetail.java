package com.trionesdev.payment.wechatpay.v3.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@Data
@Accessors(chain = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDetail {
    @SerializedName(value = "merchant_goods_id")
    private String MerchantGoodsId;
    @SerializedName(value = "wechatpay_goods_id ")
    private String wechatPayGoodsId;
    @SerializedName(value = "goods_name")
    private String goodsName;
    private int quantity;
    @SerializedName(value = "unit_price")
    private int unitPrice;
}
