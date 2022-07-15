package com.moensun.pay.alipay.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AlipayNotify {
    private String tradeNo;
    private String outTradeNo;
}
