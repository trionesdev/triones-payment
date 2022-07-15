package com.moensun.pay.wxpay.v3.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
public class WxPayJsApiCreateOrderResponse implements Serializable {
    private String prepayId;
}
