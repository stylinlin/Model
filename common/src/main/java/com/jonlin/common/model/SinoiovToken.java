package com.jonlin.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * <br/>
 *
 * @author zl
 * @version [V1.0 2018-09-04 17:18]
 */
@Data
public class SinoiovToken implements Serializable {
    private int code; // 1001:正常；其他，-1：异常
    private String token; // token
    private String msg; // 异常信息
}
