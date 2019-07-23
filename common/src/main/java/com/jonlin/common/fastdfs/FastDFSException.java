package com.jonlin.common.fastdfs;

import lombok.Data;

/**
 * Copyright (C), 2017-2018, 上海阁为信息科技有限公司
 * FileName: FastDFSException.java
 * Author:   hyz
 * Date:     2018-05-30 14:00
 * Description: FastDFS 上传下载时可能出现的一些异常信息
 */
@Data
public class FastDFSException extends Exception {

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误消息
     */
    private String message;

    public FastDFSException(){}

    public FastDFSException(String code, String message) {
        this.code = code;
        this.message = message;
    }

}