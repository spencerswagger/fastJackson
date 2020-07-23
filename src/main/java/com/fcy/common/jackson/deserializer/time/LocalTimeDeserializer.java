package com.fcy.common.jackson.deserializer.time;

import com.fcy.common.jackson.constant.FormatterConstant;
import com.fcy.common.jackson.deserializer.StandardDeserializer;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author fcy
 * @date 2020/7/21
 */
public class LocalTimeDeserializer extends StandardDeserializer<LocalTime> {

    public LocalTimeDeserializer() {
        this(FormatterConstant.LOCAL_TIME);
    }

    public LocalTimeDeserializer(DateTimeFormatter formatter) {
        super(value -> LocalTime.parse(value, formatter));
    }
}
