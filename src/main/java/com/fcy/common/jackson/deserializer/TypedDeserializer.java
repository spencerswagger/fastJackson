package com.fcy.common.jackson.deserializer;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;

import java.util.function.BiFunction;

/**
 * @author fcy
 * @date 2020/7/21
 */
public class TypedDeserializer<R> extends StandardDeserializer<R> implements ContextualDeserializer {

    protected Class<? extends R> type;

    public TypedDeserializer(BiFunction<String, Class<? extends R>, R> deserializer) {
        this.deserializer = value -> deserializer.apply(value, type);
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext context, BeanProperty property) {
        this.type = (Class<? extends R>)(context.getContextualType() != null ?
            context
                .getContextualType()
                .getRawClass() :
            property
                .getType()
                .getRawClass());
        return this;
    }
}
