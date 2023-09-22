package com.moensun.pay.wxpay.v3.payment.nativepay.model;

import com.moensun.pay.wxpay.v3.model.Payer;
import com.moensun.pay.wxpay.v3.payment.WxPayConfig;
import com.moensun.pay.wxpay.v3.payment.nativepay.WxPayNativeConvertMapper;
import com.moensun.pay.wxpay.v3.model.WxPayBaseCreateOrderRequest;
import com.wechat.pay.java.service.payments.nativepay.model.PrepayRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayNativeCreateOrderRequest extends WxPayBaseCreateOrderRequest {
    private Payer payer;
    public PrepayRequest toSdkRequest(WxPayConfig config) {
        this.fill(config);
        return WxPayNativeConvertMapper.INSTANCE.from(this);
    }
}
