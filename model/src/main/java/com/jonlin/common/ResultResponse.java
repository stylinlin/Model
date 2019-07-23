package com.jonlin.common;


import com.jonlin.enums.ResultCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * Copyright (C), 2017-2018, 上海阁为信息科技有限公司
 * FileName: ResultResponse.java
 * Author:   hyz
 * Date:     2018-03-15 19:54
 * Description: 通用响应类
 */
@Data
public class ResultResponse implements Serializable {
    /**
     * 序列化
     */
    private static final long serialVersionUID = -6010932515432454307L;

    /**
     * 结果编码（code=200为正常响应，其他为异常响应）
     */
    private String code = "200";

    /**
     * 结果信息(异常响应信息)
     */
    private String msg = "操作成功";

    /**
     * 返回结果
     */
    private Serializable content;

    /**
     * 无参构造
     */
    public ResultResponse() {
    }

    public ResultResponse(String code) {
        this.code = code;
    }

    /**
     * @param code
     * @param msg
     */
    public ResultResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * @param code
     * @param content
     */
    public ResultResponse(String code, Serializable content) {
        this.code = code;
        this.content = content;
    }

    /**
     * @param code
     * @param msg
     * @param content
     */
    public ResultResponse(String code, String msg, Serializable content) {
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    public static ResultResponse ok() {
        ResultResponse resultResponse = new ResultResponse(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage());
        return resultResponse;
    }

    public static ResultResponse ok(Serializable content) {
        ResultResponse resultResponse = new ResultResponse(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(), content);
        return resultResponse;
    }

    public static ResultResponse ok(String msg, Serializable content) {
        ResultResponse resultResponse = new ResultResponse(ResultCodeEnum.SUCCESS.getCode(), msg, content);
        return resultResponse;
    }

    public static ResultResponse fail() {
        ResultResponse resultResponse = new ResultResponse(ResultCodeEnum.FAIL.getCode(), ResultCodeEnum.FAIL.getMessage());
        return resultResponse;
    }

    public static ResultResponse fail(String msg) {
        ResultResponse resultResponse = new ResultResponse(ResultCodeEnum.FAIL.getCode(), msg);
        return resultResponse;
    }


    public static ResultResponse fail(String code, String msg) {
        ResultResponse resultResponse = new ResultResponse(code, msg);
        return resultResponse;
    }

    @Override
    public String toString() {
        return "ResultResponse{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", content=" + content +
                '}';
    }
}