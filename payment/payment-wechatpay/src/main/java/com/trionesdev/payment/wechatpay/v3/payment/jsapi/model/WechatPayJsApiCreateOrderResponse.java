package com.trionesdev.payment.wechatpay.v3.payment.jsapi.model;

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
public class WechatPayJsApiCreateOrderResponse implements Serializable {
    private String prepayId;
}
