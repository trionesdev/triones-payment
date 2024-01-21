package com.trionesdev.payment.wxpay.v3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayNotifyResult {
    public String code;
    private String message;

    public static WxPayNotifyResult success(){
        return WxPayNotifyResult.builder().code("SUCCESS").message("成功").build();
    }

    public static WxPayNotifyResult failure(){
        return WxPayNotifyResult.builder().code("FAILURE").message("失败").build();
    }
}
