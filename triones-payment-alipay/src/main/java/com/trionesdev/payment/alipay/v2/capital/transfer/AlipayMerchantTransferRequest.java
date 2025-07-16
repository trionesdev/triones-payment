package com.trionesdev.payment.alipay.v2.capital.transfer;

import com.alipay.api.domain.AlipayFundTransUniTransferModel;

public class AlipayMerchantTransferRequest extends AlipayFundTransUniTransferModel {
    private String notifyUrl;

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
}
