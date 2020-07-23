package com.fcy.common.jackson.ability;

/**
 * 可修改日期格式的能力
 *
 * @author fcy
 * @date 2020/7/21
 */
public interface DateTimePatternModifiable {
    /**
     * 修改日期格式
     * @param pattern 日期格式
     */
    void setTimePattern(String pattern);
}
