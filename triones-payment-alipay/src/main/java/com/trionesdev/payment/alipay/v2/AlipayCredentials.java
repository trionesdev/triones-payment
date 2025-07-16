package com.trionesdev.payment.alipay.v2;

import com.alipay.api.AlipayConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AlipayCredentials extends AlipayConfig {
    private String notifyUrl;
}
