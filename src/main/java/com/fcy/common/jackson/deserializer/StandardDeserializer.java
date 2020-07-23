package com.fcy.common.jackson.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.IOException;

/**
 * @author fcy
 * @date 2020/7/21
 */
@AllArgsConstructor
@NoArgsConstructor
public class StandardDeserializer<R> extends JsonDeserializer<R>
    implements Deserializer<String, R> {

    protected Deserializer<String, R> deserializer;

    @Override
    public R deserialize(JsonParser p, DeserializationContext context) throws IOException {
        return deserialize(p.getValueAsString());
    }

    @Override
    public R deserialize(String value) throws RuntimeException, IOException {
        return deserializer.deserialize(value);
    }
}
