package com.trionesdev.payment.alipay.v3;

import com.trionesdev.payment.alipay.v3.fund.AlipayFund;
import com.trionesdev.payment.alipay.v3.payment.AlipayPayment;
import lombok.Getter;

public class Alipay {
    private final AlipayConfig config;
    @Getter
    private final AlipayPayment payment;
    @Getter
    private final AlipayFund fund;

    public Alipay(AlipayConfig alipayConfig) {
        this.config = alipayConfig;
        this.payment = new AlipayPayment(alipayConfig);
        this.fund = new AlipayFund(alipayConfig);
    }
}
