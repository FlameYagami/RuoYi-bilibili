package com.ruoyi.common.utils;

import lombok.val;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Flame on 2020/05/25.
 **/
@Slf4j
public class TimeUtils {

    public static String Format_Year  = "yyyy";
    public static String Format_Month = "yyyy-MM";
    public static String Format_Day   = "yyyy-MM-dd";
    public static String Format_Time  = "yyyy-MM-dd HH:mm:ss";
    public static String Format_Minute  = "yyyy-MM-dd HH:mm";
    public static String Format_Hour  = "yyyy-MM-dd HH";

    private static SimpleDateFormat getSimpleDateFormat() {
        return new SimpleDateFormat(Format_Time);
    }

    private static SimpleDateFormat getSimpleDateFormat(String format) {
        return new SimpleDateFormat(format, Locale.getDefault());
    }

    public static String getYearDate() {
        return getCurrentDate(Format_Year);
    }

    public static String getMonthDate() {
        return getCurrentDate(Format_Month);
    }

    public static String getDayDate() {
        return getCurrentDate(Format_Day);
    }

    public static String getTimeDate() {
        return getCurrentDate(Format_Time);
    }

    public static String getCurrentDate(String format) {
        return dateToString(new Date(), format);
    }

    public static String dateToString(Date date, String format) {
        return getSimpleDateFormat(format).format(date);
    }

    public static Date yearToData(String string) {
        return stringToDate(string, Format_Year);
    }

    public static Date monthToData(String string) {
        return stringToDate(string, Format_Month);
    }

    public static Date dayToData(String string) {
        return stringToDate(string, Format_Day);
    }

    public static Date timeToData(String string) {
        return stringToDate(string, Format_Time);
    }

    public static Date stringToDate(String dateString, String format) {
        Date date = null;
        try {
            date = getSimpleDateFormat(format).parse(dateString);
        } catch (Exception e) {
            log.error("stringToDate error: dateString({})、format({})", dateString, format);
        }
        return date;
    }

    /**
     * 将本地时间转换至指定时区时间
     */
    public static String getTimeZoneDate(String timeZone) {
        return getTimeZoneDate(new Date(), timeZone);
    }

    /**
     * 将时间转换至指定时区时间
     */
    public static String getTimeZoneDate(Date date, String timeZone) {
        SimpleDateFormat simpleDateFormat = getSimpleDateFormat();
        if (StringUtils.isEmpty(timeZone)) {
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
        } else {
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
        }
        return simpleDateFormat.format(date);
    }

    /**
     * 获取本地时间的星期几
     */
    public static String getDayOfWeek(String timeZone) {
        return getDayOfWeek(new Date(), timeZone);
    }

    /**
     * 获取时间的星期几
     */
    public static String getDayOfWeek(Date date, String timeZone) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (StringUtils.isEmpty(timeZone)) {
            calendar.setTimeZone(TimeZone.getDefault());
        } else {
            calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
        }
        int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day == 0) {
            day = 7;
        }
        return String.valueOf(day);
    }

    public static Date rollTime(Date date, int millisecond)  {
        Calendar calendar  = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.MILLISECOND, millisecond);
        return calendar.getTime();
    }
}
