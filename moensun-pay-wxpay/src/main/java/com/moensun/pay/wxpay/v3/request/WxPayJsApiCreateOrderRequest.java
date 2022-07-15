package com.moensun.pay.wxpay.v3.request;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    public static class Payer{
        @JsonProperty(value = "openid")
        private String  	openId;
    }

}
