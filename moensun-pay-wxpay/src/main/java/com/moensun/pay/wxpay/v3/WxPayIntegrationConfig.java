package com.moensun.pay.wxpay.v3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class WxPayIntegrationConfig {
    private String appId;
    private String mchId;
    private String apiV3Key;
    private byte[] privateKeyContent;
    private byte[] privateCertContent;
    private String privateKeyPath;
    private String privateCertPath;
    private String notifyUrl;
    private Map<String,String> notifyUrls;
}
