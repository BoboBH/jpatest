package com.bobo.one.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {


    /***
     * 20791231
     */
    public static final Integer MAX_DATE = 20791231;

    /***
     * yyyyMMdd
     */
    public static final String yyyyMMdd = "yyyyMMdd";
    /***
     * yyyy-MM-dd
     */
    public static final String yyyy_MM_dd = "yyyy-MM-dd";
    /***
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";

    /**
     * HH:mm:ss
     */
    public static final String HH_mm_ss = "HH:mm:ss";

    public static String format(Date dt, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(dt);
    }

    /*
     return Integer as yyyyMMdd
     */
    public static Integer getInteger(Date dt) {
        return Integer.valueOf(format(dt, yyyyMMdd));
    }

    public static Date parse(String source, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(source);
    }

    public static String getShortDate(Date date) {
        if (null == date) {
            date = new Date();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(yyyy_MM_dd);
        return dateFormat.format(date);
    }

    public static String getDateString(Long timestamp) {
        Date date = new Date(timestamp);
        SimpleDateFormat dateFormat = new SimpleDateFormat(yyyy_MM_dd_HH_mm_ss);
        return dateFormat.format(date);
    }

    public static Long getTimeStamp(Date date){
         return date.getTime();
    }

}
