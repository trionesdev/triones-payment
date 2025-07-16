package com.trionesdev.payment.alipay.v3.modal;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class keyInfo {
    @SerializedName("is_support_invoice")
    private Boolean supportInvoice;
    @SerializedName("invoice_merchant_name")
    private String invoiceMerchantName;
    @SerializedName("tax_num")
    private String taxNum;
}
