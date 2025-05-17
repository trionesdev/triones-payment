package com.trionesdev.payment.wechatpay.v3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class WechatPayQueryOrderByIdRequest {
    private String transactionId;
    private String mchId;
}
