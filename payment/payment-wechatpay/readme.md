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

## 使用

### 创建 `WechatPay` 对象

#### WechatPayConfig 属性说明

| 属性                    | 说明                                       | 是否必填 | 默认值 |
|-----------------------|------------------------------------------|------|-----|
| appId                 | 微信公众号/小程序的appId                          |      |     |
| mchId                 | 商户号                                      |      |     |
| apiV3Key              | V3接口的Key                                 | 是    |     |
| merchantSerialNo      | 商户序列号，如不填，可根据证书生成                        | 否    |     |
| privateKey            | 私钥(与privateKeyPath取一)                    | 否    |     |
| privateCert           | 证书   (与privateCertPath取一)                | 否    |     |
| privateKeyPath        | 私钥路径，以classpath:开头或绝对路径 (与privateKey取一)  | 否    |     |
| privateCertPath       | 证书路径，以classpath:开头或绝对路径 (与privateCert取一) | 否    |     |
| transactionNotifyUrl  | 交易回调地址，可以在请求参数中传递                        | 否    |     |
| refundNotifyUrl       | 退款回调地址，可以在请求参数中传递                        | 否    |     |
| transactionNotifyUrls | 退款回调地址MAP，用于根据Key获取                      | 否    |     |
| refundNotifyUrls      | 退款回调地址MAP，用于根据Key获取                      | 否    |     |
| credentials           |                                          | 否    |     |

```java
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
```

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

[代码路径](src/main/java/com/trionesdev/payment/wechatpay/v3/payment/h5/WechatPayH5.java)

方法说明

创建H5支付订单 `createOrder`

#### jsapi支付(独有)

[代码路径](src/main/java/com/trionesdev/payment/wechatpay/v3/payment/jsapi/WechatPayJsApi.java)

方法说明

创建JSAPI支付订单 `createOrder`

创建JSAPI支付订单并返回调用参数 `createOrderWithRequestPayment`

#### native支付(独有)

[代码路径](src/main/java/com/trionesdev/payment/wechatpay/v3/payment/nativepay/WechatPayNative.java)

方法说明

创建Native支付订单 `createOrder`

#### App(独有)

[代码路径](src/main/java/com/trionesdev/payment/wechatpay/v3/payment/app/WechatPayApp.java)

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

---

### 关注我们，一起交流

> 留言回复不及时，可以通过关注公众号联系我们
<div style="text-align: center">
<img src="../images/shuque_wx.jpg" width="200px" alt="">
</div>