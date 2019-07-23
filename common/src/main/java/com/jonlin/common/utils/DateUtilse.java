package com.jonlin.common.utils;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author Hao
 * @create 2017-04-10
 */
public class DateUtilse {
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String MM_DD = "MM-dd";
    public static final String HH_MM_SS = "HH:mm:ss";
    public static final String HH_MM = "HH:mm";

    public final static DateTimeFormatter FORMATTER_YYYY_MM_DD_HH_MM_SS = DateTimeFormat.forPattern(YYYY_MM_DD_HH_MM_SS);
    public final static DateTimeFormatter FORMATTER_YYYY_MM_DD_HH_MM = DateTimeFormat.forPattern(YYYY_MM_DD_HH_MM);
    public final static DateTimeFormatter FORMATTER_YYYY_MM_DD = DateTimeFormat.forPattern(YYYY_MM_DD);
    public final static DateTimeFormatter FORMATTER_MM_DD = DateTimeFormat.forPattern(MM_DD);
    public final static DateTimeFormatter FORMATTER_HH_MM_SS = DateTimeFormat.forPattern(HH_MM_SS);
    public final static DateTimeFormatter FORMATTER_HH_MM = DateTimeFormat.forPattern(HH_MM);
    
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public static String format(String dateTime, String targetPattern) {
        return format(dateTime, FORMATTER_YYYY_MM_DD_HH_MM_SS, targetPattern);
    }

    public static String format(String dateTime, DateTimeFormatter formatter, String targetPattern) {
        DateTime result = DateTime.parse(dateTime, formatter);
        return result.toString(targetPattern);
    }

    public static String format(Date time, String targetPattern) {
        DateTime dateTime = new DateTime(time);
        return dateTime.toString(targetPattern);
    }

    public static Date format(String dateTime, DateTimeFormatter formatter) {
        DateTime time = DateTime.parse(dateTime, formatter);
        return time.toDate();
    }

    public static Date format(String dateTime) {
        return format(dateTime, FORMATTER_YYYY_MM_DD_HH_MM_SS);
    }

    public static String toYmd(Date dateTime) {
        return format(dateTime, YYYY_MM_DD);
    }

    public static String toMd(Date dateTime) {
        return format(dateTime, MM_DD);
    }

    public static String toHm(Date dateTime) {
        return format(dateTime, HH_MM);
    }

    public static String toYmdHm(Date dateTime) {
        return format(dateTime, YYYY_MM_DD_HH_MM);
    }

    public static Date startOfDay(Date value) {
        DateTime dateTime = new DateTime(value);
        dateTime = new DateTime(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(), 00, 00, 00);
        return dateTime.toDate();
    }

    public static Date endOfDay(Date value) {
        DateTime dateTime = new DateTime(value);
        dateTime = new DateTime(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(), 23, 59, 59);
        return dateTime.toDate();
    }
    
    public final static String format(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        return dateStr;
    }

    public static void main(String[] args) {
        String s = format("2017-02-03 12:23:23", HH_MM_SS);
        Date d = format("2017-02-03", FORMATTER_YYYY_MM_DD);
        String s1 = format(d, HH_MM_SS);
        System.out.println(s1);

        String date = toHm(new Date());
        System.out.println(date);
    
        String str = DateUtils.format(new Date(), "yyyyMM");
    
        System.out.println("测试----->" + str.substring(2,6));
    }
    
    /**
     * 获取一天结束时间<br>
     * generate by: vakin jiang at 2011-12-23
     *
     * @param date
     * @return
     */
    public static Date getDayEnd(Date date) {
        String format = DateFormatUtils.format(date, DATE_PATTERN);
        return parseDate(format.concat(" 23:59:59"));
    }
    
    /**
     * 解析日期<br>
     * 支持格式：<br>
     * generate by: vakin jiang at 2012-3-1
     *
     * @param dateStr
     * @return
     */
    public static Date parseDate(String dateStr) {
        SimpleDateFormat format = null;
        if (org.apache.commons.lang3.StringUtils.isBlank(dateStr))
            return null;
        String _dateStr = dateStr.trim();
        try {
            if (_dateStr.matches("\\d{1,2}[A-Z]{3}")) {
                _dateStr = _dateStr
                        + (Calendar.getInstance().get(Calendar.YEAR) - 2000);
            }
            // 01OCT12
            if (_dateStr.matches("\\d{1,2}[A-Z]{3}\\d{2}")) {
                format = new SimpleDateFormat("ddMMMyy", Locale.ENGLISH);
            } else if (_dateStr.matches("\\d{1,2}[A-Z]{3}\\d{4}.*")) {// 01OCT2012
                // ,01OCT2012
                // 1224,01OCT2012
                // 12:24
                _dateStr = _dateStr.replaceAll("[^0-9A-Z]", "")
                        .concat("000000").substring(0, 15);
                format = new SimpleDateFormat("ddMMMyyyyHHmmss", Locale.ENGLISH);
            } else {
                StringBuffer sb = new StringBuffer(_dateStr);
                String[] tempArr = _dateStr.split("\\s+");
                tempArr = tempArr[0].split("-|\\/");
                if (tempArr.length == 3) {
                    if (tempArr[1].length() == 1) {
                        sb.insert(5, "0");
                    }
                    if (tempArr[2].length() == 1) {
                        sb.insert(8, "0");
                    }
                }
                _dateStr = sb.append("000000").toString().replaceAll("[^0-9]",
                        "").substring(0, 14);
                if (_dateStr.matches("\\d{14}")) {
                    format = new SimpleDateFormat("yyyyMMddHHmmss");
                }
            }
            Date date = format.parse(_dateStr);
            return date;
        } catch (Exception e) {
            throw new RuntimeException("无法解析日期字符[" + dateStr + "]");
        }
    }
    
    /**
     * 比较两个时间相差多少秒
     * */
    public static long getDiffSeconds(Date d1, Date d2) {
        return Math.abs((d2.getTime() - d1.getTime()) / 1000);
    }
    
}
