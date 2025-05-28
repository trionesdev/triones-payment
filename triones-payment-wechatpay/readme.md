# 微信支付
## 添加依赖
```xml
<dependency>
    <groupId>com.trionesdev.payment</groupId>
    <artifactId>triones-payment-wechatpay</artifactId>
    <version>版本号</version>
</dependency>
```
## 说明
在微信支付的对象中，有两个子属性，分别是payment和operation，
- payment 支付相关
- operation 运营相关

### payment 支付
我们在使用的时候，先创建 `com.trionesdev.payment.wechatpay.v3.WechatPay` 这个对象，再从中获取`payment`属性，
`com.trionesdev.payment.wechatpay.v3.payment.WechatPayPayment` 中包含了 h5,jsapi,native,app 对象，在业务中调用对应的方法即可。

#### 公共方法（所有支付方式都有）

微信支付订单号查询订单 `queryOrderById`

商户订单号查询订单 `queryOrderByOutTradeNo`

关闭订单 `closeOrder`

交易成功回调内容解析 `transactionNotify`

申请退款 `createRefund`

查询单笔退款（通过商户退款单号） `queryRefundByOutRefundNo`

退款成功回调解析 `refundNotify`

#### h5支付(独有)
[代码路径](triones-payment-wechatpay/src/main/java/com/trionesdev/payment/wechatpay/v3/payment/h5/WechatPayH5.java)

方法说明

创建H5支付订单 `createOrder`


#### jsapi支付(独有)

[代码路径](triones-payment-wechatpay/src/main/java/com/trionesdev/payment/wechatpay/v3/payment/jsapi/WechatPayJsApi.java)

方法说明

创建JSAPI支付订单 `createOrder`

创建JSAPI支付订单并返回调用参数 `createOrderWithRequestPayment`

#### native支付(独有)
[代码路径](triones-payment-wechatpay/src/main/java/com/trionesdev/payment/wechatpay/v3/payment/nativepay/WechatPayNative.java)

方法说明

创建Native支付订单 `createOrder`

#### App(独有)
[代码路径](triones-payment-wechatpay/src/main/java/com/trionesdev/payment/wechatpay/v3/payment/app/WechatPayApp.java)

方法说明

创建App支付订单 `createOrder`

创建App支付订单并返回调用参数 `createOrderWithRequestPayment`


## 使用范例
```java
public class WxPayTest {

    String privateKeyBase64 = ""; //私钥key的内容转base64
    String privateCertBase64 = ""; //私钥证书内容转base64

    public WechatPay getWxPay() {
        WechatPayConfig config = WechatPayConfig.builder()
                .appId("")
                .mchId("")
                .privateKey(new String(Base64.getDecoder().decode(privateKeyBase64)))
                .privateCert(new String(Base64.getDecoder().decode(privateCertBase64)))
                .apiV3Key("")
                .transactionNotifyUrl("")
                .build();
        return new WechatPay(config);
    }

    @Test
    public void miniprogram_test() {
        WechatPay wxPay = getWxPay();
    }

    @Test
    public void native_test() {
        WechatPay wxPay = getWxPay();
        WechatPayNativeCreateOrderRequest request = WechatPayNativeCreateOrderRequest.builder()
                .outTradeNo(RandomStringUtils.randomAlphabetic(32))
                .amount(Amount.builder().total(1).build())
                .description("Native支付测试")
                .build();
        WechatPayNativeCreateOrderResponse response = wxPay.getPayment().getNative().createOrder(request);
        System.out.println(response);
    }

    @Test
    public void jsapi_test() {
        WechatPay wxPay = getWxPay();
        WechatPayJsApiCreateOrderRequest request = WechatPayJsApiCreateOrderRequest.builder()
                .appId(" ")
                .mchId(" ")
                .outTradeNo(RandomStringUtils.randomAlphabetic(32))
                .amount(Amount.builder().total(1).build())
                .description("JSAPI支付测试")
                .notifyUrl(" ")
                .payer(Payer.builder().openId("").build())
                .build();
        WechatPayJsApiCreateOrderResponse response = wxPay.getPayment().getJsApi().createOrder(request);
        System.out.println(response);
    }


}
```
