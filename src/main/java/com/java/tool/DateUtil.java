package com.java.tool;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Date utils
 */
public abstract class DateUtil {

    /**
     * 日期精度，秒
     */
    public static final int    ACCURACY_SECOND         = 1;

    /**
     * 日期精度，分
     */
    public static final int    ACCURACY_MINUTE         = 2;

    /**
     * 日期精度，小时
     */
    public static final int    ACCURACY_HOUR           = 3;

    /**
     * 日期精度，天
     */
    public static final int    ACCURACY_DAY            = 4;

    /**
     * 日期精度，月
     */
    public static final int    ACCURACY_MONTH          = 5;

    /**
     * 日期精度，年
     */
    public static final int    ACCURACY_YEAR           = 6;
    public static final String EN_GB_DATE_PATTERN      = "dd/MM/yyyy";

    private static String      EN_GB_DATETIME_PATTERN  = "dd/MM/yyyy HH:mm:ss";

    public static String       ZH_CN_DATE_PATTERN      = "yyyy-MM-dd";

    public static String       ZH_CN_DATETIME_PATTERN  = "yyyy-MM-dd HH:mm:ss";

    public static String       NOMARK_DATETIME_PATTERN = "yyyyMMddHHmmss";
    private static final long  MILLISECONDS_PER_SECOND = 1000;

    /**
     * 
     */
    private static final long  MILLISECONDS_PER_MINUTE = 1000 * 60;

    /**
     * 
     */
    private static final long  MILLISECONDS_PER_HOUR   = 1000 * 60 * 60;

    /**
     * 
     */
    private static final long  MILLISECONDS_PER_DAY    = 1000 * 60 * 60 * 24;

    /**
     * Parse date string to uk date format
     */
    public static Date parseEnDateTimeString(String dateString) {
        return parseDateString(dateString, EN_GB_DATETIME_PATTERN);
    }

    public static Date parseZhDateTimeString(String dateString) {
        return parseDateString(dateString, ZH_CN_DATETIME_PATTERN);
    }

    public static Date parseEnDateString(String dateString) {
        return parseDateString(dateString, EN_GB_DATE_PATTERN);
    }

    public static Date parseZhDateString(String dateString) {
        return parseDateString(dateString, ZH_CN_DATE_PATTERN);
    }

    /**
     * main
     * 
     * @param args
     */
    public static void main(String[] args) {
        //        parseZhDateTimeString("20150120175300");
        try {
            testDate("20150120175300");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void testDate(String d) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        //        Date date = new Date();
        System.out.println(sdf.parse(d));
    }

    public static String formaEnDateTime(Object value) {
        return formatDateTime(value, EN_GB_DATETIME_PATTERN);
    }

    public static String formaEnDate(Object value) {
        return formatDateTime(value, EN_GB_DATE_PATTERN);
    }

    public static String formaZhDateTime(Object value) {
        return formatDateTime(value, ZH_CN_DATETIME_PATTERN);
    }

    public static String formaZhDate(Object value) {
        return formatDateTime(value, ZH_CN_DATE_PATTERN);
    }

    public static String formatDateTime(Object value, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        if (value == null) {
            return "";
        } else if (value instanceof String) {
            java.util.Date date = new java.util.Date();
            try {
                if (null != value) {
                    date = dateFormat.parse(String.valueOf(value));
                }
            } catch (ParseException e) {
                return "";
            }
            return dateFormat.format(date);
        } else if (value instanceof java.util.Date) {
            return dateFormat.format(value);
        } else {
            return "";
        }
    }

    /**
     * Parse date string to date format
     */
    public static Date parseDateString(String dateString, String pattern) {
        pattern = ZH_CN_DATETIME_PATTERN;
        DateFormat formatter = createFormatter(pattern);
        try {
            return formatter.parse(dateString);
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 调整日期的时间 按照天数
     * 
     * @param date
     * @param amount
     * @return
     */

    public static Date adjustDay(Date date, int amount) {

        Calendar calendar = dateToCalendar(date);
        adjustCalendar(calendar, Calendar.DAY_OF_MONTH, amount);
        return calendarToDate(calendar);

    }

    public static Date adjustMonth(Date date, int amount) {
        Calendar calendar = dateToCalendar(date);
        adjustCalendar(calendar, Calendar.MONTH, amount);
        return calendarToDate(calendar);
    }

    public static Date adjustYear(Date date, int amount) {
        Calendar calendar = dateToCalendar(date);
        adjustCalendar(calendar, Calendar.YEAR, amount);
        return calendarToDate(calendar);
    }

    public static Calendar dateToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date calendarToDate(Calendar calendar) {
        return calendar.getTime();
    }

    public static void adjustCalendar(Calendar calendar, int field, int amount) {
        calendar.add(field, amount);
    }

    public static DateFormat createFormatter(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    public static DateFormat createDateFormatter(Locale locale) {
        return DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
    }

    public static DateFormat createTimeFormatter(Locale locale) {
        return DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
    }

    public static DateFormat createDateTimeFormatter(Locale locale) {
        return DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, locale);
    }

    public static Date getDateWithoutTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static Date getDateWithoutTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    /**
     * 根据指定格式，返回日期时间字符串
     * 
     * @param date 日期变量
     * @param pattern
     * @return 日期时间字符串
     */
    public static String getDateStr(Date date, String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    private static int getDistanceByUnit(Date startDate, Date endDate, int unit) {
        int result = 0;
        long millisecondPerUnit = MILLISECONDS_PER_DAY;
        switch (unit) {
            case ACCURACY_HOUR:
                millisecondPerUnit = MILLISECONDS_PER_HOUR;
                break;
            case ACCURACY_MINUTE:
                millisecondPerUnit = MILLISECONDS_PER_MINUTE;
                break;
            case ACCURACY_SECOND:
                millisecondPerUnit = MILLISECONDS_PER_SECOND;
                break;
            default:
                break;
        }
        long start = startDate.getTime();
        long end = endDate.getTime();
        long distance = end - start;
        result = Integer.valueOf((distance / millisecondPerUnit) + "");
        return result;
    }
}
