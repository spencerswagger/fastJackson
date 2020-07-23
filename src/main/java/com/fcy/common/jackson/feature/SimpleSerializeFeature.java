package com.fcy.common.jackson.feature;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fcy.common.jackson.serializer.Serializer;
import com.fcy.common.jackson.serializer.StandardSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author fcy
 * @date 2020/7/21
 */
@AllArgsConstructor
public class SimpleSerializeFeature<T> implements SerializeFeature<T> {
    @Getter protected JsonSerializer<T> serializer;
    @Getter protected Class<T> type;

    public SimpleSerializeFeature(Class<T> type, Serializer<T, String> serializer) {
        this(new StandardSerializer<>(serializer), type);
    }
}
