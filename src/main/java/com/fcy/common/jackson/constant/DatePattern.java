package com.fcy.common.jackson.constant;

/**
 * @author fcy
 * @date 2020/7/21
 */
public class DatePattern {
    /**
     * 日期之间的分割符
     */
    public static String DATE_SEPARATOR = "-";
    /**
     * 时间之间的分割符
     */
    public static String TIME_SEPARATOR = ":";
    /**
     * 日期于时间之间的分割符
     */
    public static String DATE_TIME_SEPARATOR = " ";
    /**
     * 日期格式
     */
    public static String DATE_PLAIN = "yyyy" + DATE_SEPARATOR + "MM" + DATE_SEPARATOR + "dd";
    /**
     * 时间格式
     */
    public static String TIME_PLAIN = "HH" + TIME_SEPARATOR + "mm" + TIME_SEPARATOR + "ss";
    /**
     * 日期时间格式
     */
    public static String DATE_TIME_PLAIN = DATE_PLAIN + DATE_TIME_SEPARATOR + TIME_PLAIN;
    /**
     * 日期正则
     */
    public static String DATE_PATTERN_STR = "\\d{4}[" + DATE_SEPARATOR + "]\\d{2}[" + DATE_SEPARATOR + "]\\d{2}";
    /**
     * 时间正则
     */
    public static String TIME_PATTERN_STR = "\\d{2}[" + TIME_SEPARATOR + "]\\d{2}[" + TIME_SEPARATOR + "]\\d{2}";
    /**
     * 日期时间正则
     */
    public static String DATE_TIME_PATTERN_STR = DATE_PATTERN_STR + "\\s" + TIME_PATTERN_STR;
}
