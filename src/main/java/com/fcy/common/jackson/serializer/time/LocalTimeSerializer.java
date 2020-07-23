package com.fcy.common.jackson.serializer.time;

import com.fcy.common.jackson.constant.FormatterConstant;
import com.fcy.common.jackson.serializer.StandardSerializer;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author fcy
 * @date 2020/7/21
 */
public class LocalTimeSerializer extends StandardSerializer<LocalTime> {

    public LocalTimeSerializer() {
        this(FormatterConstant.LOCAL_TIME);
    }

    public LocalTimeSerializer(DateTimeFormatter formatter) {
        super(formatter::format);
    }

}
