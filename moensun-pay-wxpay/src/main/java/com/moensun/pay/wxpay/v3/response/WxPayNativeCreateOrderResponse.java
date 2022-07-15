package com.moensun.pay.wxpay.v3.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
public class WxPayNativeCreateOrderResponse implements Serializable {
    private String codeUrl;
}
