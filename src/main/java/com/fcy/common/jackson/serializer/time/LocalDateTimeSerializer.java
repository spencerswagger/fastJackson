package com.fcy.common.jackson.serializer.time;

import com.fcy.common.jackson.constant.FormatterConstant;
import com.fcy.common.jackson.serializer.StandardSerializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author fcy
 * @date 2020/7/21
 */
public class LocalDateTimeSerializer extends StandardSerializer<LocalDateTime> {

    public LocalDateTimeSerializer() {
        this(FormatterConstant.LOCAL_DATE_TIME);
    }

    public LocalDateTimeSerializer(DateTimeFormatter formatter) {
        super(formatter::format);
    }

}
