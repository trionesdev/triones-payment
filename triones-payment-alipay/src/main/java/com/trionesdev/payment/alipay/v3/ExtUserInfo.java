package com.trionesdev.payment.alipay.v3;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ExtUserInfo {
    @SerializedName("cert_no")
    private String  certNo;
    @SerializedName("min_age")
    private String minAge;
    private String name;
    private String mobile;
    @SerializedName("cert_type")
    private String certType;
    @SerializedName("need_check_info")
    private String needCheckInfo;
    @SerializedName("identity_hash")
    private String identityHash;
}
