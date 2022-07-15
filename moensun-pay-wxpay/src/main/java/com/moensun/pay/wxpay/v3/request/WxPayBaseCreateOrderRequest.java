package com.moensun.pay.wxpay.v3.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class WxPayBaseCreateOrderRequest implements Serializable {
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

    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Amount{
        private int total;
        private String currency;
    }



    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SceneInfo{
        @JsonProperty(value = "payer_client_ip")
        private String payerClientIp;
        @JsonProperty(value = "device_id")
        private String deviceId;
        @JsonProperty(value = "store_info")
        private StoreInfo storeInfo;
    }


    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class  SettleInfo{
        @JsonProperty(value = "profit_sharing")
        private boolean profitSharing;
    }

    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StoreInfo{
        private String id;
        private String name;
        @JsonProperty(value = "area_code")
        private String areaCode;
        private String address;
    }

    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Detail{
        @JsonProperty(value = "cost_price")
        private int costPrice;
        @JsonProperty(value = "invoice_id")
        private String invoiceId;
        @JsonProperty(value = "goods_detail")
        private List<GoodsDetail> goodsDetail;
    }

    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GoodsDetail{
        @JsonProperty(value = "merchant_goods_id")
        private String MerchantGoodsId;
        @JsonProperty(value = "wechatpay_goods_id ")
        private String wechatPayGoodsId ;
        @JsonProperty(value = "goods_name")
        private String goodsName;
        private int quantity;
        @JsonProperty(value = "unit_price")
        private int unitPrice;
    }
}
