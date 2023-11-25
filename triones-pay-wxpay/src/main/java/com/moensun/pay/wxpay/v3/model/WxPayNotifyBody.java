package com.moensun.pay.wxpay.v3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WxPayNotifyBody {
    private String id;
    @JsonProperty(value = "create_time")
    private String createTime;
    @JsonProperty(value = "event_type")
    private String eventType;
    @JsonProperty(value = "resource_type")
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
        @JsonProperty(value = "associated_data")
        private String associatedData;
        @JsonProperty(value = "original_type")
        private String originalType;
        private String nonce;
    }
}
