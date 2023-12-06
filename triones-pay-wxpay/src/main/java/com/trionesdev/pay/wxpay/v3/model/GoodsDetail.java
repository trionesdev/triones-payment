package com.trionesdev.pay.wxpay.v3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(value = "merchant_goods_id")
    private String MerchantGoodsId;
    @JsonProperty(value = "wechatpay_goods_id ")
    private String wechatPayGoodsId;
    @JsonProperty(value = "goods_name")
    private String goodsName;
    private int quantity;
    @JsonProperty(value = "unit_price")
    private int unitPrice;
}
