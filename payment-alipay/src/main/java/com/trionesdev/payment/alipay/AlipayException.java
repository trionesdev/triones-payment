package com.trionesdev.payment.alipay;

public class AlipayException extends RuntimeException{
    private final String code;
    private final String message;

    public AlipayException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
