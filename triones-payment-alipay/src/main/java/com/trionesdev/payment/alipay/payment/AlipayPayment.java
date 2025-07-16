package com.trionesdev.payment.alipay.payment;

import com.trionesdev.payment.alipay.AlipayIntegrationConfig;
import com.trionesdev.payment.alipay.payment.jsapi.AlipayJsapi;
import com.trionesdev.payment.alipay.payment.page.AlipayPage;

public class AlipayPayment extends AlipayPaymentCommons {
    private final AlipayPage aliPayPage;
    private final AlipayJsapi alipayJsapi;

    public AlipayPayment(AlipayIntegrationConfig alipayConfig) {
        super(alipayConfig);
        aliPayPage = new AlipayPage(alipayConfig);
        alipayJsapi = new AlipayJsapi(alipayConfig);
    }

    public AlipayPage getPage() {
        return aliPayPage;
    }

    public AlipayJsapi getJsapi() {
        return alipayJsapi;
    }
}
