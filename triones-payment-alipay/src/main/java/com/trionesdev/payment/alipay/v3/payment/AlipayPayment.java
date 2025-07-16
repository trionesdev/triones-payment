package com.trionesdev.payment.alipay.v3.payment;


import com.trionesdev.payment.alipay.v3.AlipayConfig;
import com.trionesdev.payment.alipay.v3.payment.page.AlipayPage;

public class AlipayPayment extends AlipayPaymentCommons{
    private final AlipayPage alipayPage;
    public AlipayPayment(AlipayConfig alipayConfig) {
        super(alipayConfig);
        alipayPage = new AlipayPage(alipayConfig);
    }
    public AlipayPage getPage(){
        return alipayPage;
    }
}
