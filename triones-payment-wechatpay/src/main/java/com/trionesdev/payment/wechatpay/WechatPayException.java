package com.trionesdev.payment.wechatpay;

public class WechatPayException extends RuntimeException{
    private final String code;
    private final String message;

    public WechatPayException(){
        super();
        this.code = null;
        this.message = null;
    }

    public WechatPayException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
