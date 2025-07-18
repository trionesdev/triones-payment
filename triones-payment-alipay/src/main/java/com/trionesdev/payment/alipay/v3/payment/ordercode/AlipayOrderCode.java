package com.trionesdev.payment.alipay.v3.payment.ordercode;

import com.alipay.v3.model.AlipayTradePrecreateModel;
import com.alipay.v3.model.AlipayTradePrecreateResponseModel;
import com.trionesdev.payment.alipay.v3.AlipayConfig;
import com.trionesdev.payment.alipay.v3.payment.AlipayPaymentCommons;
import lombok.SneakyThrows;

public class AlipayOrderCode extends AlipayPaymentCommons {
    public AlipayOrderCode(AlipayConfig alipayConfig) {
        super(alipayConfig);
    }

    @SneakyThrows
    public AlipayTradePrecreateResponseModel createOrder(AlipayTradePrecreateModel model) {
        return alipayTradeApi.precreate(model);
    }
}
