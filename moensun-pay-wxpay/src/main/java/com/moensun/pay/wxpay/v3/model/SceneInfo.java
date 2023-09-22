package com.moensun.pay.wxpay.v3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@Data
@Accessors(chain = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class SceneInfo {
    @JsonProperty(value = "payer_client_ip")
    private String payerClientIp;
    @JsonProperty(value = "device_id")
    private String deviceId;
    @JsonProperty(value = "store_info")
    private StoreInfo storeInfo;
}
