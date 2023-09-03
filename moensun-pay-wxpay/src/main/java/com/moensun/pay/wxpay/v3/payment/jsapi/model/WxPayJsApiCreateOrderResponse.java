package com.moensun.pay.wxpay.v3.payment.jsapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayJsApiCreateOrderResponse implements Serializable {
    private String prepayId;
}
