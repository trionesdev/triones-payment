package com.moensun.pay.alipay;

public class AliPayException extends RuntimeException{
    private final String code;
    private final String message;

    public AliPayException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
