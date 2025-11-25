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
public class StoreInfo {
    private String id;
    private String name;
    @SerializedName(value = "area_code")
    private String areaCode;
    private String address;
}
