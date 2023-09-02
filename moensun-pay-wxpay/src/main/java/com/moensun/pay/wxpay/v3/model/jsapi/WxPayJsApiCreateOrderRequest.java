package com.moensun.pay.wxpay.v3.model.jsapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moensun.pay.wxpay.v3.convert.WxPayJsApiConvertMapper;
import com.moensun.pay.wxpay.v3.model.WxPayBaseCreateOrderRequest;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class WxPayJsApiCreateOrderRequest extends WxPayBaseCreateOrderRequest {

    private Payer payer;

    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Payer {
        @JsonProperty(value = "openid")
        private String openId;
    }

    public PrepayRequest toPrepayRequest() {
        return WxPayJsApiConvertMapper.INSTANCE.from(this);
    }

}
