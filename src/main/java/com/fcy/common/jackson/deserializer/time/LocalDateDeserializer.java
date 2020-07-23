package com.fcy.common.jackson.deserializer.time;

import com.fcy.common.jackson.constant.FormatterConstant;
import com.fcy.common.jackson.deserializer.Deserializer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author fcy
 * @date 2020/7/21
 */
public class LocalDateDeserializer extends AbstractJava8TimeDeserializer<LocalDate> {

    public LocalDateDeserializer() {
        this(FormatterConstant.LOCAL_DATE);
    }

    public LocalDateDeserializer(DateTimeFormatter formatter) {
        super(value -> LocalDate.parse(value, formatter));
    }

    @Override
    protected Deserializer<String, LocalDate> buildDeserializer(DateTimeFormatter formatter) {
        return value -> LocalDate.parse(value, formatter);
    }
}
