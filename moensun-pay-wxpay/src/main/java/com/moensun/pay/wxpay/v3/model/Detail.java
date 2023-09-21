package com.moensun.pay.wxpay.v3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(value = "cost_price")
    private int costPrice;
    @JsonProperty(value = "invoice_id")
    private String invoiceId;
    @JsonProperty(value = "goods_detail")
    private List<GoodsDetail> goodsDetail;
}
