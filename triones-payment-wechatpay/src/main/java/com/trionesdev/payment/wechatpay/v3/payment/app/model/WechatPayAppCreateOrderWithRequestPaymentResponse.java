package com.trionesdev.payment.wechatpay.v3.payment.app.model;

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
public class WechatPayAppCreateOrderWithRequestPaymentResponse implements Serializable {
    private String appId;
    private String timeStamp;
    private String nonceStr;
    private String packageStr;
    private String paySign;
    private String signType;
}
