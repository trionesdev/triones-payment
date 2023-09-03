package com.moensun.pay.wxpay.v3.payment.app.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
public class WxPayAppCreateOrderResponse implements Serializable {
    private String codeUrl;
}
