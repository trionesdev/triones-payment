package com.trionesdev.payment.alipay.v2;

import com.trionesdev.payment.alipay.v2.capital.AlipayCapital;
import com.trionesdev.payment.alipay.v2.payment.AlipayPayment;
import lombok.Getter;

public class Alipay {
    private final AlipayIntegrationConfig config;
    @Getter
    private final AlipayPayment payment;
    @Getter
    private final AlipayCapital capital;

    public Alipay(AlipayIntegrationConfig config) {
        this.config = config;
        this.payment = new AlipayPayment(config);
        this.capital = new AlipayCapital(config);
    }
}
