# TrionesDev - 支付SDK
> 对支付通道进行SDK分装
---

## 支持渠道
[微信支付](triones-payment-wechatpay)

[支付宝](triones-payment-alipay)

## 使用
#### 添加依赖管理
```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.trionesdev.payment</groupId>
            <artifactId>triones-payment-dependencies</artifactId>
            <version>版本号</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```
### 使用微信支付
添加依赖
```xml
<dependency>
    <groupId>com.trionesdev.payment</groupId>
    <artifactId>triones-payment-wechatpay</artifactId>
    <version>版本号</version>
</dependency>
```

---
### 关注我们，一起交流
> 留言回复不及时，可以通过关注公众号联系我们
<div style="text-align: center">
<img src="images/shuque_wx.jpg" width="200px" alt="">
</div>