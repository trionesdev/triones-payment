package com.trionesdev.payment.alipay.v3.payment;


import com.alipay.v3.model.AlipayTradeCloseModel;
import com.alipay.v3.model.AlipayTradeCloseResponseModel;
import com.alipay.v3.model.AlipayTradeRefundModel;
import com.alipay.v3.model.AlipayTradeRefundResponseModel;
import com.trionesdev.payment.alipay.v3.AlipayBase;
import com.trionesdev.payment.alipay.v3.AlipayConfig;
import lombok.SneakyThrows;

public class AlipayPaymentCommons extends AlipayBase {
    public AlipayPaymentCommons(AlipayConfig alipayConfig) {
        super(alipayConfig);
    }

    @SneakyThrows
    public AlipayTradeCloseResponseModel closeOrder(AlipayTradeCloseModel model) {
        return alipayTradeApi.close(model);
    }

    @SneakyThrows
    public AlipayTradeRefundResponseModel createRefund(AlipayTradeRefundModel model) {
        return alipayTradeApi.refund(model);
    }
}
