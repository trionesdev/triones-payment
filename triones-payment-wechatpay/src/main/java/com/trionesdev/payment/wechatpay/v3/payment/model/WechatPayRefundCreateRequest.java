package com.trionesdev.payment.wechatpay.v3.payment.model;

import com.google.gson.annotations.SerializedName;
import com.trionesdev.payment.wechatpay.v3.payment.enums.FundsAccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class WechatPayRefundCreateRequest {
    @SerializedName(value = "transaction_id")
    private String transactionId;
    @SerializedName(value = "out_trade_no")
    private String outTradeNo;
    private String reason;
    @SerializedName(value = "notify_url")
    private String notifyUrl;
    @SerializedName(value = "funds_account")
    private FundsAccount fundsAccount;
    private ReqRefundAmount amount;
    @SerializedName(value = "goods_detail")
    private List<GoodsDetail> goodsDetail;

}
