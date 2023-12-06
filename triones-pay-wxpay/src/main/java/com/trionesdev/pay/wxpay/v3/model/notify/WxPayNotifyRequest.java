package com.trionesdev.pay.wxpay.v3.model.notify;

import com.wechat.pay.java.core.notification.RequestParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayNotifyRequest {
    private String serial;
    private String nonce;
    private String timestamp;
    private String signature;
    private String body;

    public RequestParam toRequestParam() {
        return new RequestParam.Builder()
                .serialNumber(this.getSerial())
                .nonce(this.getNonce())
                .signature(this.getSignature())
                .timestamp(this.getTimestamp())
                .body(this.getBody())
                .build();
    }
}
