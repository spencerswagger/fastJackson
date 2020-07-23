package com.fcy.common.jackson.feature;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fcy.common.jackson.JsonObjectMapper;
import com.fcy.common.jackson.serializer.Serializer;
import com.fcy.common.jackson.serializer.StandardSerializer;

/**
 * @author fcy
 * @date 2020/7/21
 */
public interface SerializeFeature<T> extends Feature {
    /**
     * 生成一个序列化特性
     *
     * @param type       序列化处理类型
     * @param serializer 序列化器
     * @return 序列化特性
     */
    static <T> SerializeFeature<T> of(Class<T> type, Serializer<T, String> serializer) {
        return new SimpleSerializeFeature<T>(type,serializer);
    }

    /**
     * 将序列化器添加到自定义模组中
     *
     * @param objectMapper objectMapper对象
     */
    @Override
    default void modify(JsonObjectMapper objectMapper) {
        objectMapper
            .getCustomModule()
            .addSerializer(getType(), getSerializer());
    }

    /**
     * 获取序列化器
     *
     * @return 序列化器实例
     */
    JsonSerializer<T> getSerializer();

    /**
     * 获取序列化器使用类型
     *
     * @return 类型
     */
    default Class<T> getType() {
        return getSerializer().handledType();
    }
}
