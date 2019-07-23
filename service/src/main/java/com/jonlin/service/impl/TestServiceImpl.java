package com.jonlin.service.impl;

import com.jonlin.common.fastdfs.FileResponseData;
import com.jonlin.common.utils.UploadUtil;
import com.jonlin.entity.UploadFile;
import com.jonlin.entity.User;
import com.jonlin.mapper.TestMapper;
import com.jonlin.mapper.UserMapper;
import com.jonlin.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * description Test实现
 * Author Jonlin
 * Date 2019/2/26 17:52
 **/
@Service
public class TestServiceImpl implements TestService {
    @Resource
    TestMapper testMapper;
    @Resource
    UserMapper userMapper;

    @Resource
    private UploadUtil uploadUtil;

    @Override
    public ArrayList<User> test(User user) {
        return testMapper.test(user);
    }

    @Override
    public HashMap<String, String> uploadFile(UploadFile uploadFile) {
        FileResponseData responseData1 = uploadUtil.uploadFile(uploadFile.getFiles()[0]);
        HashMap<String, String> image = new HashMap<>();
        image.put("image", responseData1.getHttpUrl());
        return image;
    }
}
