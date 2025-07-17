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
public class H5Info {
    private String type;
    @SerializedName(value = "app_name")
    private String appName;
    @SerializedName(value = "app_url")
    private String appUrl;
    @SerializedName(value = "bundle_id")
    private String bundleId;
    @SerializedName(value = "package_name")
    private String packageName;
}
