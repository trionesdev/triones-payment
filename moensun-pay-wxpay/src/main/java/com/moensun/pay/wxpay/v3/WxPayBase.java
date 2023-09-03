package com.moensun.pay.wxpay.v3;

import com.moensun.pay.wxpay.v3.convert.WxPayConvertMapper;
import com.moensun.pay.wxpay.v3.model.notify.WxPayNotifyRequest;
import com.moensun.pay.wxpay.v3.model.notify.WxPayRefoundNotifyResponse;
import com.moensun.pay.wxpay.v3.model.notify.WxPayTransactionNotifyResponse;
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

public abstract class WxPayBase {
    private static final Logger log = LoggerFactory.getLogger(WxPayBase.class);
    protected final WxPayConfig wxPayConfig;
    protected final Config config;

    private final NotificationParser notificationParser;

    public WxPayBase(WxPayConfig wxPayConfig) {
        this.wxPayConfig = wxPayConfig;
        this.config = buildConfig(wxPayConfig);
        this.notificationParser = new NotificationParser((NotificationConfig) config);
    }

    private Config buildConfig(WxPayConfig wxPayConfig) {
        RSAAutoCertificateConfig.Builder builder = new RSAAutoCertificateConfig
                .Builder()
                .merchantId(wxPayConfig.getMchId())
                .merchantSerialNumber(getMerchantSerialNumber(wxPayConfig.getPrivateCertPath(), wxPayConfig.getPrivateCert()))
                .apiV3Key(wxPayConfig.getApiV3Key());
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
    public WxPayTransactionNotifyResponse transactionNotify(WxPayNotifyRequest wxPayNotifyRequest) {
        Transaction transaction = notificationParser.parse(wxPayNotifyRequest.toRequestParam(), Transaction.class);
        return WxPayConvertMapper.INSTANCE.from(transaction);
    }

    /**
     * 退款成功回调
     *
     * @param wxPayNotifyRequest
     * @return
     */
    public WxPayRefoundNotifyResponse refundNotify(WxPayNotifyRequest wxPayNotifyRequest) {
        RefundNotification refundNotification = notificationParser.parse(wxPayNotifyRequest.toRequestParam(), RefundNotification.class);
        return WxPayConvertMapper.INSTANCE.from(refundNotification);
    }

}
