package com.trionesdev.payment.wxpay.v3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class WxPayBaseResponse implements Serializable {
    private String code;
    private String message;
    private ErrorDetail detail;

    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ErrorDetail implements Serializable{
        private String location;
        private String value;
    }
}
