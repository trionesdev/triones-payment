package com.trionesdev.payment.alipay.v3.payment.page;

import com.alipay.v3.api.AlipayTradeApi;
import com.alipay.v3.util.GenericExecuteApi;
import com.alipay.v3.util.model.AlipayConfig;
import com.trionesdev.payment.alipay.v3.AlipayPageCreateOrderRequest;
import com.trionesdev.payment.alipay.v3.payment.AlipayPaymentCommons;

public class AlipayPage extends AlipayPaymentCommons {
    GenericExecuteApi api = new GenericExecuteApi();
    public AlipayPage(AlipayConfig alipayConfig) {
        super(alipayConfig);
    }

    public void createOrderWithRequestPayment(AlipayPageCreateOrderRequest request){
//        AlipayTradeApi api = new AlipayTradeApi();
      api.sdkExecute("alipay.trade.page.pay", "");
    }

}
