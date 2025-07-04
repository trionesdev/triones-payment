package com.trionesdev.payment.wechatpay.v3.payment.model;

import com.google.gson.annotations.SerializedName;
import com.trionesdev.payment.wechatpay.v3.WechatPayConfig;
import com.trionesdev.payment.wechatpay.v3.payment.enums.FundsAccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Vector;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class WechatPayRefundCreateRequest {
    @SerializedName(value = "transaction_id")
    private String transactionId;
    @SerializedName(value = "out_trade_no")
    private String outTradeNo;
    @SerializedName(value = "out_refund_no")
    private String outRefundNo;
    private String reason;
    @SerializedName(value = "notify_url")
    private String notifyUrl;
    @SerializedName(value = "funds_account")
    private FundsAccount fundsAccount;
    private ReqRefundAmount amount;
    @SerializedName(value = "goods_detail")
    private List<GoodsDetail> goodsDetail;


    public void fill(WechatPayConfig config){
        if (StringUtils.isBlank(this.getNotifyUrl())) {
            this.setNotifyUrl(config.getRefundNotifyUrl());
        }
    }
}
