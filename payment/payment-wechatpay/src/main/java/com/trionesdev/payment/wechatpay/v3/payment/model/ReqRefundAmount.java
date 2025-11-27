package com.trionesdev.payment.wechatpay.v3.payment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ReqRefundAmount {
    private Integer refund;
    private List<AmountFrom> from;
    private Integer total;
    private String currency;
}
