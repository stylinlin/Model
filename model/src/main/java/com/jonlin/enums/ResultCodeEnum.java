package com.jonlin.enums;

/**
 * <br/>
 * 返回code枚举
 * @author zl
 * @version [V1.0 2018-06-29 10:09]
 */
public enum ResultCodeEnum {
    SUCCESS("200", "操作成功"),
    FAIL("-1", "操作失败"),
    FORBIDDEN("403", "禁止访问"),
    UN_KNOW_EXCEPTION("500", "未知异常");

    public String code;

    public String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
