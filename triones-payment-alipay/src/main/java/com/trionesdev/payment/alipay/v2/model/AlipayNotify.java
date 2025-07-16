package com.trionesdev.payment.alipay.v2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * @link https://opendocs.alipay.com/open/270/105902#%E5%BC%82%E6%AD%A5%E8%BF%94%E5%9B%9E%E7%BB%93%E6%9E%9C%E7%9A%84%E9%AA%8C%E7%AD%BE
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AlipayNotify {
    /**
     * 支付宝应用的APPID。支付宝分配给开发者的应用 ID
     */
    private String appId;
    /**
     * 支付宝交易号，支付宝交易凭证号。
     */
    private String tradeNo;
    /**
     * 商家订单号。原支付请求的商家订单号
     */
    private String outTradeNo;
    /**
     * 商家业务号。商家业务ID，通常是退款通知中返回的退款申请流水号
     */
    private String outBizNo;
    /**
     * 卖家支付宝账号 ID。以 2088 开头的纯 16 位数字
     */
    private String sellerId;
    /**
     * 交易状态。交易目前所处状态，详情可查看下表 交易状态说明
     */
    private String tradeStatus;
    /**
     * 订单金额。本次交易支付订单金额，单位为人民币（元），精确到小数点后 2 位
     */
    private BigDecimal totalAmount;
    /**
     * 实收金额。商家在交易中实际收到的款项，单位为人民币（元），精确到小数点后 2 位
     */
    private BigDecimal receiptAmount;
    /**
     * 开票金额。用户在交易中支付的可开发票的金额，单位为人民币（元），精确到小数点后 2 位
     */
    private BigDecimal invoiceAmount;
    /**
     * 用户在交易中支付的金额，单位为人民币（元）
     */
    private BigDecimal buyerPayAmount;
    /**
     * 使用集分宝支付金额，单位为人民币（元）
     */
    private BigDecimal pointAmount;
    /**
     * 总退款金额。退款通知中，返回总退款金额，单位为人民币（元）
     */
    private BigDecimal refundFee;
    /**
     * 订单标题/商品标题/交易标题/订单关键字等，是请求时对应参数，会在通知中原样传回
     */
    private String subject;
    private String body;
    /**
     * 交易创建时间
     */
    private Instant gmtCreate;
    /**
     * 交易付款时间
     */
    private Instant gmtPayment;
    /**
     * 交易退款时间
     */
    private Instant gmtRefund;
    /**
     * 交易结束时间
     */
    private Instant gmtClose;
}
