package com.fcy.common.jackson.deserializer.time;

import com.fcy.common.jackson.constant.FormatterConstant;
import com.fcy.common.jackson.deserializer.Deserializer;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author fcy
 * @date 2020/7/21
 */
public class DateDeserializer extends AbstractJava8TimeDeserializer<Date> {

    public DateDeserializer() {
        deserializer = buildDeserializer(FormatterConstant.LOCAL_DATE_TIME);
    }

    public DateDeserializer(Deserializer<String, Date> deserializer) {
        super(deserializer);
    }

    @Override
    protected Deserializer<String, Date> buildDeserializer(DateTimeFormatter formatter) {
        return value -> Date.from(formatter.parse(value, Instant::from));
    }
}
