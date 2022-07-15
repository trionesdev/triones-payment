package com.moensun.pay.wxpay;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
import com.wechat.pay.contrib.apache.httpclient.auth.AutoUpdateCertificatesVerifier;
import com.wechat.pay.contrib.apache.httpclient.auth.PrivateKeySigner;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Credentials;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Validator;
import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class WxPayTest {


//    @Test
//    public void wx() throws UnknownHostException {
//        WxPayConfig payConfig = new WxPayConfig();
//        payConfig.setAppId("wx78791bd73b35a329");
//        payConfig.setMchId("1614550878");
//        payConfig.setMchKey("Z3cRUcvQHjwEYyU8Yv6VQ2XmdXFabvyc");
//        payConfig.setNotifyUrl("https://www.baidu.com/");
//        payConfig.setKeyPath("/Users/baneshi/Downloads/1614550878_20210928_cert/apiclient_cert.p12");
//
//        WxPayService wxPayService = new WxPayServiceImpl();
//        wxPayService.setConfig(payConfig);
//
//        WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
//        orderRequest.setOpenid("oD4wR5an-6_RPhxcZYonrws-MTA8");
//        orderRequest.setBody("主题");
//        orderRequest.setOutTradeNo("20210928100000111");
//        orderRequest.setTradeType("JSAPI");
//        InetAddress ip4 = Inet4Address.getLocalHost();
//        orderRequest.setSpbillCreateIp(ip4.getHostAddress());
//        orderRequest.setTotalFee(1);
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
//        orderRequest.setTimeStart(dateTimeFormatter.format(now));
//        orderRequest.setTimeExpire(dateTimeFormatter.format(now.plus(5, ChronoUnit.MINUTES)));
//        try {
//            WxPayMpOrderResult res = wxPayService.createOrder(orderRequest);
//        } catch (WxPayException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void wxV3() throws UnknownHostException {
//        WxPayConfig payConfig = new WxPayConfig();
//        payConfig.setAppId("wx78791bd73b35a329");
//        payConfig.setMchId("1614550878");
//        payConfig.setMchKey("Z3cRUcvQHjwEYyU8Yv6VQ2XmdXFabvyc");
//        payConfig.setApiV3Key("49fB0Ls812b0K0Q0JKYmt2sTIWwTY1Gv");
//        payConfig.setNotifyUrl("https://www.baidu.com/");
//        payConfig.setPrivateKeyPath("/Users/fengxiaotx/Downloads/1614550878_20210928_cert/apiclient_key.pem");
//        payConfig.setPrivateCertPath("/Users/fengxiaotx/Downloads/1614550878_20210928_cert/apiclient_cert.pem");
//        payConfig.setKeyPath("/Users/fengxiaotx/Downloads/1614550878_20210928_cert/apiclient_cert.p12");
//
//        WxPayService wxPayService = new WxPayServiceImpl();
//        wxPayService.setConfig(payConfig);
//
//        WxPayUnifiedOrderV3Request v3Request = new WxPayUnifiedOrderV3Request();
//        v3Request.setDescription("测试订单");
//        v3Request.setPayer(new WxPayUnifiedOrderV3Request.Payer().setOpenid("oD4wR5an-6_RPhxcZYonrws-MTA8"));
//        v3Request.setOutTradeNo("2021092810000011101");
//        v3Request.setAmount(new WxPayUnifiedOrderV3Request.Amount().setTotal(1).setCurrency("CNY"));
//        LocalDateTime now3 = LocalDateTime.now();
////        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
////        v3Request.se(dateTimeFormatter3.format(now3));
//        v3Request.setTimeExpire(now3.plus(5, ChronoUnit.MINUTES).toInstant(ZoneOffset.UTC).toString());
//        v3Request.setNotifyUrl("https://www.baidu.com/");
//        try {
//            wxPayService.createOrderV3(TradeTypeEnum.JSAPI,v3Request);
//        } catch (WxPayException e) {
//            e.printStackTrace();
//        }
//    }



    @Test
    public void pay() throws IOException {
        String appId ="wx78791bd73b35a329";
        String merchantId = "1614550878";
        String apiV3Key = "49fB0Ls812b0K0Q0JKYmt2sTIWwTY1Gv";
        String openId = "oD4wR5an-6_RPhxcZYonrws-MTA8";



        PrivateKey merchantPrivateKey = PemUtil.loadPrivateKey(
                new FileInputStream("/Users/fengxiaotx/Downloads/1614550878_20210928_cert/apiclient_key.pem"));
        X509Certificate certificate = PemUtil.loadCertificate(new FileInputStream("/Users/fengxiaotx/Downloads/1614550878_20210928_cert/apiclient_cert.pem"));
        String merchantSerialNumber = certificate.getSerialNumber().toString(16).toUpperCase();

        AutoUpdateCertificatesVerifier verifier = new AutoUpdateCertificatesVerifier(
                new WechatPay2Credentials(merchantId, new PrivateKeySigner(merchantSerialNumber, merchantPrivateKey)),
                apiV3Key.getBytes("utf-8"));



        WechatPayHttpClientBuilder builder = WechatPayHttpClientBuilder.create()
                .withMerchant(merchantId, merchantSerialNumber, merchantPrivateKey)
                .withValidator(new WechatPay2Validator(verifier));

        CloseableHttpClient httpClient = builder.build();


        HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/v3/pay/transactions/jsapi");
        httpPost.addHeader("Accept", "application/json");
        httpPost.addHeader("Content-type","application/json; charset=utf-8");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();

        ObjectNode rootNode = objectMapper.createObjectNode();
        rootNode.put("mchid",merchantId)
                .put("appid", appId)
                .put("description", "Image形象店-深圳腾大-QQ公仔")
                .put("notify_url", "https://www.weixin.qq.com/wxpay/pay.php")
                .put("out_trade_no", "1217752501201407033233368018");
        rootNode.putObject("amount")
                .put("total", 1);
        rootNode.putObject("payer")
                .put("openid", openId);

        objectMapper.writeValue(bos, rootNode);

        httpPost.setEntity(new StringEntity(bos.toString("UTF-8"), "UTF-8"));
        CloseableHttpResponse response = httpClient.execute(httpPost);

        String bodyAsString = EntityUtils.toString(response.getEntity());
        System.out.println(bodyAsString);

    }


    public void ss(){
//        URIBuilder uriBuilder = new URIBuilder("https://api.mch.weixin.qq.com/v3/certificates");
//        HttpGet httpGet = new HttpGet(uriBuilder.build());
//        httpGet.addHeader("Accept", "application/json");
//
//        CloseableHttpResponse response = httpClient.execute(httpGet);
//
//        String bodyAsString = EntityUtils.toString(response.getEntity());
//        System.out.println(bodyAsString);
    }

    @Test
    public void test(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.toString());
        System.out.println(localDateTime.toInstant(ZoneOffset.UTC));
    }


    @Test
    public void test2(){
        System.out.println(StringUtils.replace("classpath:/aa","classpath\\*?:",""));
        System.out.println("classpath:/aa".replaceFirst("classpath\\*?:\\/?",""));
    }
}
