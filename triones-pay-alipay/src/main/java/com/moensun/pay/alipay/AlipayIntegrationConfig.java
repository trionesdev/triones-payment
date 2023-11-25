package com.moensun.pay.alipay;

import com.alipay.api.AlipayConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class AlipayIntegrationConfig extends AlipayConfig {
    private String notifyUrl;
    private Map<String,String> notifyUrls;
}
