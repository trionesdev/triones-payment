package com.moensun.pay.wxpay.v3.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class WxPaySignRequest implements Serializable {
    private String appId;
    private String timeStamp;
    private String nonceStr;
}
