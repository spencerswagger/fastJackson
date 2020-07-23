package com.fcy.common.jackson.formatter;

import com.fcy.common.jackson.constant.DatePattern;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fcy
 * @date 2020/7/21
 */
public class LocalDateFormatter extends DateFormat {
    public LocalDateFormatter() {
        this(DatePattern.DATE_TIME_PLAIN);
    }

    public LocalDateFormatter(String pattern) {
        this.pattern = pattern;
    }

    protected String pattern;
    protected ThreadLocal<SimpleDateFormat> localFormatter = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(pattern);
        }
    };

    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
        return localFormatter
            .get()
            .format(date, toAppendTo, fieldPosition);
    }

    @Override
    public Date parse(String source, ParsePosition pos) {
        return localFormatter
            .get()
            .parse(source, pos);
    }
}
