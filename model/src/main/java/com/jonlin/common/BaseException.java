package com.jonlin.common;

/**
 * description 全局基本异常
 * Author Jonlin
 * Date 2019/3/7 13:20
 **/
public class BaseException extends RuntimeException {
    /**
     * 默认构造函数
     */
    public BaseException() {
    }

    /**
     * 构造函数
     * @param errMsg 异常消息
     */
    public BaseException(String errMsg) {
        super(errMsg);
    }

    /**
     * 构造函数
     * @param cause 原始异常
     */
    public BaseException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     * @param errMsg 异常消息
     * @param cause 原始异常
     */
    public BaseException(String errMsg, Throwable cause) {
        super(errMsg, cause);
    }
}
