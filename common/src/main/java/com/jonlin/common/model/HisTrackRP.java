package com.jonlin.common.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * <br/>
 * 智云 轨迹
 * @author zl
 * @version [V1.0 2018-09-04 16:52]
 */
@Data
public class HisTrackRP implements Serializable{
    private String orderNo; // 计划单号
    private ArrayList<HisTrackPointRP> points; // 轨迹点集合
}
