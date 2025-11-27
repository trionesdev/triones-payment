package com.trionesdev.payment.alipay.v3.util;

import com.google.common.collect.Maps;
import com.trionesdev.payment.alipay.v3.modal.AlipayNotifyModel;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class AlipayNotifyUtils {
    public static Map<String, String> parameters(Map<String, String[]> parameterMap) {
        Map<String, String> params = Maps.newHashMap();
        if (MapUtils.isEmpty(parameterMap)) {
            return params;
        }
        parameterMap.forEach((k, v) -> {
            if (ArrayUtils.isNotEmpty(v)) {
                params.put(k, StringUtils.join(v, ","));
            }
        });
        return params;
    }

    public static AlipayNotifyModel fromMap(Map<String, String> params) {
        return AlipayNotifyModel.builder()
                .appId(params.get("app_id"))
                .tradeNo(params.get("trade_no"))
                .outTradeNo(params.get("out_trade_no"))
                .outBizNo(params.get("out_biz_no"))
                .sellerId(params.get("seller_id"))
                .tradeStatus(params.get("trade_status"))
                .totalAmount(params.get("total_amount"))
                .receiptAmount(params.get("receipt_amount"))
                .invoiceAmount(params.get("invoice_amount"))
                .buyerPayAmount(params.get("buyer_pay_amount"))
                .pointAmount(params.get("point_amount"))
                .refundFee(params.get("refund_fee"))
                .subject(params.get("subject"))
                .body(params.get("body"))
                .gmtCreate(params.get("gmt_create"))
                .gmtPayment(params.get("gmt_payment"))
                .gmtRefund(params.get("gmt_refund"))
                .gmtClose(params.get("gmt_close"))
                .build();
    }

    public static AlipayNotifyModel fromMaps(Map<String, String[]> parameterMap) {
        Map<String, String> params = parameters(parameterMap);
        return fromMap(params);
    }

}
