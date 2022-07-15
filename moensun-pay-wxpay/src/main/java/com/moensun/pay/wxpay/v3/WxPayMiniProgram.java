package com.moensun.pay.wxpay.v3;

import com.moensun.pay.wxpay.v3.request.WxPayJsApiCreateOrderRequest;
import com.moensun.pay.wxpay.v3.request.WxPayNativeCreateOrderRequest;
import com.moensun.pay.wxpay.v3.response.WxPayJsApiCreateOrderResponse;
import com.moensun.pay.wxpay.v3.response.WxPayJsApiInvokePaymentResponse;
import com.moensun.pay.wxpay.v3.response.WxPayNativeCreateOrderResponse;

/**
 * 微信小程序支付
 */
public class WxPayMiniProgram extends WxPayBase {
    public WxPayMiniProgram(WxPayIntegrationConfig wxPayIntegrationConfig) {
        super(wxPayIntegrationConfig);
    }

    /**
     * 创建订单
     * @param request
     * @return
     */
    public WxPayJsApiCreateOrderResponse createOrder(WxPayJsApiCreateOrderRequest request) {
        return jsApiCreateOrder(request);
    }

    /**
     * 调起支付
     * @param orderRequest
     * @return
     */
    public WxPayJsApiInvokePaymentResponse invokePayment(WxPayJsApiCreateOrderRequest orderRequest){
        return jsApiInvokePayment(orderRequest);
    }

    /**
     * 扫码支付
     * @param request
     * @return
     */
    public WxPayNativeCreateOrderResponse scanCodePayment(WxPayNativeCreateOrderRequest request){
        return nativeCreateOrder(request);
    }

}
