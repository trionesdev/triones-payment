package com.trionesdev.payment.alipay.v2;

import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayResponse;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.trionesdev.payment.alipay.AliPayException;
import com.trionesdev.payment.alipay.util.AlipaySignatureUtils;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Objects;


public abstract class AlipayBase {
    protected final AlipayClient alipayClient;
    protected final AlipayIntegrationConfig alipayConfig;

    @SneakyThrows
    public AlipayBase(AlipayIntegrationConfig alipayConfig) {
        this.alipayConfig = alipayConfig;
        alipayClient = new DefaultAlipayClient(alipayConfig);
    }


    public boolean certRequest() {
        return StringUtils.isBlank(alipayConfig.getAlipayPublicKey());
    }

    /**
     * 此方法会去掉sign_type做验签
     * @param params
     * @return
     */
    @SneakyThrows
    public boolean rsaCheckV1(Map<String, String> params){
        if(certRequest()){
            if (StringUtils.isNotBlank(alipayConfig.getAlipayPublicCertContent())) {
                return AlipaySignatureUtils.rsaCertContentCheckV1(params, alipayConfig.getAlipayPublicCertContent(), alipayConfig.getCharset(), alipayConfig.getSignType());
            }else {
                return AlipaySignature.rsaCertCheckV1(params, alipayConfig.getAlipayPublicCertPath(), alipayConfig.getCharset(), alipayConfig.getSignType());
            }
        }else {
            return AlipaySignature.rsaCheckV1(params, alipayConfig.getAlipayPublicKey(), alipayConfig.getCharset(), alipayConfig.getSignType());
        }
    }

    /**
     * 此方法不会去掉sign_type验签
     * @param params
     * @return
     */
    @SneakyThrows
    public boolean rsaCheckV2(Map<String, String> params) {
        if (certRequest()) {
            if (StringUtils.isNotBlank(alipayConfig.getAlipayPublicCertContent())) {
                return AlipaySignatureUtils.rsaCertContentCheckV2(params, alipayConfig.getAlipayPublicCertContent(), alipayConfig.getCharset(), alipayConfig.getSignType());
            } else {
                return AlipaySignature.rsaCertCheckV2(params, alipayConfig.getAlipayPublicCertPath(), alipayConfig.getCharset(), alipayConfig.getSignType());
            }
        } else {
            return AlipaySignature.rsaCheckV2(params, alipayConfig.getAlipayPublicKey(), alipayConfig.getCharset(), alipayConfig.getSignType());
        }
    }

    private  <T extends AlipayResponse> T responseInterceptor(T response ){
        if(!Objects.equals("10000",response.getCode())){
            throw new AliPayException(response.getCode(), response.getMsg()+":"+response.getSubMsg());
        }
        return response;
    }

}
