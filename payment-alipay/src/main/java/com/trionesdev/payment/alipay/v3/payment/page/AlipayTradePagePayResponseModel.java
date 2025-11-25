package com.trionesdev.payment.alipay.v3.payment.page;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class AlipayTradePagePayResponseModel {
    private String pageRedirectionData;
}
