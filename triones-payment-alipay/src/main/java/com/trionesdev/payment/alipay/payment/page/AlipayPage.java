package com.trionesdev.payment.alipay.payment.page;

import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.trionesdev.payment.alipay.AlipayIntegrationConfig;
import com.trionesdev.payment.alipay.payment.AlipayPaymentCommons;
import org.apache.commons.lang3.StringUtils;

/**
 * 支付宝页面支付
 */
public class AlipayPage extends AlipayPaymentCommons {
    public AlipayPage(AlipayIntegrationConfig alipayConfig) {
        super(alipayConfig);
    }

    /**
     * 创建订单并返回支付宝页面
     *
     * @param model
     * @return
     */
    public AlipayTradePagePayResponse createOrderWithRequestPayment(AlipayTradePagePayModel model) {
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        if (StringUtils.isBlank(model.getProductCode())){
            model.setProductCode("FAST_INSTANT_TRADE_PAY");
        }
        request.setBizModel(model);
        try {
            AlipayTradePagePayResponse response = alipayClient.pageExecute(request, "POST");
            return response;
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
    }
}
