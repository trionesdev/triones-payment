package com.trionesdev.payment.alipay.v3.payment.page;


import com.google.gson.annotations.SerializedName;
import com.trionesdev.payment.alipay.v3.modal.*;
import lombok.Data;

import java.util.List;

/**
 * https://opendocs.alipay.com/open-v3/2423fad5_alipay.trade.page.pay?scene=22&pathHash=3eadd5d3
 */
@Data
public class AlipayTradePagePayModel {
    private String outTradeNo;
    @SerializedName("total_amount")
    private String totalAmount;
    private String subject;
    @SerializedName("product_code")
    private String productCode = "FAST_INSTANT_TRADE_PAY";
    @SerializedName("qr_pay_mode")
    private String qrPayMode = "1";
    @SerializedName("qrcode_width")
    private Integer qrcodeWidth;
    @SerializedName("goods_detail")
    private List<GoodsDetail> goodsDetail;
    @SerializedName("time_expire")
    private String timeExpire;
    @SerializedName("sub_merchant")
    private SubMerchant subMerchant;
    @SerializedName("extend_params")
    private ExtendParams extendParams;
    @SerializedName("business_params")
    private String businessParams;
    @SerializedName("promo_params")
    private String promoParams;
    @SerializedName("integration_type")
    private String integrationType = "PCWEB";
    @SerializedName("request_from_url")
    private String requestFromUrl;
    @SerializedName("store_id")
    private String storeId;
    @SerializedName("merchant_order_no")
    private String merchantOrderNo;
    @SerializedName("ext_user_info")
    private ExtUserInfo extUserInfo;
    @SerializedName("invoice_info")
    private InvoiceInfo invoiceInfo;
    @SerializedName("notify_url")
    private String notifyUrl;
}
