package com.trionesdev.payment.wechatpay.v3.payment.nativepay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trionesdev.payment.wechatpay.v3.payment.nativepay.WechatPayNativeConvert;
import com.wechat.pay.java.service.payments.nativepay.model.QueryOrderByIdRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WechatPayNativeQueryOrderByIdRequest implements Serializable {
    @JsonProperty(value = "transaction_id")
    private String transactionId;
    @JsonProperty(value = "mchid")
    private String mchId;

    public QueryOrderByIdRequest toSdkRequest() {
        return WechatPayNativeConvert.INSTANCE.from(this);
    }
}
