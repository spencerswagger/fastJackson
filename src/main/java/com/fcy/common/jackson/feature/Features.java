package com.fcy.common.jackson.feature;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fcy.common.jackson.constant.FormatterConstant;
import org.apache.commons.lang3.ArrayUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static com.fasterxml.jackson.databind.DeserializationFeature.*;
import static com.fasterxml.jackson.databind.SerializationFeature.*;

/**
 * @author fcy
 * @date 2020/7/21
 */
public class Features {
    public static class Dates {
        /**
         * 使用符合ISO8601的序列化器<br>
         * yyyy-mm-ddThh:mi:ssZ[V] such as '2011-12-03T10:15:30+01:00[Europe/Paris]'
         */
        public static Feature[] USE_ISO8601_SERIALIZER = new Feature[] {
            SerializeFeature.of(LocalDateTime.class, FormatterConstant.ISO_DATE_TIME::format),
            SerializeFeature.of(LocalDate.class, FormatterConstant.ISO_DATE::format),
            SerializeFeature.of(LocalTime.class, FormatterConstant.ISO_TIME::format),
            SerializeFeature.of(ZonedDateTime.class, FormatterConstant.ISO_ZONED_DATE_TIME::format),
            SerializeFeature.of(OffsetDateTime.class, FormatterConstant.ISO_OFFSET_DATE_TIME::format),
            SerializeFeature.of(Date.class, value -> FormatterConstant.ISO_OFFSET_DATE_TIME.format(value
                .toInstant()
                .atZone(ZoneId.systemDefault()))),
        };
        /**
         * 使用符合ISO8601的反序列化器<br>
         * yyyy-mm-ddThh:mi:ssZ[V] such as '2011-12-03T10:15:30+01:00[Europe/Paris]'
         */
        public static Feature[] USE_ISO8601_DESERIALIZER = new Feature[] {
            DeserializeFeature.of(LocalDateTime.class, s -> LocalDateTime.parse(s, DateTimeFormatter.ISO_LOCAL_DATE_TIME)),
            DeserializeFeature.of(LocalDate.class, s -> LocalDate.parse(s, DateTimeFormatter.ISO_LOCAL_DATE)),
            DeserializeFeature.of(LocalTime.class, s -> LocalTime.parse(s, DateTimeFormatter.ISO_LOCAL_TIME)),
            DeserializeFeature.of(ZonedDateTime.class,
                s -> ZonedDateTime.parse(s, DateTimeFormatter.ISO_ZONED_DATE_TIME)),
            DeserializeFeature.of(OffsetDateTime.class,
                s -> OffsetDateTime.parse(s, DateTimeFormatter.ISO_OFFSET_DATE_TIME)),
            DeserializeFeature.of(Date.class,
                s -> Date.from(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(s, Instant::from))),
        };

        /**
         * 使用符合ISO8601的(反)序列化器<br>
         * yyyy-mm-ddThh:mi:ssZ[V] such as '2011-12-03T10:15:30+01:00[Europe/Paris]'
         */
        public static Feature[] USE_ISO8601 = ArrayUtils.addAll(USE_ISO8601_SERIALIZER, USE_ISO8601_DESERIALIZER);
    }
    public static class Enums {
        public static Feature[] USE_TO_STRING = new Feature[] {
            Feature.of(WRITE_ENUMS_USING_TO_STRING,true),
            Feature.of(READ_ENUMS_USING_TO_STRING,true)
        };
        public static Feature[] USE_ORDINAL = new Feature[] {
            Feature.of(WRITE_ENUMS_USING_INDEX,true),
            Feature.of(WRITE_ENUM_KEYS_USING_INDEX,true)
        };
    }
}
