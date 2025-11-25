package com.trionesdev.payment.wechatpay.v3.payment.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class WechatPayQueryRefundByOutNoRequest implements Serializable {
    private String outRefundNo;
}
