package com.trionesdev.payment.alipay.util;

import com.alipay.api.AlipayApiException;

import java.util.Map;

import static com.alipay.api.internal.util.AlipaySignature.rsaCheckV1;
import static com.alipay.api.internal.util.AlipaySignature.rsaCheckV2;

public class AlipaySignatureUtils {

    public static boolean rsaCertContentCheckV1(Map<String, String> params, String alipayPublicCertContent,
                                                String charset) throws AlipayApiException {
        String publicKey = AlipayCertificationUtils.getAlipayPublicKeyFromContent(alipayPublicCertContent);
        return rsaCheckV1(params, publicKey, charset);
    }

    public static boolean rsaCertContentCheckV1(Map<String, String> params, String alipayPublicCertContent,
                                                String charset, String signType) throws AlipayApiException {
        String publicKey = AlipayCertificationUtils.getAlipayPublicKeyFromContent(alipayPublicCertContent);
        return rsaCheckV1(params, publicKey, charset, signType);
    }

    public static boolean rsaCertContentCheckV2(Map<String, String> params, String alipayPublicCertContent,
                                                String charset) throws AlipayApiException {
        String publicKey = AlipayCertificationUtils.getAlipayPublicKeyFromContent(alipayPublicCertContent);
        return rsaCheckV2(params, publicKey, charset);
    }

    public static boolean rsaCertContentCheckV2(Map<String, String> params, String alipayPublicCertContent,
                                                String charset, String signType) throws AlipayApiException {
        String publicKey = AlipayCertificationUtils.getAlipayPublicKeyFromContent(alipayPublicCertContent);
        return rsaCheckV2(params, publicKey, charset, signType);
    }

}
