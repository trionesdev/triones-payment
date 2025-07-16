package com.trionesdev.payment.alipay.v3.modal;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ExtendParams {
    @SerializedName("sys_service_provider_id")
    private String sysServiceProviderId;
    @SerializedName("hb_fq_num")
    private String hbFqNum;
    @SerializedName("hb_fq_seller_percent")
    private String hbFqSellerPercent;
    @SerializedName("industry_reflux_info")
    private String industryRefluxInfo;
    @SerializedName("card_type")
    private String cardType;
    @SerializedName("royalty_freeze")
    private String royaltyFreeze;
}
