package com.jonlin.api.controller;

import com.jonlin.common.BaseException;
import com.jonlin.common.ResultResponse;
import com.jonlin.entity.UploadFile;
import com.jonlin.entity.User;
import com.jonlin.mapper.UserMapper;
import com.jonlin.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description 测试类
 * Author Jonlin
 * Date 2019/2/26 16:35
 **/
@RestController
public class TestController {
    @Resource
    TestService testService;

    @Resource
    UserMapper userMapper;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public ResultResponse test(User user) throws Exception {
        ArrayList<User> list = testService.test(user);
        throw new Exception("daw");
//        return ResultResponse.ok(list);
    }

    /**
     * 文件上传
     * @param uploadFile
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    public ResultResponse uploadFile(UploadFile uploadFile) {
        HashMap<String,String> map = testService.uploadFile(uploadFile);
        return ResultResponse.ok(map);
    }

    @RequestMapping(value = "/test1")
    public Object test1() throws Exception {
//        List<User> list = testService.test();
        throw new BaseException("呵呵");
//        return list;
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResultResponse getAll() {
        List<User> list = userMapper.selectAll();
        return ResultResponse.ok((ArrayList)list);
    }

    @RequestMapping(value = "/selectByName",method = RequestMethod.GET)
    public ResultResponse selectByName(User user) {
        List<User> list = userMapper.selectByName(user.getName());
        return ResultResponse.ok((ArrayList)list);
    }
}
