package com.trionesdev.pay.alipay.request;

import com.alipay.api.domain.AlipayTradePrecreateModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AlipayTradePreCreateEasyRequest extends AlipayBaseEasyRequest {
    private AlipayTradePrecreateModel bizModel;
}
