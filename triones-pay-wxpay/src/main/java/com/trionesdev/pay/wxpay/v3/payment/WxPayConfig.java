package com.trionesdev.pay.wxpay.v3.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class WxPayConfig {
    private String appId;
    private String mchId;
    private String apiV3Key;
    private String merchantSerialNo;
    private String privateKey;
    private String privateCert;
    private String privateKeyPath;
    private String privateCertPath;
    private String transactionNotifyUrl;
    private String refundNotifyUrl;
}
