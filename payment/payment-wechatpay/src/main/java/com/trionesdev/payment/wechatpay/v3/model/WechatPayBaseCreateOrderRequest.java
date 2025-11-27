package com.trionesdev.payment.wechatpay.v3.model;

import com.google.gson.annotations.SerializedName;
import com.trionesdev.payment.wechatpay.v3.WechatPayConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public  class WechatPayBaseCreateOrderRequest implements Serializable {
    @SerializedName(value = "appid")
    private String appId;
    @SerializedName(value = "mchid")
    private String mchId;
    private String description;
    @SerializedName(value = "out_trade_no")
    private String outTradeNo;
    /**
     * Instant.now().toString() 得到的就是符合要求的时间字符串
     */
    @SerializedName(value = "time_expire")
    private String timeExpire;
    private String attach;
    @SerializedName(value = "notify_url")
    private String notifyUrl;
    @SerializedName(value = "goods_tag")
    private String goodsTag;
    private Amount amount;
    private Detail detail;
    @SerializedName(value = "scene_info")
    private SceneInfo sceneInfo;
    @SerializedName(value = "settle_info")
    private SettleInfo settleInfo;


    public void fill(WechatPayConfig config) {
        if (StringUtils.isBlank(this.getAppId())) {
            this.setAppId(config.getAppId());
        }
        if (StringUtils.isBlank(this.getMchId())) {
            this.setMchId(config.getMchId());
        }
        if (StringUtils.isBlank(this.getNotifyUrl())) {
            this.setNotifyUrl(config.getTransactionNotifyUrl());
        }
    }
}
