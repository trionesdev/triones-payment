package com.trionesdev.pay.wxpay.v3.payment.h5.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
public class WxPayH5CreateOrderResponse implements Serializable {
    private String h5Url;
}
