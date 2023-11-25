package com.moensun.pay.wxpay;

public class WxPayException extends RuntimeException{
    private final String code;
    private final String message;

    public WxPayException(){
        super();
        this.code = null;
        this.message = null;
    }

    public WxPayException(String code,String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
