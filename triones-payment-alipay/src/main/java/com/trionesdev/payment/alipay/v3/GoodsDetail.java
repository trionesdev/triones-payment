package com.trionesdev.payment.alipay.v3;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsDetail {
    @SerializedName("goods_id")
    private String goodsId;
    @SerializedName("goods_name")
    private String goodsName;
    private Long quantity;
    private BigDecimal price;
    @SerializedName("alipay_goods_id")
    private String alipayGoodsId;
    @SerializedName("goods_category")
    private String goodsCategory;
    @SerializedName("categories_tree")
    private String categoriesTree;
    @SerializedName("show_url")
    private String showUrl;
}
