package com.moensun.pay.wxpay;

import com.moensun.pay.wxpay.v3.WxPayIntegrationConfig;
import com.moensun.pay.wxpay.v3.WxPayMiniProgram;
import com.moensun.pay.wxpay.v3.request.WxPayJsApiCreateOrderRequest;
import com.moensun.pay.wxpay.v3.request.WxPayNativeCreateOrderRequest;
import com.moensun.pay.wxpay.v3.response.WxPayJsApiCreateOrderResponse;
import com.moensun.pay.wxpay.v3.response.WxPayNativeCreateOrderResponse;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Test;


public class WxPayV3MiniProgramTest {

    public String privateKeyBase64="LS0tLS1CRUdJTiBQUklWQVRFIEtFWS0tLS0tCk1JSUV2UUlCQURBTkJna3Foa2lHOXcwQkFRRUZBQVNDQktjd2dnU2pBZ0VBQW9JQkFRQ3Y0Um5KaEZNUWJSQloKSlVUbmt6TnQ2L1grdkllR3V4czdnWEhTSElNNUVXV0xPYnVZaGhQYngvODJ0VnlRbVVGUDhHb2E4Y2ZWdzNVVgpwUkVOWWt1aHNXeE5TeTVBaWtNZ2VnRnM3MzBYOGU2SlVDajI3OERjUlhSUnlMeGNmZW9qZTg0c0x1MkptUUdICmNKV1orOEwvaXJUUGVJdE5uejZjaXRBbG05N21SSkRKSnJEYndKdGlnaWRGMTNSY1JsV3JBd3VCdnhIcU9ZUmEKcHhiS1NxMGszVXdwbnoyOHExMkJCMldNUFAwOGlhR2F1NGM2ZXo5aHkyZ3lsazBJT1BnZWlzSXNZQ2MyeFcwZgp1aC9jZVpRZU0ya3lKeEs4RGxEWVFWYmpsM3cyaGFxWnEvOTMyRmsvZXJxMkJvTTNROXA5dUM1MEd6R1FjbFVGCjNBYmhjekpWQWdNQkFBRUNnZ0VBV2Nnd01NWEMzVnkvZnJKZXhWUklhYkdOaHZkWXU3ZGlCSE5rMWh4R0JHalUKREVseGNUL29mVVpRQ3U1MERVQ2VyWjhObXltWG1KREpnVDRkUVZiUFF3QmVSK3E3OXFoZDhnTTJIUlQ0SjdRUgp6N2pDNEtPdE1RU25oMlJRZTJxdmptT1I4TTRYNWlqY05mYUw5K29rTmV6cHRndFVHVkRVVm5jcUlEaThoWkRiCmk5bkkvc0FJK3dvenhPTUVHYzN1d1FYekNma2RQaEk1VUhBMW8xTWhTaW9BK0ZRL0ZVQnR3VkduNkNvWG9ZTjIKaGFnSHlJN20vWUFsSVFpd3FKbnZZSzZqRTlFSnNNcExFZjFRdUNCTHRhVGZ4RFJjYWwrRjd2YnhlRnFRN3dDTApvUi9aaXlCZ2VHRFNZby9VaUNtSllBQUpBL1BleE5aczBoNHJsUW5SQVFLQmdRRGxMbUJteGJPZWlRMjdDU3BPCnJSaVRUZEE5KzE4b0VWdTJyYlorM0pCVnlTcU1BbzJaUXJ2Rzh6MmtyTlNrNWZpS290UHE1WlZnYmVHWVFTS2MKZWxvaGdrNm5GT1E2cC9CWVI0SldYZDVtWFVUc0RVNTZoenJXbnVUUDIxUGRaVlhWOUxuMVhCa2JjUWZocTcvUwpjQmRaRElmNjZhVi9NS2VKM2VEbElPU2VsUUtCZ1FERWRmTkUrbVZiR1hLWWJWSjhUcDMxRHpJTmJZellRdUhkCkhNTmVnTjhQRHliLzgvbHhpRjBnbjBFdmFJQ0k2cUE5bEc1bUJUZ21RRzdZcWtnSmRoc3lzTW5EUmVwOEpJZW8KcWtXZDJmYlFRdGdPdDEva3lsRkFqZWo4VEVoNkxMZWNuazYxWm5DREtxdE1oNmRWNFE5dWFqeXdlK1FlUnp3MQpJQ00vRE9RVXdRS0JnUURLaTNJblloS2N5Z09ZaVVFYXgyQXd6MVI3Y3UxbU8vRVNRZlJIcWlibHFpUXdHUkdMCm9hN1M1YVpWSTJuTFVuT1dFdEczaDYrOHlWL1hiN2xuRWJzV1lsT2cxcFhlUVEzbzkwbjVpbnhEZTZxdDlCU24KdFZ3SzBlTG0wTEFOdXNGaGxpZkM4T0kvbm1XWXpIRjdTaFZZWGZyUGhpNzllY0tYMWNBc3dDVk5BUUtCZ0M5RAp6VVlnRTdocUUrYldEazAzd01yUFlCUlk4ZFNwcXBzK3EwWVdMUlA3YWorVDI4UlRzVXdDNUhUYWFHb0lRSXJ3CkpldEhnQzI3dks5RnNGVU9aQmE2NzUrYU40S3NhekxKM0R2UXo0OWxOWU84M0VZMzRucHNhY3doTWlLcWxYWUoKcEJnQ1VEbE9UNjMyeU94aFhBd05aUkowaS9vNDJ5UlEyZ24yT1AxQkFvR0FHdzdoY1kwYWJ3NmNYaFV5eWxOZAozNjlIT1BycWtWa05WNFc4YmN6L3Vyc2FET3dWUHozckpHQU94TTFueE9YUThHbm9NcFhMSUZ0NkhtUDZrRG5BCmtqQ1AwK2lxRzhKM1NDeU05RXNmekowYzB6R3Jpak9kNjYzUjNseGd1czBGN0dkS3NldXpobEMxb1l1b0RNRFcKN3BNL2FzNmdrQW5FODNPNVZvWlAyVzQ9Ci0tLS0tRU5EIFBSSVZBVEUgS0VZLS0tLS0=";
    public String privateCertBase64 = "LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSUQ4RENDQXRpZ0F3SUJBZ0lVTEZIRnV2VXJ2aTA5a1cxT2JsREd5VXYvM1pNd0RRWUpLb1pJaHZjTkFRRUwKQlFBd1hqRUxNQWtHQTFVRUJoTUNRMDR4RXpBUkJnTlZCQW9UQ2xSbGJuQmhlUzVqYjIweEhUQWJCZ05WQkFzVApGRlJsYm5CaGVTNWpiMjBnUTBFZ1EyVnVkR1Z5TVJzd0dRWURWUVFERXhKVVpXNXdZWGt1WTI5dElGSnZiM1FnClEwRXdIaGNOTWpFeE1URXhNVE0xTURBMFdoY05Nall4TVRFd01UTTFNREEwV2pDQmdURVRNQkVHQTFVRUF3d0sKTVRZeE5EVTFNRGczT0RFYk1Ca0dBMVVFQ2d3UzViNnU1TCtoNVpXRzVvaTM1N083NTd1Zk1TMHdLd1lEVlFRTApEQ1RvaTQvbHQ1N2xvcWpuaExIbnZaSG51NXpucDVIbWlvRG1uSW5wbVpEbGhhemxqN2d4Q3pBSkJnTlZCQVlNCkFrTk9NUkV3RHdZRFZRUUhEQWhUYUdWdVdtaGxiakNDQVNJd0RRWUpLb1pJaHZjTkFRRUJCUUFEZ2dFUEFEQ0MKQVFvQ2dnRUJBSy9oR2NtRVV4QnRFRmtsUk9lVE0yM3I5ZjY4aDRhN0d6dUJjZEljZ3prUlpZczV1NWlHRTl2SAovemExWEpDWlFVL3dhaHJ4eDlYRGRSV2xFUTFpUzZHeGJFMUxMa0NLUXlCNkFXenZmUmZ4N29sUUtQYnZ3TnhGCmRGSEl2Rng5NmlON3ppd3U3WW1aQVlkd2xabjd3ditLdE05NGkwMmZQcHlLMENXYjN1WkVrTWttc052QW0yS0MKSjBYWGRGeEdWYXNEQzRHL0VlbzVoRnFuRnNwS3JTVGRUQ21mUGJ5clhZRUhaWXc4L1R5Sm9acTdoenA3UDJITAphREtXVFFnNCtCNkt3aXhnSnpiRmJSKzZIOXg1bEI0emFUSW5FcndPVU5oQlZ1T1hmRGFGcXBtci8zZllXVDk2CnVyWUdnemREMm4yNExuUWJNWkJ5VlFYY0J1RnpNbFVDQXdFQUFhT0JnVEIvTUFrR0ExVWRFd1FDTUFBd0N3WUQKVlIwUEJBUURBZ1R3TUdVR0ExVWRId1JlTUZ3d1dxQllvRmFHVkdoMGRIQTZMeTlsZG1OaExtbDBjblZ6TG1OdgpiUzVqYmk5d2RXSnNhV012YVhSeWRYTmpjbXcvUTBFOU1VSkVOREl5TUVVMU1FUkNRekEwUWpBMlFVUXpPVGMxCk5EazRORFpETURGRE0wVTRSVUpFTWpBTkJna3Foa2lHOXcwQkFRc0ZBQU9DQVFFQWZCcE9FMVp1SkJ1S0VtWTcKcFZnSXFxZXFGcndHdUJ6R0NqZEpkeGdZU3VQbDk2YmNTMW9iNFg2VVZPNTljQ01VWnFURlc1cFVkNldOaTI3Ugp0VkxWTnR1enFmeFRId1FDNjgrNjd2c3paTXdocFRiRjQ4R2gzbjJWVHQrOStWVTFpblViZ05mVERtOG54R0FWCnI3OGtwWkhzNTM1ajVPaWNuTnhMbWU0QnF6cGc4REJlNm45c1NZTU93Y08vWlFHb2tqbktqRzJvdWtTVkMxeHEKU0kzekFCVGVRSnhYdzNGZ2VuOHNoY2dBRDZ5SnhJZTJ5UHBrOXMyMlZPY1RjUDVGVGhIWVFNS1VJM3ZSdHJRVQorVFJUWUVaTWE4NlF1aWY0bmdJcDRiUEZUYlFVWmh0QzcrOG9XdHdxZ1IvSDNCcW5NM01uQUt2eVV4UkhreXoxCkxYZVNGUT09Ci0tLS0tRU5EIENFUlRJRklDQVRFLS0tLS0=";


