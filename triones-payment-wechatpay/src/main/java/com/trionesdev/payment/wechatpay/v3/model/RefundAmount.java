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
public class RefundAmount {
    /**
     * 【原订单金额】 原支付交易的订单总金额，币种的最小单位，只能为整数
     */
    private Integer total;
    /**
     * 【退款金额】 退款金额，币种的最小单位，只能为整数，不能超过原订单支付金额。
     */
    private Integer refund;
    /**
     * 用户实际支付金额
     */
    @SerializedName(value = "payer_total")
    private Integer payerTotal;
    /**
     * 用户退款金额
     */
    @SerializedName(value = "payer_refund")
    private Integer payerRefund;
}
