package com.trionesdev.payment.wechatpay.v3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WechatPayNotifyResult {
    public String code;
    private String message;

    public static WechatPayNotifyResult success(){
        return WechatPayNotifyResult.builder().code("SUCCESS").message("成功").build();
    }

    public static WechatPayNotifyResult failure(){
        return WechatPayNotifyResult.builder().code("FAILURE").message("失败").build();
    }
}
