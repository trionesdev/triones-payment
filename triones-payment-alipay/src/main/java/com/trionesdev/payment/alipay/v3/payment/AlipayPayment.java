package com.trionesdev.payment.alipay.v3.payment;


import com.trionesdev.payment.alipay.v3.AlipayConfig;
import com.trionesdev.payment.alipay.v3.payment.page.AlipayPage;
import lombok.Getter;

public class AlipayPayment extends AlipayPaymentCommons {
    @Getter
    private final AlipayPage page;

    public AlipayPayment(AlipayConfig alipayConfig) {
        super(alipayConfig);
        page = new AlipayPage(alipayConfig);
    }

}
