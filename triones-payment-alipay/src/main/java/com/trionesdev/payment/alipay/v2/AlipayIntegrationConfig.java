package com.trionesdev.payment.alipay.v2;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class AlipayIntegrationConfig extends AlipayCredentials {

    private String refundNotifyUrl;
    private String transferNotifyUrl;

    private Map<String,String> refundNotifyUrls;
    private Map<String,String> transferNotifyUrls;
    private List<AlipayCredentials> credentials;
}
