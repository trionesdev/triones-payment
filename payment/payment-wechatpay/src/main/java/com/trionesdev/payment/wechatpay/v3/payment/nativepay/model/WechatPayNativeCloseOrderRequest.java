package com.trionesdev.payment.wechatpay.v3.payment.nativepay.model;

import com.google.gson.annotations.SerializedName;
import com.trionesdev.payment.wechatpay.v3.payment.nativepay.WechatPayNativeConvert;
import com.wechat.pay.java.service.payments.nativepay.model.CloseOrderRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WechatPayNativeCloseOrderRequest implements Serializable {
    @SerializedName(value = "out_trade_no")
    private String outTradeNo;

    @SerializedName(value = "mchid")
    private String mchId;

    public CloseOrderRequest toSdkRequest() {
        return WechatPayNativeConvert.INSTANCE.from(this);
    }
}
