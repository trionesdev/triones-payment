package com.trionesdev.payment.wechatpay.v3.operation.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class WechatPayCancelTransferRequest implements Serializable {
    private String billNo;
    private String outBillNo;
}
