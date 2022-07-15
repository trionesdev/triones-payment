package com.moensun.pay.wxpay.v3.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.moensun.pay.util.JsonUtils;
import com.moensun.pay.wxpay.v3.model.WxPayNotify;

import java.util.Map;

public class WxPayNotifyUtils {

    public static WxPayNotify fromMap(Map<String,Object> body) throws JsonProcessingException {
        return fromJson(JsonUtils.writeValueAsString(body));
    }

    public static WxPayNotify fromJson(String jsonString) throws JsonProcessingException {
       return JsonUtils.readValue(jsonString,WxPayNotify.class);
    }

}
