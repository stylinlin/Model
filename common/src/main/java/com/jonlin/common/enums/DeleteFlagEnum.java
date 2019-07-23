package com.jonlin.common.enums;

/**
 * <br/>
 *
 * @author zl
 * @version [V1.0 2017/6/27 16:42]
 */
public enum DeleteFlagEnum {
    DELETED(1, "删除"),
    UN_DELETED(0, "未删除");
    private int code;
    private String msg;

    private DeleteFlagEnum(int code, String msg){
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
