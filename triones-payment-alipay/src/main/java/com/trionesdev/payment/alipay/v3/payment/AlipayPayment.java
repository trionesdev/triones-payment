package com.trionesdev.payment.alipay.v3.payment;


import com.trionesdev.payment.alipay.v3.AlipayConfig;
import com.trionesdev.payment.alipay.v3.payment.ordercode.AlipayOrderCode;
import com.trionesdev.payment.alipay.v3.payment.page.AlipayPage;
import lombok.Getter;

public class AlipayPayment extends AlipayPaymentCommons {
    @Getter
    private final AlipayPage page;
    @Getter
    private final AlipayOrderCode orderCode;

    public AlipayPayment(AlipayConfig alipayConfig) {
        super(alipayConfig);
        page = new AlipayPage(alipayConfig);
        orderCode = new AlipayOrderCode(alipayConfig);
    }

}
