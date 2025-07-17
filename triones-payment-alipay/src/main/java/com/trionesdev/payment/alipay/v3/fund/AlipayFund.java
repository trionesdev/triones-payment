package com.trionesdev.payment.alipay.v3.fund;

import com.trionesdev.payment.alipay.v3.AlipayBase;
import com.trionesdev.payment.alipay.v3.AlipayConfig;
import com.trionesdev.payment.alipay.v3.fund.transfer.AlipayMerchantTransfer;
import lombok.Getter;


public class AlipayFund extends AlipayBase {
    @Getter
    private final AlipayMerchantTransfer merchantTransfer;

    public AlipayFund(AlipayConfig alipayConfig) {
        super(alipayConfig);
        this.merchantTransfer = new AlipayMerchantTransfer(alipayConfig);
    }


}
