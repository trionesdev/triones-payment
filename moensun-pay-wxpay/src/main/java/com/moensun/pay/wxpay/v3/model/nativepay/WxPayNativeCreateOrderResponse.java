package com.moensun.pay.wxpay.v3.model.nativepay;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
public class WxPayNativeCreateOrderResponse implements Serializable {
    private String codeUrl;
}
