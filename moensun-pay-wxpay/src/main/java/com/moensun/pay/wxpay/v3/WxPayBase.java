package com.moensun.pay.wxpay.v3;

import com.moensun.pay.wxpay.WxPayException;
import com.moensun.pay.wxpay.v3.request.WxPayBaseCreateOrderRequest;
import com.moensun.pay.wxpay.v3.request.WxPayJsApiCreateOrderRequest;
import com.moensun.pay.wxpay.v3.request.WxPayJsApiSignRequest;
import com.moensun.pay.wxpay.v3.response.WxPayCreateOrderGeneralResponse;
import com.moensun.pay.wxpay.v3.response.WxPayJsApiCreateOrderResponse;
import com.moensun.pay.wxpay.v3.response.WxPayJsApiInvokePaymentResponse;
import com.moensun.pay.wxpay.v3.response.WxPayNativeCreateOrderResponse;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.Instant;
import java.util.Objects;

public abstract class WxPayBase extends WxPay{
    public WxPayBase(WxPayIntegrationConfig wxPayIntegrationConfig) {
        super(wxPayIntegrationConfig);
    }


//    public abstract <T extends WxPayBaseCreateOrderRequest,E extends WxPayBaseResponse> WxPayBaseResponse createOrder(T request);

    protected <T extends WxPayBaseCreateOrderRequest> WxPayJsApiCreateOrderResponse jsApiCreateOrder(T orderRequest) {
        WxPayCreateOrderGeneralResponse response = createOrderGeneral(TradeTypeEnum.JSAPI, orderRequest);
        if (Objects.nonNull(response.getCode())) {
            throw new WxPayException(response.getCode(), response.getMessage());
        }
        return WxPayJsApiCreateOrderResponse.builder().prepayId(response.getPrepayId()).build();
    }


    protected <T extends WxPayBaseCreateOrderRequest> WxPayNativeCreateOrderResponse nativeCreateOrder(T orderRequest) {
        WxPayCreateOrderGeneralResponse response = createOrderGeneral(TradeTypeEnum.NATIVE, orderRequest);
        if (Objects.nonNull(response.getCode())) {
            throw new WxPayException(response.getCode(), response.getMessage());
        }
        return WxPayNativeCreateOrderResponse.builder().codeUrl(response.getCodeUrl()).build();
    }

    public String jsApiSignature(WxPayJsApiSignRequest request) {
        String sb = request.getAppId() + "\n" +
                request.getTimeStamp() + "\n" +
                request.getNonceStr() + "\n" +
                request.getPackageStr() + "\n";

        return signatureGeneral(sb);
    }

    /**
     * 创建支付订单，并且完成客户端需要的签名,调起支付
     *
     * @param orderRequest
     * @return
     */
    protected WxPayJsApiInvokePaymentResponse jsApiInvokePayment(WxPayJsApiCreateOrderRequest orderRequest) {
        WxPayJsApiCreateOrderResponse res = jsApiCreateOrder(orderRequest);
        String appId = getAppId();
        String nonceStr = RandomStringUtils.randomAlphabetic(16);
        String timeStamp = String.valueOf(Instant.now().toEpochMilli());
        String packageStr = "prepay_id=" + res.getPrepayId();
        WxPayJsApiSignRequest signRequest = WxPayJsApiSignRequest.builder()
                .appId(appId)
                .timeStamp(timeStamp)
                .nonceStr(nonceStr)
                .packageStr(packageStr)
                .build();
        String paySign = jsApiSignature(signRequest);
        return WxPayJsApiInvokePaymentResponse.builder()
                .prepayId(res.getPrepayId())
                .appId(appId)
                .timeStamp(timeStamp)
                .nonceStr(nonceStr)
                .packageStr(packageStr)
                .paySign(paySign)
                .build();
    }

}
