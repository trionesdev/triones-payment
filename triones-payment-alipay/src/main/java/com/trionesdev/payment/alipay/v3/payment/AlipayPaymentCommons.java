package com.trionesdev.payment.alipay.v3.payment;


import com.alipay.v3.ApiException;
import com.alipay.v3.model.*;
import com.trionesdev.payment.alipay.AlipayException;
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


    public AlipayTradeRefundResponseModel createRefund(AlipayTradeRefundModel model) {
        try {
            return alipayTradeApi.refund(model);
        } catch (ApiException e) {
            AlipayTradeRefundDefaultResponse errorObject = (AlipayTradeRefundDefaultResponse) e.getErrorObject();
            throw new AlipayException(String.valueOf(e.getCode()), e.getMessage());
        }
    }
}
