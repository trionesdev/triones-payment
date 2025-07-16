package com.trionesdev.payment.alipay.v2.payment;

import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayTradeCloseModel;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.request.AlipayTradeCloseRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeCloseResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.trionesdev.payment.alipay.v2.AlipayBase;
import com.trionesdev.payment.alipay.v2.AlipayIntegrationConfig;

import java.util.Map;

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

    public void notifyParse(Map<String,String>  params){
        boolean signVerified = rsaCheckV2( params);
        if(signVerified){
            // TODO
        }else {
            throw new RuntimeException("签名验证失败");
        }
    }
}
