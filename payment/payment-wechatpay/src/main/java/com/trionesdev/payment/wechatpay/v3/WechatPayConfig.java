package com.trionesdev.payment.wechatpay.v3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class WechatPayConfig extends WechatPayCredentials {
    private String transactionNotifyUrl;
    private String refundNotifyUrl;
    private String transferNotifyUrl;
    private Map<String,String> transactionNotifyUrls;
    private Map<String,String> refundNotifyUrls;
    private List<WechatPayCredentials> credentials;
}
