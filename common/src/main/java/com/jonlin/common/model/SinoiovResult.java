package com.jonlin.common.model;

import lombok.Data;

/**
 * <br/>
 * 智云api 返回对象
 * @author zl
 * @version [V1.0 2018-09-05 9:11]
 */
@Data
public class SinoiovResult {
    private int code; // 1001:正常；其他，-1：异常
    private Object content; // 最终结果
    private String msg; // 异常信息
}
