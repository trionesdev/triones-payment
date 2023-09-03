package com.moensun.pay.wxpay.v3.model.notify;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moensun.pay.wxpay.v3.nativepay.WxPayNativeConvertMapper;
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
public class WxPayNativeQueryOrderByIdRequest implements Serializable {
    @JsonProperty(value = "transaction_id")
    private String transactionId;
    private String mchid;

    public QueryOrderByIdRequest toSdkRequest() {
        return WxPayNativeConvertMapper.INSTANCE.from(this);
    }
}
