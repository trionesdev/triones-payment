package com.moensun.pay.wxpay.v3.util;

import com.google.common.io.Resources;
import com.moensun.pay.wxpay.v3.WxPayIntegrationConfig;
import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
import com.wechat.pay.contrib.apache.httpclient.auth.*;
import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Objects;

public class WxPayUtils {

    public static CloseableHttpClient buildHttpClient(WxPayIntegrationConfig wxPayIntegrationConfig) throws IOException {
        PrivateKey merchantPrivateKey = loadPrivateKey(wxPayIntegrationConfig.getPrivateKeyPath(), wxPayIntegrationConfig.getPrivateKeyContent());
        X509Certificate certificate = loadCertificate(wxPayIntegrationConfig.getPrivateCertPath(), wxPayIntegrationConfig.getPrivateCertContent());
        String merchantSerialNumber = certificate.getSerialNumber().toString(16).toUpperCase();

        AutoUpdateCertificatesVerifier verifier = new AutoUpdateCertificatesVerifier(
                new WechatPay2Credentials(wxPayIntegrationConfig.getMchId(), new PrivateKeySigner(merchantSerialNumber, merchantPrivateKey)),
                wxPayIntegrationConfig.getApiV3Key().getBytes(StandardCharsets.UTF_8));
        return buildHttpClient(wxPayIntegrationConfig, merchantPrivateKey, certificate, verifier);
    }

    public static CloseableHttpClient buildHttpClient(WxPayIntegrationConfig wxPayIntegrationConfig, PrivateKey privateKey, X509Certificate certificate, Verifier verifier) throws IOException {
        PrivateKey merchantPrivateKey = privateKey;
        X509Certificate privateCertificate = certificate;
        Verifier payVerifier = verifier;
        if (Objects.isNull(merchantPrivateKey)) {
            merchantPrivateKey = loadPrivateKey(wxPayIntegrationConfig.getPrivateKeyPath(), wxPayIntegrationConfig.getPrivateKeyContent());
        }
        if (Objects.isNull(privateCertificate)) {
            privateCertificate = loadCertificate(wxPayIntegrationConfig.getPrivateCertPath(), wxPayIntegrationConfig.getPrivateCertContent());
        }
        String merchantSerialNumber = privateCertificate.getSerialNumber().toString(16).toUpperCase();
        if (Objects.isNull(payVerifier)) {
            payVerifier = new AutoUpdateCertificatesVerifier(
                    new WechatPay2Credentials(wxPayIntegrationConfig.getMchId(), new PrivateKeySigner(merchantSerialNumber, merchantPrivateKey)),
                    wxPayIntegrationConfig.getApiV3Key().getBytes(StandardCharsets.UTF_8));
        }
        WechatPayHttpClientBuilder builder = WechatPayHttpClientBuilder.create()
                .withMerchant(wxPayIntegrationConfig.getMchId(), merchantSerialNumber, merchantPrivateKey)
                .withValidator(new WechatPay2Validator(payVerifier));

        return builder.build();
    }

    public static Verifier verifier(WxPayIntegrationConfig wxPayIntegrationConfig) throws IOException {
        PrivateKey merchantPrivateKey = loadPrivateKey(wxPayIntegrationConfig.getPrivateKeyPath(), wxPayIntegrationConfig.getPrivateKeyContent());
        X509Certificate certificate = loadCertificate(wxPayIntegrationConfig.getPrivateCertPath(), wxPayIntegrationConfig.getPrivateCertContent());
        String merchantSerialNumber = certificate.getSerialNumber().toString(16).toUpperCase();
        return new AutoUpdateCertificatesVerifier(
                new WechatPay2Credentials(wxPayIntegrationConfig.getMchId(), new PrivateKeySigner(merchantSerialNumber, merchantPrivateKey)),
                wxPayIntegrationConfig.getApiV3Key().getBytes(StandardCharsets.UTF_8));
    }

    public static PrivateKey loadPrivateKey(String privateKeyPath, byte[] privateKeyContent) throws IOException {
        InputStream privateKeyStream;
        if (ArrayUtils.isNotEmpty(privateKeyContent)) {
            privateKeyStream = new ByteArrayInputStream(privateKeyContent);
        } else {
            if (StringUtils.startsWith(privateKeyPath, "classpath")) {
                privateKeyStream = getResource(privateKeyPath).openStream();
            } else {
                privateKeyStream = new FileInputStream(privateKeyPath);
            }
        }
        return PemUtil.loadPrivateKey(privateKeyStream);
    }

    public static X509Certificate loadCertificate(String privateCertPath, byte[] privateCertContent) throws IOException {
        InputStream privateCertStream;
        if (ArrayUtils.isNotEmpty(privateCertContent)) {
            privateCertStream = new ByteArrayInputStream(privateCertContent);
        } else {
            if (StringUtils.startsWith(privateCertPath, "classpath")) {
                privateCertStream = getResource(privateCertPath).openStream();
            } else {
                privateCertStream = new FileInputStream(privateCertPath);
            }
        }
        return PemUtil.loadCertificate(privateCertStream);
    }

    private static URL getResource(String path) {
        path = path.replaceFirst("classpath\\*?:\\/?", "");
        return Resources.getResource(path);
    }

}
