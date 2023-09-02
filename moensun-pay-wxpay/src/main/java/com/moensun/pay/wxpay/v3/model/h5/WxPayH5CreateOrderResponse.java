package com.moensun.pay.wxpay.v3.model.h5;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
public class WxPayH5CreateOrderResponse implements Serializable {
    private String h5Url;
}
