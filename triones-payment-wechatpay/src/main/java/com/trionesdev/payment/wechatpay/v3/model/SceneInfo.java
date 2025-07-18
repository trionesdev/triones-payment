package com.trionesdev.payment.wechatpay.v3.model;

import com.google.gson.annotations.SerializedName;
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
    @SerializedName(value = "payer_client_ip")
    private String payerClientIp;
    @SerializedName(value = "device_id")
    private String deviceId;
    @SerializedName(value = "store_info")
    private StoreInfo storeInfo;
    @SerializedName(value = "h5_info")
    private H5Info h5Info;
}
