package com.fcy.common.jackson.model;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fcy.common.jackson.deserializer.time.DateDeserializer;
import com.fcy.common.jackson.deserializer.time.LocalDateDeserializer;
import com.fcy.common.jackson.deserializer.time.LocalDateTimeDeserializer;
import com.fcy.common.jackson.deserializer.time.LocalTimeDeserializer;
import com.fcy.common.jackson.serializer.time.DateSerializer;
import com.fcy.common.jackson.serializer.time.LocalDateSerializer;
import com.fcy.common.jackson.serializer.time.LocalDateTimeSerializer;
import com.fcy.common.jackson.serializer.time.LocalTimeSerializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author fcy
 * @date 2020/7/21
 */
public class TimeModule extends SimpleModule {
    public TimeModule() {
        // 加入版本信息
        // super(VersionUtil.parseVersion("","",""));

        addSerializer(Date.class, new DateSerializer());
        addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        addSerializer(LocalDate.class, new LocalDateSerializer());
        addSerializer(LocalTime.class, new LocalTimeSerializer());

        addDeserializer(Date.class, new DateDeserializer());
        addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        addDeserializer(LocalDate.class, new LocalDateDeserializer());
        addDeserializer(LocalTime.class, new LocalTimeDeserializer());
    }
}
