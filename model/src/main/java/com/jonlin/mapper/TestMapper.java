package com.jonlin.mapper;

import com.jonlin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * description 测试mapper
 * Author Jonlin
 * Date 2019/2/26 17:59
 **/
@Mapper
public interface TestMapper {

    /**
     * 功能描述 测试方法
     * author Jonlin
     * date 2019/2/26 17:59
     * param
     * return java.lang.Object
     */
    ArrayList<User> test(@Param("user") User user);
}
