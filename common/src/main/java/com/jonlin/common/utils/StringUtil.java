package com.jonlin.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * String工具类
 */
public class StringUtil {

    /** 将逗号隔开的字符串转换成Long[]数组 */
    public static Long[] toLongArray(String strs){
        String[] strArray = strs.split(",");
        Long[] longArray = new Long[strArray.length];
        for(int i = 0 ; i < strArray.length ; i++){
            longArray[i] = Long.valueOf(strArray[i]);
        }

        return longArray;
    }

    /** 首字母大写 */
    public static String upperCase(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }

        return new String(ch);
    }

    /**
     * 将list转为带逗号的字符串
     * @param list
     * @return
     */
    public static String listToString(List<String> list) {
        if (list == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        boolean first = true;
        //第一个前面不拼接","
        for (String string : list) {
            if (first) {
                first = false;
            } else {
                result.append(",");
            }
            result.append(string);
        }
        return result.toString();
    }

    /**
     * 数组用都好分割
     * @param str : 数组
     * @return : 结果
     */
    public static String commaSeg(String [] str) {

        StringBuffer buffer =new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            buffer.append(str[i]).append(",");
        }

        return  buffer.substring(0, buffer.length()-1);
    }

    /**
     * 数组去重
     * @param start : 开始的数组 小于结束的数组
     * @param end : 开始的数组 小于结束的数组
     * @return : 结果
     */
    public static String [] removeRepeat(String [] start, String [] end) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < end.length; i++) {
            for (int j = 0; j < start.length; j++) {
                if(!end[i].equals(start[j])) {

                    list.add(end[i]);
                }
            }
        }

        return list.toArray(new String[list.size()]);
    }

    /**
     * 数组转换成list
     * @param str  : 数组
     * @return : 结果
     */
    public static List<String> getList(String [] str) {
        List<String> list = new ArrayList<>();
        for (String string : str) {

            list.add(string);
        }

        return  list;
    }

    /**
     * 拆分地址信息
     * @param str
     * @param regex
     * @return
     */
    public static List<String> getAreaInfo(String str, String regex) {
        List<String> result = new ArrayList<>();
        if(StringUtils.isEmpty(str)){
            return result;
        }
        String [] strs = str.split(regex);
        for(String addData : strs) {
            if(str.length()>0){
                result.add(addData);
            }
        }
        return result;
    }

    public static List<Long> stringToList(String str){
        if(StringUtils.isEmpty(str)){
            return null;
        }
        Long[] array=StringUtil.toLongArray(str);
        List<Long> ids = new ArrayList<>();
        for (Long id : array) {
            ids.add(id);
        }
        return ids;
    }

    public static String nullToSpace(Object src){
        if (src == null)
            return "";
        return src.toString();
    }

    /**
     * lambda 输入一个数据返回一个处理后的数据
     * @param param : 请求参数
     * @param fun : 接口函数
     * @return : 返回结果
     */
    public static String getStr(String param, Function<String, String> fun) {

        return fun.apply(param);
    }
}
