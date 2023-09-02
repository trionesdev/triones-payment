package com.moensun.pay.wxpay.v3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Amount {
    private Integer total;
    private String currency;

    public com.wechat.pay.java.service.payments.h5.model.Amount toH5Amount(){
        com.wechat.pay.java.service.payments.h5.model.Amount h5Amount = new com.wechat.pay.java.service.payments.h5.model.Amount();
        h5Amount.setTotal(this.getTotal());
        h5Amount.setCurrency(this.getCurrency());
        return h5Amount;
    }
}
