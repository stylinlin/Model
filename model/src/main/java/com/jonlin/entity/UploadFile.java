package com.jonlin.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * description 上传文件
 * Author Jonlin
 * Date 2019/7/11 14:01
 **/
@Data
public class UploadFile {
    private MultipartFile[] files;
}
