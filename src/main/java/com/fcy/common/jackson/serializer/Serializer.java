package com.fcy.common.jackson.serializer;

import java.io.IOException;

/**
 * @author fcy
 * @date 2020/7/21
 */
public interface Serializer<T,R> {
    /**
     * 将value序列化的方法
     *
     * @param value 待序列化值
     * @return 序列化值
     * @throws RuntimeException 转换时报错
     */
    R serialize(T value) throws RuntimeException,IOException;
}
