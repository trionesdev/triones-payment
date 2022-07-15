package com.moensun.pay.wxpay.v3.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayCreateOrderGeneralResponse extends WxPayBaseResponse {
    @JsonProperty(value = "prepay_id")
    private String prepayId;
    @JsonProperty(value = "code_url")
    private String codeUrl;
}
