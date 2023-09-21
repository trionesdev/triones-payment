package com.moensun.pay.wxpay.v3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@Data
@Accessors(chain = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Amount {
    /**
     * 总金额
     */
    private Integer total;
    /**
     * 货币类型
     */
    private String currency;
}
