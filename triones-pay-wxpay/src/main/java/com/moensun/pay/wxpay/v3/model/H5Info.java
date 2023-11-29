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
public class H5Info {
    private String type;
    @JsonProperty(value = "app_name")
    private String appName;
    @JsonProperty(value = "app_url")
    private String appUrl;
    @JsonProperty(value = "bundle_id")
    private String bundleId;
    @JsonProperty(value = "package_name")
    private String packageName;
}
