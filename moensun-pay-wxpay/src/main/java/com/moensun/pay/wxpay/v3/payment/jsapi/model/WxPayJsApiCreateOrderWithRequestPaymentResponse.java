package com.moensun.pay.wxpay.v3.payment.jsapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * jsapi调起支付需要的参数
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayJsApiCreateOrderWithRequestPaymentResponse implements Serializable {
    private String appId;
    private String timeStamp;
    private String nonceStr;
    private String packageStr;
    private String paySign;
}
