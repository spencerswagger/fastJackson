package com.fcy.common.jackson.deserializer.time;

import com.fcy.common.jackson.constant.FormatterConstant;
import com.fcy.common.jackson.deserializer.StandardDeserializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author fcy
 * @date 2020/7/21
 */
public class LocalDateTimeDeserializer extends StandardDeserializer<LocalDateTime> {

    public LocalDateTimeDeserializer() {
        this(FormatterConstant.LOCAL_DATE_TIME);
    }

    public LocalDateTimeDeserializer(DateTimeFormatter formatter) {
        super(value -> LocalDateTime.parse(value, formatter));
    }
}
