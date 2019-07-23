package com.jonlin.common.enums;

/**
 * <br/>
 *  停用标记枚举
 * @author zl
 * @version [V1.0 2017/6/27 16:42]
 */
public enum StatusEnum {
    ENABLE(0, "启用"),
    DISABLE(1, "禁用");
    private int code;
    private String msg;

    private StatusEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }

}
