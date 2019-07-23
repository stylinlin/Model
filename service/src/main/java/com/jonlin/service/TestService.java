package com.jonlin.service;

import com.jonlin.entity.UploadFile;
import com.jonlin.entity.User;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * description 测试服务类
 * Author Jonlin
 * Date 2019/2/26 17:44
 **/
public interface TestService {
    /**
     * 功能描述 测试方法
     * author Jonlin
     * date 2019/2/26 17:46
     * param
     * return java.lang.Object
     */
    ArrayList<User> test(User user);

    /**
     * 功能描述 上传文件
     * author Jonlin
     * date 2019/7/11 14:06
     * param uploadFile
     * return java.util.Map<java.lang.String,java.lang.String>
     */
    HashMap<String, String> uploadFile(UploadFile uploadFile);
}
