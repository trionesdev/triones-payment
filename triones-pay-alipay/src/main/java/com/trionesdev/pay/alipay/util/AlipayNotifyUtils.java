package com.trionesdev.pay.alipay.util;

import com.google.common.collect.Maps;
import com.trionesdev.pay.alipay.model.AlipayNotify;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class AlipayNotifyUtils {
    public static Map<String,String> parameters(Map<String,String[]> parameterMap){
        Map<String,String> params = Maps.newHashMap();
        if(MapUtils.isEmpty(parameterMap)){
            return params;
        }
        parameterMap.forEach((k,v)->{
            if(ArrayUtils.isNotEmpty(v)){
                params.put(k, StringUtils.join(v,","));
            }
        });
        return params;
    }

    public static AlipayNotify fromMap(Map<String,String> params){
        return AlipayNotify.builder()
                .tradeNo(params.get("trade_no"))
                .outTradeNo(params.get("out_trade_no"))
                .build();
    }

}
