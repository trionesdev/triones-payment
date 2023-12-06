package com.trionesdev.pay.alipay;

import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.trionesdev.pay.alipay.request.AlipayTradePreCreateEasyRequest;

public class AlipayWeb extends Alipay{
    public AlipayWeb(AlipayIntegrationConfig alipayConfig) {
        super(alipayConfig);
    }

    /**
     * 扫码支付
     * @return
     */
    public AlipayTradePrecreateResponse scanCodePayment(AlipayTradePreCreateEasyRequest request){
        return preCreate(request);
    }

}
