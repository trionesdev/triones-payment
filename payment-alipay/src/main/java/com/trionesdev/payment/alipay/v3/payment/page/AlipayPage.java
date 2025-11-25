package com.trionesdev.payment.alipay.v3.payment.page;

import com.alipay.v3.util.model.CustomizedParams;
import com.trionesdev.payment.alipay.v3.AlipayConfig;
import com.trionesdev.payment.alipay.v3.payment.AlipayPaymentCommons;
import com.trionesdev.payment.util.GsonUtils;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

public class AlipayPage extends AlipayPaymentCommons {


    public AlipayPage(AlipayConfig alipayConfig) {
        super(alipayConfig);
    }

    @SneakyThrows
    public AlipayTradePagePayResponseModel createOrder(AlipayTradePagePayModel request) {
        if (StringUtils.isBlank(request.getNotifyUrl())) {
            request.setNotifyUrl(alipayConfig.getNotifyUrl());
        }
        CustomizedParams customizedParams = new CustomizedParams();
        customizedParams.setBodyContent(GsonUtils.toJson(request));
        String pageRedirectionData = genericExecuteApi.pageExecute("alipay.trade.page.pay", "POST", null, "", "", customizedParams);
        return AlipayTradePagePayResponseModel.builder().pageRedirectionData(pageRedirectionData).build();
    }

}
