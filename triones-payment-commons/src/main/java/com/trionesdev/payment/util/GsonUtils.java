package com.trionesdev.payment.util;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

public class GsonUtils {
    private static final Gson gson;

    static {
        gson =
                new GsonBuilder()
                        .disableHtmlEscaping()
                        .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                        .addSerializationExclusionStrategy(
                                new ExclusionStrategy() {
                                    @Override
                                    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                                        final Expose expose = fieldAttributes.getAnnotation(Expose.class);
                                        return expose != null && !expose.serialize();
                                    }

                                    @Override
                                    public boolean shouldSkipClass(Class<?> aClass) {
                                        return false;
                                    }
                                })
                        .addDeserializationExclusionStrategy(
                                new ExclusionStrategy() {
                                    @Override
                                    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                                        final Expose expose = fieldAttributes.getAnnotation(Expose.class);
                                        return expose != null && !expose.deserialize();
                                    }

                                    @Override
                                    public boolean shouldSkipClass(Class<?> aClass) {
                                        return false;
                                    }
                                })
                        .create();
    }

    /**
     * 获取自定义设置的Gson对象
     *
     * @return Gson对象
     */
    public static Gson getGson() {
        return gson;
    }

    /**
     * 转换对象为JSON格式字符串
     *
     * @param object 待转换对象
     * @return JSON格式字符串
     */
    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    public static Map<String, Object> toMap(String json) {
        return gson.fromJson(json, new TypeToken<Map<String, Object>>() {
        }.getType());
    }

}
