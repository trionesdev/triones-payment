package com.trionesdev.pay.wxpay.v3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trionesdev.pay.wxpay.v3.payment.WxPayConfig;
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
public  class WxPayBaseCreateOrderRequest implements Serializable {
    @JsonProperty(value = "appid")
    private String appId;
    @JsonProperty(value = "mchid")
    private String mchId;
    private String description;
    @JsonProperty(value = "out_trade_no")
    private String outTradeNo;
    /**
     * Instant.now().toString() 得到的就是符合要求的时间字符串
     */
    @JsonProperty(value = "time_expire")
    private String timeExpire;
    private String attach;
    @JsonProperty(value = "notify_url")
    private String notifyUrl;
    @JsonProperty(value = "goods_tag")
    private String goodsTag;
    private Amount amount;
    private Detail detail;
    @JsonProperty(value = "scene_info")
    private SceneInfo sceneInfo;
    @JsonProperty(value = "settle_info")
    private SettleInfo settleInfo;


    public void fill(WxPayConfig config) {
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
