package com.jonlin.common.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 图片上传实体类<br>
 * 图片上传实体类
 *
 * @author hyz
 * @version [V1.0, 2016年12月29日]
 */
@Data
public class PictureResponse {
    
    private int error;
    
    private String url;
    
    private String message;
    
    /**
     * 错误单数1
     */
    private int size;
    
    private String orderId;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 图片结果
     */
    private List<String> result;
    
    /**
     * 是否寄送签收人
     */
    private Integer isBackReceipt;
    
    /**
     * 接收人名称
     */
    private String sendRecipient;
}
