package com.moensun.pay.wxpay.v3.nativepay.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
public class WxPayNativeCreateOrderResponse implements Serializable {
    private String codeUrl;
}
