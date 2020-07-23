package com.fcy.common.jackson.feature;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fcy.common.jackson.JsonObjectMapper;

/**
 * @author fcy
 * @date 2020/7/20
 */
public interface Feature {
    /**
     * 兼容原{@link SerializationFeature}
     *
     * @param feature  {@link SerializationFeature}
     * @param isEnable 是否启用
     * @return {@link Feature}
     */
    static Feature of(SerializationFeature feature, boolean isEnable) {
        return mapper -> mapper.configure(feature, isEnable);
    }

    /**
     * 兼容原{@link DeserializationFeature}
     *
     * @param feature  {@link DeserializationFeature}
     * @param isEnable 是否启用
     * @return {@link Feature}
     */
    static Feature of(DeserializationFeature feature, boolean isEnable) {
        return mapper -> mapper.configure(feature, isEnable);
    }

    /**
     * 兼容原{@link MapperFeature}
     *
     * @param feature  {@link MapperFeature}
     * @param isEnable 是否启用
     * @return {@link Feature}
     */
    static Feature of(MapperFeature feature, boolean isEnable) {
        return mapper -> mapper.configure(feature, isEnable);
    }

    /**
     * 兼容原{@link JsonParser.Feature}
     *
     * @param feature  {@link JsonParser.Feature}
     * @param isEnable 是否启用
     * @return {@link Feature}
     */
    static Feature of(JsonParser.Feature feature, boolean isEnable) {
        return mapper -> mapper.configure(feature, isEnable);
    }

    /**
     * 兼容原{@link JsonGenerator.Feature}
     *
     * @param feature  {@link JsonGenerator.Feature}
     * @param isEnable 是否启用
     * @return {@link Feature}
     */
    static Feature of(JsonGenerator.Feature feature, boolean isEnable) {
        return mapper -> mapper.configure(feature, isEnable);
    }

    /**
     * 通过配置{@code ObjectMapper}实现功能
     *
     * @param objectMapper objectMapper对象
     */
    void modify(JsonObjectMapper objectMapper);
}
