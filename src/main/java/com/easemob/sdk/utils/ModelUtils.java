package com.easemob.sdk.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.easemob.sdk.dto.KeyValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Model工具类
 *
 * @author vimin
 * @version 1.0
 * @since 2021-08-14
 */
public class ModelUtils {
    /**
     * 将键值对转为HashMap
     *
     * @param keyValues 键值对
     * @return
     */
    public static Map<String, Object> buildMap(KeyValue[] keyValues) {
        if (keyValues == null || keyValues.length == 0) {
            return new HashMap<>();
        }
        Map<String, Object> result = new HashMap<>(keyValues.length);
        for (KeyValue keyValue : keyValues) {
            result.put(keyValue.getKey(), keyValue.getValue());
        }
        return result;
    }

    /**
     * 将键值对构建为HashMap
     *
     * @param keyValues 要构建的键值对
     * @return
     */
    public static Map<String, String> buildStrMap(KeyValue[] keyValues) {
        if (keyValues == null || keyValues.length == 0) {
            return new HashMap<>();
        }
        Map<String, String> result = new HashMap<>(keyValues.length);
        for (KeyValue keyValue : keyValues) {
            result.put(keyValue.getKey(), String.valueOf(keyValue.getValue()));
        }
        return result;
    }

    /**
     * 将字符串转为对象类型
     *
     * @param body
     * @param typeReference
     * @param <T>
     * @return
     */
    public static <T> T buildModel(String body, TypeReference<T> typeReference) {
        return JSONObject.parseObject(body, typeReference);
    }

}
