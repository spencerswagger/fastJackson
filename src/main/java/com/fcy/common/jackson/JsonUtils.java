package com.fcy.common.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fcy.common.jackson.deserializer.Deserializer;
import com.fcy.common.jackson.deserializer.StandardDeserializer;
import com.fcy.common.jackson.feature.Feature;
import com.fcy.common.jackson.serializer.Serializer;
import com.fcy.common.jackson.serializer.StandardSerializer;

/**
 * @author fcy
 * @date 2020/7/21
 */
public class JsonUtils {
    /**
     * 默认{@link ObjectMapper}单例
     */
    public static JsonObjectMapper mapper = new JsonObjectMapper();

    public static <T> StandardSerializer<T> buildSerializer(Serializer<T, String> serializer) {
        return new StandardSerializer<>(serializer);
    }

    public static <R> StandardDeserializer<R> buildDeserializer(Deserializer<String, R> deserializer) {
        return new StandardDeserializer<>(deserializer);
    }

    /**
     * 新建一个默认{@link ObjectMapper}实例
     *
     * @return {@link ObjectMapper}对象
     */
    public static JsonObjectMapper buildMapper() {
        return new JsonObjectMapper();
    }

    /**
     * 根据传入的{@link Feature}配置{@link ObjectMapper}
     * 当没有{@link Feature}时，将使用默认实例，否则新建一个实例
     *
     * @param features 需要的功能
     * @return 配置完后的{@link ObjectMapper}
     */
    public static JsonObjectMapper getFeaturedMapper(Feature... features) {
        JsonObjectMapper objectMapper = mapper;
        if (features != null && features.length > 0) {
            //当有Feature时重新创建一个实例
            objectMapper = buildMapper();

            for (Feature feature : features) {
                feature.modify(objectMapper);
            }

            //注册自定义模组(包含Feature中的(反)序列化器)
            objectMapper.registerModule(objectMapper.getCustomModule());
        }
        return objectMapper;
    }
}
