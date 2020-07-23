package com.fcy.common.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fcy.common.jackson.JsonProcessException;
import com.fcy.common.jackson.Utils;
import lombok.AllArgsConstructor;

import java.io.IOException;

/**
 * @author fcy
 * @date 2020/7/21
 */
@AllArgsConstructor
public class StandardSerializer<T> extends JsonSerializer<T> implements Serializer<T, String> {
    protected Class<T> handleType;
    protected Serializer<T, String> serializer;

    public StandardSerializer(Serializer<T, String> serializer) {
        this.serializer = serializer;
    }

    @Override
    public void serialize(T value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value != null) {
            gen.writeString(serialize(value));
        }
    }

    @Override
    public String serialize(T value) throws RuntimeException, IOException {
        return serializer.serialize(value);
    }

    @Override
    public Class<T> handledType() {
        Class<T> type = handleType != null ? handleType : Utils.getRowType(this.getClass());
        if (type == null) {
            throw new JsonProcessException("unknown handled type of " + this
                .getClass()
                .getSimpleName());
        }
        return type;
    }
}
