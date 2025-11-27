package com.trionesdev.payment.wechatpay.v3.payment.nativepay.model;

import com.google.gson.annotations.SerializedName;
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
    @SerializedName(value = "transaction_id")
    private String transactionId;
    @SerializedName(value = "mchid")
    private String mchId;

    public QueryOrderByIdRequest toSdkRequest() {
        return WechatPayNativeConvert.INSTANCE.from(this);
    }
}
