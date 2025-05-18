package com.trionesdev.payment.wechatpay.v3.payment.model;

import lombok.Data;

import java.util.List;

@Data
public class ReqRefundAmount {
    private Integer refund;
    private List<AmountFrom> from;
    private Integer total;
    private String currency;
}
