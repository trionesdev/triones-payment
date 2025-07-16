package com.trionesdev.payment.alipay.v3.capital;

import com.trionesdev.payment.alipay.v3.AlipayBase;
import com.trionesdev.payment.alipay.v3.AlipayConfig;
import com.trionesdev.payment.alipay.v3.capital.transfer.AlipayMerchantTransfer;


public class AlipayCapital extends AlipayBase {
    private final AlipayMerchantTransfer alipayMerchantTransfer;

    public AlipayCapital(AlipayConfig alipayConfig) {
        super(alipayConfig);
        this.alipayMerchantTransfer = new AlipayMerchantTransfer(alipayConfig);
    }

    public AlipayMerchantTransfer getMerchantTransfer() {
        return alipayMerchantTransfer;
    }
}
