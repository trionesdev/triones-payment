package com.trionesdev.payment.alipay.v3;

import com.alipay.v3.ApiClient;
import com.alipay.v3.Configuration;
import com.alipay.v3.api.AlipayTradeApi;
import com.alipay.v3.util.GenericExecuteApi;
import lombok.SneakyThrows;

public class AlipayBase {
    protected AlipayConfig alipayConfig;
    protected ApiClient defaultClient = Configuration.getDefaultApiClient();
    protected GenericExecuteApi genericExecuteApi = new GenericExecuteApi();
    protected AlipayTradeApi alipayTradeApi = new AlipayTradeApi();

    @SneakyThrows
    public AlipayBase(AlipayConfig alipayConfig) {
        this.alipayConfig = alipayConfig;
        defaultClient.setAlipayConfig(alipayConfig);
    }
}
