package com.moensun.pay.wxpay.v3.response;

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
public class WxPayJsApiInvokePaymentResponse implements Serializable {
    private String prepayId;
    private String appId;
    private String timeStamp;
    private String nonceStr;
    private String packageStr;
    private String paySign;
}
