package com.trionesdev.payment.wechatpay.v3.payment.nativepay.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
public class WechatPayNativeCreateOrderResponse implements Serializable {
    private String codeUrl;
}
