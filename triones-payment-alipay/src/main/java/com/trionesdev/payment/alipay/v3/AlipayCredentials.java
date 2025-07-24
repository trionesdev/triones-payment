package com.trionesdev.payment.alipay.v3;

import com.alipay.v3.util.model.AlipayConfig;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AlipayCredentials extends AlipayConfig {
    private String notifyUrl;
}
