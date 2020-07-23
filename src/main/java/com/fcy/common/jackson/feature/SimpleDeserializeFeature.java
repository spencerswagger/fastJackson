package com.fcy.common.jackson.feature;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fcy.common.jackson.deserializer.Deserializer;
import com.fcy.common.jackson.deserializer.StandardDeserializer;
import com.fcy.common.jackson.deserializer.TypedDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.BiFunction;

/**
 * @author fcy
 * @date 2020/7/21
 */
@AllArgsConstructor
public class SimpleDeserializeFeature<T> implements DeserializeFeature<T> {
    @Getter protected JsonDeserializer<T> deserializer;
    @Getter protected Class<T> type;

    public SimpleDeserializeFeature(Class<T> type, Deserializer<String, T> deserializer) {
        this(new StandardDeserializer<>(deserializer), type);
    }

    public SimpleDeserializeFeature(Class<T> type, BiFunction<String, Class<? extends T>, T> deserializer) {
        this(new TypedDeserializer<>(deserializer), type);
    }
}
