package com.trionesdev.pay.wxpay.v3.payment.jsapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayJsApiCreateOrderResponse implements Serializable {
    private String prepayId;
}
