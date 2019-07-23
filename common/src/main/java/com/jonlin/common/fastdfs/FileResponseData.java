package com.jonlin.common.fastdfs;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * Copyright (C), 2017-2018, 上海阁为信息科技有限公司
 * FileName: FileResponseData.java
 * Author:   hyz
 * Date:     2018-05-30 14:01
 * Description:上传文件后的数据返回对象，便于前台获取数据.
 */
@Data
public class FileResponseData implements Serializable{

    private static final long serialVersionUID = -6825077176811146722L;
    /**
     * 返回状态编码
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String code;

    /**
     * 返回信息
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    /**
     * 成功标识
     */
    private boolean success = true;

    /**
     * 文件路径
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String filePath;

    /**
     * 文件名称
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fileName;

    /**
     * 文件类型
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fileType;

    /**
     * Http URL
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String httpUrl;

    /**
     * Http Token
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;


    public FileResponseData(){}

    public FileResponseData(boolean success) {
        this.success = success;
    }
}