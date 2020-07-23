package com.fcy.common.jackson.serializer.time;

import com.fcy.common.jackson.constant.FormatterConstant;
import com.fcy.common.jackson.serializer.StandardSerializer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author fcy
 * @date 2020/7/21
 */
public class LocalDateSerializer extends StandardSerializer<LocalDate> {

    public LocalDateSerializer() {
        this(FormatterConstant.LOCAL_DATE);
    }

    public LocalDateSerializer(DateTimeFormatter formatter) {
        super(formatter::format);
    }

}
