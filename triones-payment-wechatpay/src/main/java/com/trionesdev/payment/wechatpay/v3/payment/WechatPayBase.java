package com.trionesdev.payment.wechatpay.v3.payment;

import com.trionesdev.payment.wechatpay.v3.convert.WechatPayConvert;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayNotifyRequest;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayRefoundNotifyResponse;
import com.trionesdev.payment.wechatpay.v3.model.notify.WechatPayTransactionNotifyResponse;
import com.wechat.pay.java.core.Config;
import com.wechat.pay.java.core.RSAAutoCertificateConfig;
import com.wechat.pay.java.core.notification.NotificationConfig;
import com.wechat.pay.java.core.notification.NotificationParser;
import com.wechat.pay.java.core.util.PemUtil;
import com.wechat.pay.java.service.payments.model.Transaction;
import com.wechat.pay.java.service.refund.model.RefundNotification;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.cert.X509Certificate;

public abstract class WechatPayBase {
    private static final Logger log = LoggerFactory.getLogger(WechatPayBase.class);
    protected final WechatPayConfig wxPayConfig;
    protected final Config config;

    protected final NotificationParser notificationParser;

    public WechatPayBase(WechatPayConfig wxPayConfig) {
        this.wxPayConfig = wxPayConfig;
        this.config = buildConfig(wxPayConfig);
        this.notificationParser = new NotificationParser((NotificationConfig) config);
    }

    private Config buildConfig(WechatPayConfig wxPayConfig) {
        RSAAutoCertificateConfig.Builder builder = new RSAAutoCertificateConfig
                .Builder()
                .merchantId(wxPayConfig.getMchId())
                .merchantSerialNumber(wxPayConfig.getMerchantSerialNo())
                .apiV3Key(wxPayConfig.getApiV3Key());
        if (StringUtils.isBlank(wxPayConfig.getMerchantSerialNo())) {
            builder.merchantSerialNumber(getMerchantSerialNumber(wxPayConfig.getPrivateCertPath(), wxPayConfig.getPrivateCert()));
        }
        if (StringUtils.isNoneBlank(wxPayConfig.getPrivateKey())) {
            builder.privateKey(wxPayConfig.getPrivateKey());
        } else {
            builder.privateKeyFromPath(wxPayConfig.getPrivateKeyPath());
        }
        return builder.build();
    }

    private String getMerchantSerialNumber(String privateCertPath, String privateCert) {
        X509Certificate certificate = null;
        if (StringUtils.isNoneBlank(privateCert)) {
            certificate = PemUtil.loadX509FromString(privateCert);
        } else {
            certificate = PemUtil.loadX509FromPath(privateCertPath);
        }
        return certificate.getSerialNumber().toString(16).toUpperCase();
    }

    /**
     * 交易成功回调通知
     *
     * @param wxPayNotifyRequest
     */
    public WechatPayTransactionNotifyResponse transactionNotify(WechatPayNotifyRequest wxPayNotifyRequest) {
        Transaction transaction = notificationParser.parse(wxPayNotifyRequest.toRequestParam(), Transaction.class);
        return WechatPayConvert.INSTANCE.from(transaction);
    }

    /**
     * 退款成功回调
     *
     * @param wxPayNotifyRequest
     * @return
     */
    public WechatPayRefoundNotifyResponse refundNotify(WechatPayNotifyRequest wxPayNotifyRequest) {
        RefundNotification refundNotification = notificationParser.parse(wxPayNotifyRequest.toRequestParam(), RefundNotification.class);
        return WechatPayConvert.INSTANCE.from(refundNotification);
    }

}
