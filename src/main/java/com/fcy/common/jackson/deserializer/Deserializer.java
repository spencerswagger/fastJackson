package com.fcy.common.jackson.deserializer;

import java.io.IOException;

/**
 * @author fcy
 * @date 2020/7/21
 */
public interface Deserializer<T,R> {
    /**
     * 将value反序列化的方法
     *
     * @param value 将要反序列化的值
     * @return 反序列化后的值
     * @throws RuntimeException 反序列化异常
     */
    R deserialize(T value) throws RuntimeException, IOException;
}
