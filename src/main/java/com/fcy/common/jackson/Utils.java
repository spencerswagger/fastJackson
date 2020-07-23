package com.fcy.common.jackson;

import com.fcy.common.jackson.feature.DeserializeFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.val;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author fcy
 * @date 2020/7/21
 */
public class Utils {
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getRowType(Class<?> clazz) {
        try {
            Type superClass = clazz.getGenericSuperclass();
            val type = ((ParameterizedType)superClass).getActualTypeArguments()[0];
            if (type instanceof ParameterizedType) {
                return (Class<T>)((ParameterizedType)type).getRawType();
            } else {
                return (Class<T>)type;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
