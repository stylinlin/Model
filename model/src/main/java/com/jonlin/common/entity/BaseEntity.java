package com.jonlin.common.entity;

import lombok.Data;

import java.util.Date;

/**
 * 基础实体
 */
@Data
public class BaseEntity extends PK {

    /**
     * 创建时间
     */
    protected Date createTime;

    /**
     * 更新时间
     */
    protected Date updateTime;

    /**
     * 是否已删除 1=已删除 0=未删除
     */
    private String isDeleted;

    public BaseEntity() {
        super();
    }


}
