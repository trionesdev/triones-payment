package com.moensun.pay.wxpay.v3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TradeTypeEnum {
    APP("/v3/pay/transactions/app", ""),
    JSAPI("/v3/pay/transactions/jsapi", ""),
    NATIVE("/v3/pay/transactions/native", ""),
    H5("/v3/pay/transactions/h5", "");

    @Getter
    private String uri;
    @Getter
    private String partnerUri;
}
