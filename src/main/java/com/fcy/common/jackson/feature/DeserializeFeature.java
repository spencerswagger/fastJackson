package com.fcy.common.jackson.feature;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fcy.common.jackson.JsonObjectMapper;
import com.fcy.common.jackson.deserializer.Deserializer;

import java.util.function.BiFunction;

/**
 * @author fcy
 * @date 2020/7/21
 */
public interface DeserializeFeature<T> extends Feature {
    /**
     * 生成一个反序列化特性
     *
     * @param type         序列化处理类型
     * @param deserializer 反序列化器
     * @return 反序列化特性
     */
    static <T> DeserializeFeature<T> of(Class<T> type, Deserializer<String, T> deserializer) {
        return new SimpleDeserializeFeature<T>(type, deserializer);
    }

    static <T> DeserializeFeature<T> of(Class<T> type, BiFunction<String, Class<? extends T>, T> deserializer) {
        return new SimpleDeserializeFeature<T>(type, deserializer);
    }

    /**
     * 将反序列化器加入到自定义模组
     *
     * @param objectMapper objectMapper对象
     */
    @Override
    default void modify(JsonObjectMapper objectMapper) {
        objectMapper
            .getCustomModule()
            .addDeserializer(getType(), getDeserializer());
    }

    /**
     * 获取反序列化器
     *
     * @return 反序列化器实例
     */
    JsonDeserializer<T> getDeserializer();

    /**
     * 获取反序列化器使用类型
     *
     * @return 类型
     */
    Class<T> getType();
}
