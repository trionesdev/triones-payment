package com.trionesdev.pay.alipay.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AntCertificationUtil;
import com.alipay.api.internal.util.codec.Base64;

import java.security.PublicKey;
import java.security.cert.X509Certificate;

public class AlipayCertificationUtils {

    public static String getAlipayPublicKeyFromContent(String alipayPublicCertContent) throws AlipayApiException {
        X509Certificate certificate = AntCertificationUtil.getCertFromContent(alipayPublicCertContent);
        PublicKey publicKey = certificate.getPublicKey();
        return Base64.encodeBase64String(publicKey.getEncoded());
    }

}
