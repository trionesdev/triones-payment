package com.trionesdev.payment.wechatpay.v3.payment.h5.model;

import com.google.gson.annotations.SerializedName;
import com.trionesdev.payment.wechatpay.v3.payment.h5.WechatPayH5Convert;
import com.wechat.pay.java.service.payments.h5.model.QueryOrderByIdRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WechatPayH5QueryOrderByIdRequest implements Serializable {
    @SerializedName(value = "transaction_id")
    private String transactionId;
    @SerializedName(value = "mchid")
    private String mchId;

    public QueryOrderByIdRequest toSdkRequest() {
        return WechatPayH5Convert.INSTANCE.from(this);
    }
}
