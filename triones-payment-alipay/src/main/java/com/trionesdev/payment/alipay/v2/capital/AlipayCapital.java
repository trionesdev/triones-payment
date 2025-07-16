package com.trionesdev.payment.alipay.v2.capital;

import com.trionesdev.payment.alipay.v2.AlipayBase;
import com.trionesdev.payment.alipay.v2.AlipayIntegrationConfig;
import com.trionesdev.payment.alipay.v2.capital.transfer.AlipayMerchantTransfer;

public class AlipayCapital extends AlipayBase {
    private final AlipayMerchantTransfer alipayMerchantTransfer;

    public AlipayCapital(AlipayIntegrationConfig alipayConfig) {
        super(alipayConfig);
        alipayMerchantTransfer = new AlipayMerchantTransfer(alipayConfig);
    }

    public AlipayMerchantTransfer getMerchantTransfer() {
        return alipayMerchantTransfer;
    }
}
