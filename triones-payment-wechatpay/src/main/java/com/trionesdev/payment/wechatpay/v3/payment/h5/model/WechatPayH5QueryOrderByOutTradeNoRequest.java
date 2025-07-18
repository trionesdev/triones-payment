package com.trionesdev.payment.wechatpay.v3.payment.h5.model;

import com.google.gson.annotations.SerializedName;
import com.trionesdev.payment.wechatpay.v3.payment.h5.WechatPayH5Convert;
import com.wechat.pay.java.service.payments.h5.model.QueryOrderByOutTradeNoRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WechatPayH5QueryOrderByOutTradeNoRequest implements Serializable {
    @SerializedName(value = "out_trade_no")
    private String outTradeNo;
    @SerializedName(value = "mchId")
    private String mchId;

    public QueryOrderByOutTradeNoRequest toSdkRequest() {
        return WechatPayH5Convert.INSTANCE.from(this);
    }
}
