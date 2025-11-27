package com.trionesdev.payment.alipay.v3.payment;


import com.alipay.v3.ApiException;
import com.alipay.v3.model.*;
import com.alipay.v3.util.AlipaySignature;
import com.trionesdev.payment.alipay.AlipayException;
import com.trionesdev.payment.alipay.v3.AlipayBase;
import com.trionesdev.payment.alipay.v3.AlipayConfig;
import com.trionesdev.payment.alipay.v3.modal.AlipayNotifyModel;
import com.trionesdev.payment.alipay.v3.util.AlipayNotifyUtils;
import lombok.SneakyThrows;

import java.util.Map;

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

    @SneakyThrows
    public AlipayNotifyModel notifyParseFromMaps(Map<String, String[]> paramsMap) {
        Map<String, String> map = AlipayNotifyUtils.parameters(paramsMap);
        boolean verify = AlipaySignature.verifyV1(map, alipayConfig.getAlipayPublicKey(), "utf-8", "RSA2");
        return AlipayNotifyUtils.fromMap(map);
    }

    @SneakyThrows
    public AlipayNotifyModel notifyParseFromMap(Map<String, String> paramMap) {
        boolean verify = AlipaySignature.verifyV1(paramMap, alipayConfig.getAlipayPublicKey(), "utf-8", "RSA2");
        return AlipayNotifyUtils.fromMap(paramMap);
    }

}
