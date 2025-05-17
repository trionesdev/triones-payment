package com.trionesdev.payment.wechatpay.v3.payment.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class WechatPayAppCreateOrderResponse implements Serializable {
    private String prepayId;
}
