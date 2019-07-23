package com.jonlin.common.utils;

import com.jonlin.common.fastdfs.FastDFSClient;
import com.jonlin.common.fastdfs.FastDFSException;
import com.jonlin.common.fastdfs.FileResponseData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * Copyright (C), 2017-2018, 上海阁为信息科技有限公司
 * FileName: UploadUtil.java
 * Author:   Lct
 * Date:     2018-07-04 10:50
 * Description: 图片上传
 */
@PropertySource("classpath:conf/resource.properties")
@Component
public class UploadUtil {

    private FastDFSClient fastDFSClient = new FastDFSClient();

    /**
     * 文件服务器地址
     */
    @Value("${file_server_addr}")
    private  String fileServerAddr;

    /**
     * FastDFS秘钥
     */
    @Value("${fastdfs.http_secret_key}")
    private  String fastDFSHttpSecretKey;


    /**
     * 上传通用方法，只上传到服务器，不保存记录到数据库
     *
     * @param file
     * @return
     */
    public FileResponseData uploadFile(MultipartFile file){

        FileResponseData responseData = new FileResponseData();
        try {
            // 上传到服务器
            String filepath = fastDFSClient.uploadFileWithMultipart(file);

            responseData.setFileName(file.getOriginalFilename());
            responseData.setFilePath(filepath);
            responseData.setFileType(fastDFSClient.getFilenameSuffix(file.getOriginalFilename()));
            // 设置访文件的Http地址. 有时效性.
            String token = fastDFSClient.getToken(filepath, fastDFSHttpSecretKey);
            responseData.setToken(token);
            //responseData.setHttpUrl(fileServerAddr+"/"+filepath+"?"+token);
            responseData.setHttpUrl("/"+filepath+"?"+token);
        } catch (FastDFSException e) {
            responseData.setSuccess(false);
            responseData.setCode(e.getCode());
            responseData.setMessage(e.getMessage());
        }

        return responseData;
    }
}
