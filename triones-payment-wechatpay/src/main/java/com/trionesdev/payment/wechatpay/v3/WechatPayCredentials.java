package com.trionesdev.payment.wechatpay.v3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 微信支付的基本凭证信息
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class WechatPayCredentials {
    private String appId;
    private String mchId;
    private String apiV3Key;
    private String merchantSerialNo;
    private String privateKey;
    private String privateCert;
    private String privateKeyPath;
    private String privateCertPath;

}
