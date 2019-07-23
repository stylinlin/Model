package com.jonlin.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * <br/>
 * 智云 轨迹点
 * @author zl
 * @version [V1.0 2018-09-04 16:52]
 */
@Data
public class HisTrackPointRP implements Serializable {
    private String lat; // 纬度
    private String lon; // 经度
    private String gtm; // GPS时间
    private String spd; // GPS速度
    private String mlg; // 里程
    private String hgt; // 海拔
    private String agl; // 正北方向夹角
}