    @Test
    public void createOrder() {
        WxPayIntegrationConfig wxPayIntegrationConfig = wxPayProperties();
        WxPayMiniProgram wxPay = new WxPayMiniProgram(wxPayIntegrationConfig);
        WxPayJsApiCreateOrderRequest request = WxPayJsApiCreateOrderRequest.builder()
                .payer(WxPayJsApiCreateOrderRequest.Payer.builder().openId("oD4wR5an-6_RPhxcZYonrws-MTA8").build())
                .amount(WxPayJsApiCreateOrderRequest.Amount.builder().total(1).build())
                .description("test")
                .notifyUrl("https://www.weixin.qq.com/wxpay/pay.php")
                .outTradeNo("12177525012014070332333680123")
//                .detail(WxPayCreateOrderRequest.Detail.builder().costPrice(1).build())
                .build();
//        wxPay.createOrderGeneral(TradeTypeEnum.JSAPI,request);
       WxPayJsApiCreateOrderResponse res =  wxPay.createOrder(request);
       System.out.println(res);
    }

    @Test
    public void preCreateOrder() {
        WxPayIntegrationConfig wxPayIntegrationConfig = wxPayProperties();
        WxPayMiniProgram wxPay = new WxPayMiniProgram(wxPayIntegrationConfig);
        WxPayNativeCreateOrderRequest request = WxPayNativeCreateOrderRequest.builder()
//                .payer(WxPayCreateOrderRequest.Payer.builder().openId("oD4wR5an-6_RPhxcZYonrws-MTA8").build())
                .amount(WxPayJsApiCreateOrderRequest.Amount.builder().total(1).build())
                .description("test")
                .notifyUrl("https://www.weixin.qq.com/wxpay/pay.php")
                .outTradeNo("121775250120140703323336801232")
//                .detail(WxPayCreateOrderRequest.Detail.builder().costPrice(1).build())
                .build();
//        wxPay.createOrderGeneral(TradeTypeEnum.JSAPI,request);
        WxPayNativeCreateOrderResponse res =  wxPay.scanCodePayment(request);
        System.out.println(res);
    }


    @Test
    public void sign(){
        WxPayIntegrationConfig wxPayIntegrationConfig = wxPayProperties();
        WxPayMiniProgram wxPay = new WxPayMiniProgram(wxPayIntegrationConfig);
        String result =  wxPay.signatureGeneral("sss");
        System.out.println(result);
    }


    public WxPayIntegrationConfig wxPayProperties(){
        return WxPayIntegrationConfig.builder()
                .apiV3Key("49fB0Ls812b0K0Q0JKYmt2sTIWwTY1Gv")
                .appId("wx78791bd73b35a329")
                .mchId("1614550878")
                .privateKeyContent(Base64.decodeBase64(privateKeyBase64))
                .privateCertContent(Base64.decodeBase64(privateCertBase64))
//                .privateKeyPath("/Users/fengxiaotx/Downloads/1614550878_20210928_cert/apiclient_key.pem")
//                .privateKeyPath("classpath:/ssl/apiclient_key.pem")
//                .privateCertPath("/Users/fengxiaotx/Downloads/1614550878_20210928_cert/apiclient_cert.pem")
                .build();
    }
}
