/**
 * Copyright (C), 2017-2018, 上海阁为信息科技有限公司
 * FileName: JsonUtils.java
 * Author:   hyz
 * Date:     2017-11-29 10:06
 * Description: JsonUtils
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.jonlin.common.utils;

import java.util.List;

/**
 * JsonUtils<br/>
 * @author hyz
 * @version [V1.0 2017-11-29 10:06]
 */
public class JsonUtils {
    
    
    private static JsonMapper jsonMapper = JsonMapper.getDefault();
    
    public static String toJson(Object object) {
        return jsonMapper.toJson(object);
    }
    /**
     * 不含值为null的属性
     * @param object
     * @return
     */
    public static String toJsonIgnoreNullField(Object object) {
        return JsonMapper.nonNullMapper().toJson(object);
    }
    
    public static <T> T toObject(String jsonString, Class<T> clazz) {
        return  jsonMapper.toObject(jsonString, clazz);
    }
    
    public static <T> List<T> toList(String jsonString, Class<T> clazz) {
        return jsonMapper.toList(jsonString, clazz);
    }
}
