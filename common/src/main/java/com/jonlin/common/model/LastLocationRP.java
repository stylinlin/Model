package com.jonlin.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * <br/>
 * 智云 位置
 * @author zl
 * @version [V1.0 2018-09-04 16:47]
 */
@Data
public class LastLocationRP implements Serializable {
    private String lat; // 纬度
    private String lon; // 经度
    private String adr; // 车辆地址位置
    private String utc; // 车辆定位时间
    private String spd; // 速度
    private String drc; // 方向
    private String province; // 省份
    private String city; // 市
    private String country; // 县
}
