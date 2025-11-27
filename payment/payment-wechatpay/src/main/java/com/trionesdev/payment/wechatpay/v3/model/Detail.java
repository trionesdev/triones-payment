package com.trionesdev.payment.wechatpay.v3.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@Accessors(chain = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Detail {
    @SerializedName(value = "cost_price")
    private int costPrice;
    @SerializedName(value = "invoice_id")
    private String invoiceId;
    @SerializedName(value = "goods_detail")
    private List<GoodsDetail> goodsDetail;
}
