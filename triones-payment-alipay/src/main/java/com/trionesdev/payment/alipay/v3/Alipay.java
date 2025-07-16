package com.trionesdev.payment.alipay.v3;

import com.trionesdev.payment.alipay.v3.payment.AlipayPayment;
import lombok.Getter;

public class Alipay {
    private final AlipayConfig config;
    @Getter
    private final AlipayPayment payment;
    public Alipay(AlipayConfig alipayConfig) {
        this.config = alipayConfig;
        this.payment = new AlipayPayment(alipayConfig);
    }
}
