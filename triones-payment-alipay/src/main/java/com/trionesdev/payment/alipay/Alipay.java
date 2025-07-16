package com.trionesdev.payment.alipay;

import com.trionesdev.payment.alipay.payment.AlipayPayment;
import lombok.Getter;

public class Alipay {
    private final AlipayIntegrationConfig config;
    @Getter
    private final AlipayPayment payment;

    public Alipay(AlipayIntegrationConfig config) {
        this.config = config;
        this.payment = new AlipayPayment(config);
    }
}
