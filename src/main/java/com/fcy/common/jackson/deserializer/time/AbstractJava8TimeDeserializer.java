package com.fcy.common.jackson.deserializer.time;

import com.fcy.common.jackson.ability.DateTimePatternModifiable;
import com.fcy.common.jackson.deserializer.Deserializer;
import com.fcy.common.jackson.deserializer.StandardDeserializer;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * @author fcy
 * @date 2020/7/21
 */
@NoArgsConstructor
public abstract class AbstractJava8TimeDeserializer<T> extends StandardDeserializer<T>
    implements DateTimePatternModifiable {
    public AbstractJava8TimeDeserializer(Deserializer<String, T> deserializer) {
        super(deserializer);
    }


    @Override
    public void setTimePattern(String pattern) {
        deserializer = buildDeserializer(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将{@link DateTimeFormatter}转为反序列化器的方法
     *
     * @param formatter 时间格式化器
     * @return 反序列化器
     */
    protected abstract Deserializer<String, T> buildDeserializer(DateTimeFormatter formatter);
}
