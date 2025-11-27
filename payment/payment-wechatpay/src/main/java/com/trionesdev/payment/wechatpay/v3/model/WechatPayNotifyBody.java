package com.trionesdev.payment.wechatpay.v3.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WechatPayNotifyBody {
    private String id;
    @SerializedName(value = "create_time")
    private String createTime;
    @SerializedName(value = "event_type")
    private String eventType;
    @SerializedName(value = "resource_type")
    private String resourceType;
    private String summary;
    private Resource resource;

    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Resource {
        private String algorithm;
        private String ciphertext;
        @SerializedName(value = "associated_data")
        private String associatedData;
        @SerializedName(value = "original_type")
        private String originalType;
        private String nonce;
    }
}
