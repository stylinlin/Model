package com.jonlin.common.utils;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * Copyright (C), 2017-2018, 上海阁为信息科技有限公司
 * FileName: PictureServerUtil.java
 * Author:   Lct
 * Date:     2018-07-04 15:20
 * Description: 图片 url地址截取
 */
public class PictureServerUtil {

    public static String getNewUrl(String url){
        StringBuffer sb=new StringBuffer();
        ArrayList<String> urlList= Lists.newArrayList(url.split("/"));
        urlList.remove(0);
        for (String subUrl : urlList) {
            sb.append(subUrl);
            sb.append("/");
        }
        sb.delete(sb.length() - 1, sb.length());
        String newUrl= sb.toString();

         return newUrl;
    }
}
