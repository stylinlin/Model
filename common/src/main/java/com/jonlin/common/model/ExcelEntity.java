package com.jonlin.common.model;

/**
 * Copyright (C), 2017-2018, 上海阁为信息科技有限公司
 * FileName: ExcelEntity.java
 * Author:   hyz
 * Date:     2018-06-27 23:43
 * Description:
 */

import com.jonlin.common.annotation.ImportExcel;
import com.jonlin.common.annotation.OutputExcel;
import com.jonlin.common.utils.StringUtil;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

/**
 * excel基础类
 */
@Data
public class ExcelEntity {

    /** 标题 */
    private String title;
    /** 排序 */
    private String sort;
    /** 属性名称 */
    private String fieldName;
    /** 参数类型 */
    private Class classType;

    private static String getStr = "get";

    private static String setStr = "set";

    public ExcelEntity(OutputExcel excel, String fieldName){
        this.fieldName = getStr + StringUtil.upperCase(fieldName);
        this.title = StringUtils.isBlank(excel.title())?"":excel.title();
        this.sort = excel.sort()+"";
    }

    public ExcelEntity(ImportExcel excel, String fieldName, Class classType){
        this.fieldName = setStr + StringUtil.upperCase(fieldName);
        this.classType = classType;
        this.sort = excel.value()+"";
    }

    }