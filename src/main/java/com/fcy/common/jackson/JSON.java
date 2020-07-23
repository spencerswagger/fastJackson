package com.fcy.common.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fcy.common.jackson.feature.Feature;
import lombok.NonNull;

/**
 * @author fcy
 * @date 2020/7/20
 */
public abstract class JSON {

    /**
     * 使用指定的{@link ObjectMapper}将JSON字符串转为对象
     *
     * @param tClass   目标类型
     * @param json     JSON字符串
     * @param features 特性
     * @param <T>      目标类型
     * @return 目标类型的实例
     */
    public static <T> T parse(String json, Class<T> tClass, Feature... features) {
        return parse(json, tClass, JsonUtils.getFeaturedMapper(features));
    }

    /**
     * 使用指定的{@link ObjectMapper}将JSON字符串转为对象
     *
     * @param tClass 目标类型
     * @param json   JSON字符串
     * @param mapper {@link ObjectMapper}对象
     * @param <T>    目标类型
     * @return 目标类型的实例
     */
    public static <T> T parse(String json, @NonNull Class<T> tClass, @NonNull ObjectMapper mapper) {
        try {
            return mapper.readValue(json, tClass);
        } catch (JsonProcessingException e) {
            throw new JsonProcessException("parse json string to object error", e);
        }
    }

    public static <T> T parse(String json, @NonNull TypeReference<T> valueTypeRef, @NonNull ObjectMapper mapper) {
        try {
            return mapper.readValue(json, valueTypeRef);
        } catch (JsonProcessingException e) {
            throw new JsonProcessException("parse json string to object error", e);
        }
    }
    /**
     * 使用具有指定{@link Feature}特性的{@link ObjectMapper}将对象转为JSON字符串
     *
     * @param obj      待序列化对象
     * @param features 特性
     * @return JSON字符串
     */
    public static String toString(Object obj, Feature... features) {
        return toString(obj, JsonUtils.getFeaturedMapper(features));
    }

    /**
     * 使用指定的{@link ObjectMapper}将对象转为JSON字符串
     *
     * @param obj    待序列化对象
     * @param mapper {@link ObjectMapper}对象
     * @return JSON字符串
     */
    public static String toString(@NonNull Object obj, @NonNull ObjectMapper mapper) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new JsonProcessException("format object to json string error", e);
        }
    }

}
