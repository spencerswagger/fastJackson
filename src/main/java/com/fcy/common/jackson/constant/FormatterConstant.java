package com.fcy.common.jackson.constant;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import static java.time.temporal.ChronoField.*;

/**
 * @author fcy
 * @date 2020/7/21
 */
public class FormatterConstant {
    /**
     * yyyy-MM-dd such as '2011-12-03'
     * 同{@link DateTimeFormatter#ISO_LOCAL_DATE}
     */
    public static DateTimeFormatter LOCAL_DATE = DateTimeFormatter.ISO_LOCAL_DATE;
    /**
     * hh:mm:ss such as '10:15:30'
     * 区别于{@link DateTimeFormatter#ISO_LOCAL_TIME}:不再省略分秒或输出毫秒微秒
     */
    public static DateTimeFormatter LOCAL_TIME = new DateTimeFormatterBuilder()
        .appendValue(HOUR_OF_DAY, 2)
        .appendLiteral(':')
        .appendValue(MINUTE_OF_HOUR, 2)
        .appendLiteral(':')
        .appendValue(SECOND_OF_MINUTE, 2)
        .toFormatter();
    /**
     * yyyy-mm-dd hh:mi:ss such as '2011-12-03 10:15:30'
     * 区别于{@link DateTimeFormatter#ISO_LOCAL_DATE_TIME}:不再省略分秒或输出毫秒微秒
     */
    public static DateTimeFormatter LOCAL_DATE_TIME = new DateTimeFormatterBuilder()
        .append(LOCAL_DATE)
        .appendLiteral(' ')
        .append(LOCAL_TIME)
        .toFormatter();

    /**
     * hh:mm:ss such as '10:15:30'
     * 区别于{@link DateTimeFormatter#ISO_LOCAL_TIME}:不再省略分秒或输出毫秒微秒
     */
    public static DateTimeFormatter ISO_TIME = LOCAL_TIME;
    /**
     * yyyy-MM-dd such as '2011-12-03'
     * 同{@link DateTimeFormatter#ISO_LOCAL_DATE}
     */
    public static DateTimeFormatter ISO_DATE = LOCAL_DATE;
    /**
     * yyyy-mm-ddThh:mi:ss such as '2011-12-03T10:15:30'
     * 区别于{@link DateTimeFormatter#ISO_LOCAL_DATE_TIME}:不再省略分秒或输出毫秒微秒
     */
    public static DateTimeFormatter ISO_DATE_TIME = new DateTimeFormatterBuilder()
        .parseCaseInsensitive()
        .append(ISO_DATE)
        .appendLiteral('T')
        .append(ISO_TIME)
        .toFormatter();
    /**
     * yyyy-mm-ddThh:mi:ssZ such as '2011-12-03T10:15:30+01:00'
     * 区别于{@link DateTimeFormatter#ISO_OFFSET_DATE_TIME}:不再省略分秒或输出毫秒微秒
     */
    public static DateTimeFormatter ISO_OFFSET_DATE_TIME = new DateTimeFormatterBuilder()
        .parseCaseInsensitive()
        .append(ISO_DATE_TIME)
        .appendOffsetId()
        .toFormatter();
    /**
     * yyyy-mm-ddThh:mi:ssZ[V] such as '2011-12-03T10:15:30+01:00[Europe/Paris]'
     * 区别于{@link DateTimeFormatter#ISO_ZONED_DATE_TIME}:不再省略分秒或输出毫秒微秒
     */
    public static DateTimeFormatter ISO_ZONED_DATE_TIME = new DateTimeFormatterBuilder()
        .append(ISO_OFFSET_DATE_TIME)
        .appendLiteral('[')
        .parseCaseSensitive()
        .appendZoneRegionId()
        .appendLiteral(']')
        .toFormatter();
}
