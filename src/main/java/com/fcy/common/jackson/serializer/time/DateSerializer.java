package com.fcy.common.jackson.serializer.time;

import com.fcy.common.jackson.constant.FormatterConstant;
import com.fcy.common.jackson.serializer.StandardSerializer;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author fcy
 * @date 2020/7/21
 */
public class DateSerializer extends StandardSerializer<Date> {

    public DateSerializer() {
        this(FormatterConstant.LOCAL_DATE_TIME);
    }

    public DateSerializer(DateTimeFormatter formatter) {
        super(value -> formatter.format(value
            .toInstant()
            .atZone(ZoneOffset.systemDefault())));
    }

}
