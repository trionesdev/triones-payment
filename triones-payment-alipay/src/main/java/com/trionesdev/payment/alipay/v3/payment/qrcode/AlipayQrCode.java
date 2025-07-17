package com.trionesdev.payment.alipay.v3.payment.qrcode;

import com.alipay.v3.model.AlipayTradePayResponseModel;
import com.alipay.v3.model.AlipayTradePrecreateModel;
import com.alipay.v3.model.AlipayTradePrecreateResponseModel;
import com.alipay.v3.util.AlipaySignature;
import com.trionesdev.payment.alipay.v3.AlipayConfig;
import com.trionesdev.payment.alipay.v3.payment.AlipayPaymentCommons;
import lombok.SneakyThrows;

public class AlipayQrCode extends AlipayPaymentCommons {
    public AlipayQrCode(AlipayConfig alipayConfig) {
        super(alipayConfig);
    }

    @SneakyThrows
    public AlipayTradePrecreateResponseModel preCreate(AlipayTradePrecreateModel model) {
        return alipayTradeApi.precreate(model);
    }
}
