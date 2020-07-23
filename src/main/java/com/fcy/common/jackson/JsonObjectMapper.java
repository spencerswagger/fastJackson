package com.fcy.common.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fcy.common.jackson.model.TimeModule;
import lombok.Getter;

import static com.fasterxml.jackson.databind.DeserializationFeature.*;
import static com.fasterxml.jackson.databind.SerializationFeature.*;

/**
 * {@link ObjectMapper}默认配置
 *
 * @author fcy
 * @date 2020/7/20
 */
public class JsonObjectMapper extends ObjectMapper {
    @Getter
    protected SimpleModule customModule = new SimpleModule();

    public JsonObjectMapper() {
        configureSerialization();
        configureDeserialization();
        registerDefaultModules();
    }

    protected void registerDefaultModules() {
        registerModule(new TimeModule());
    }

    protected void configureSerialization() {
        //属性值为空时不参与序列化
        setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        //未指定序列化器的类型返回空对象，而不是抛出异常
        disable(FAIL_ON_EMPTY_BEANS);
        //当序列化对象自我引用时，不抛出异常
        disable(FAIL_ON_SELF_REFERENCES);
        //当序列化对象自我引用时，将其视为null
        //该功能不兼容2.10
//        enable(WRITE_SELF_REFERENCES_AS_NULL);
        //不将时间序列化为时间戳
        disable(WRITE_DATES_AS_TIMESTAMPS);
        //不将时间段序列化为时间戳
        disable(WRITE_DURATIONS_AS_TIMESTAMPS);
        //枚举类序列成索引(int)
        enable(WRITE_ENUMS_USING_INDEX);
        //枚举类键值序列成索引(int)
        enable(WRITE_ENUM_KEYS_USING_INDEX);
    }

    protected void configureDeserialization() {
        //浮点类型默认使用BigDecimal类型，除非已明确类型
        enable(USE_BIG_DECIMAL_FOR_FLOATS);
        //浮点类型默认使用BigInteger类型，除非已明确类型
        enable(USE_BIG_INTEGER_FOR_INTS);
        //当数组只有一个值时 允许外侧没有[]
        enable(ACCEPT_SINGLE_VALUE_AS_ARRAY);
        //当接收到空字符串时，将其视为null，即使类型是Collection或Map
        enable(ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        //接收到空数组，将其视为null
        enable(ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
        //遇到未知枚举类时，将其视为@JsonEnumDefaultValue中设置的默认值，若默认值缺失，抛出异常
        enable(READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE);
        //反序列化时遇到未知字段不抛出异常
        disable(FAIL_ON_UNKNOWN_PROPERTIES);
    }
}
