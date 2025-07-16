package com.trionesdev.payment.alipay.v2.capital.transfer;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayFundTransUniTransferRequest;
import com.alipay.api.response.AlipayFundTransUniTransferResponse;
import com.trionesdev.payment.alipay.v2.AlipayIntegrationConfig;
import com.trionesdev.payment.alipay.v2.capital.AlipayCapital;
import org.apache.commons.lang3.StringUtils;

public class AlipayMerchantTransfer extends AlipayCapital {
    public AlipayMerchantTransfer(AlipayIntegrationConfig alipayConfig) {
        super(alipayConfig);
    }

    public AlipayFundTransUniTransferResponse createTransfer(AlipayMerchantTransferRequest model) {
        AlipayFundTransUniTransferRequest request = new AlipayFundTransUniTransferRequest();
        request.setBizModel(model);
        if (StringUtils.isNotBlank(model.getNotifyUrl())) {
            request.setNotifyUrl(model.getNotifyUrl());
        } else if (StringUtils.isNotBlank(alipayConfig.getTransferNotifyUrl())) {
            request.setNotifyUrl(alipayConfig.getTransferNotifyUrl());
        }
        try {
            AlipayFundTransUniTransferResponse response = alipayClient.certificateExecute(request);
            return response;
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
    }
}
