package com.trionesdev.payment.wxpay.v3.payment.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class WxPayAppCreateOrderResponse implements Serializable {
    private String prepayId;
}
