/**
 * Copyright (C), 2017-2018, 上海阁为信息科技有限公司
 * FileName: Serializer.java
 * Author:   hyz
 * Date:     2017-11-29 9:51
 * Description: 对象序列化接口
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.jonlin.common.utils;

import java.io.IOException;

/**
 * 对象序列化接口<br/>
 * @author hyz
 * @version [V1.0 2017-11-29 9:51]
 */
public interface Serializer {
    
    public String name();
    
    public byte[] serialize(Object obj) throws IOException;
    
    public Object deserialize(byte[] bytes) throws IOException ;
    
}
