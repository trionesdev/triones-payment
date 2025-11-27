package com.trionesdev.payment.wechatpay.v3.payment.model;

import lombok.Data;

@Data
public class AmountFrom {
    private String account;
    private Integer amount;
}
