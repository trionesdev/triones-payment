package com.trionesdev.payment.alipay.payment;

import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayTradeCloseModel;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.request.AlipayTradeCloseRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeCloseResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.trionesdev.payment.alipay.AlipayBase;
import com.trionesdev.payment.alipay.AlipayIntegrationConfig;

public class AlipayPaymentCommons extends AlipayBase {
    public AlipayPaymentCommons(AlipayIntegrationConfig alipayConfig) {
        super(alipayConfig);
    }

    public AlipayTradeCloseResponse closeOrder(AlipayTradeCloseModel model) {
        AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
        request.setBizModel(model);
        try {
            AlipayTradeCloseResponse response = alipayClient.execute(request);
            return response;
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
    }

    public AlipayTradeRefundResponse createRefund(AlipayTradeRefundModel model) {
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizModel(model);
        try {
            AlipayTradeRefundResponse response = alipayClient.execute(request);
            return response;
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
    }
}
