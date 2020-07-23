package com.fcy.common.jackson.ability;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 使用code序列化的能力<br/>
 * 使用该接口将会默认使用getCode进行序列化
 * 注：jackson为Enum类支持了使用getCode进行反序列化的能力
 * @author fcy
 * @date 2020/7/22
 */
public interface CodeSerializable {
    /**
     * 获取code
     *
     * @return code
     */
    @JsonValue
    String getCode();
}
