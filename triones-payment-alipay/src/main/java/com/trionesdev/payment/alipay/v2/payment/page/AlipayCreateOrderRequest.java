package com.trionesdev.payment.alipay.v2.payment.page;

import com.alipay.api.domain.AlipayTradePagePayModel;


public class AlipayCreateOrderRequest extends AlipayTradePagePayModel {
    private String notifyUrl;

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
}
