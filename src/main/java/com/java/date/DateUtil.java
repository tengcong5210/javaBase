package com.java.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.commons.lang.time.DateUtils;

/**
 * Date utils
 */
public abstract class DateUtil {

    /**
     * 日期精度，秒
     */
    public static final int    ACCURACY_SECOND          = 1;

    /**
     * 日期精度，分
     */
    public static final int    ACCURACY_MINUTE          = 2;

    /**
     * 日期精度，小时
     */
    public static final int    ACCURACY_HOUR            = 3;

    /**
     * 日期精度，天
     */
    public static final int    ACCURACY_DAY             = 4;

    /**
     * 日期精度，月
     */
    public static final int    ACCURACY_MONTH           = 5;

    /**
     * 日期精度，年
     */
    public static final int    ACCURACY_YEAR            = 6;
    public static final String EN_GB_DATE_PATTERN       = "dd/MM/yyyy";

    private static String      EN_GB_DATETIME_PATTERN   = "dd/MM/yyyy HH:mm:ss";

    public static String       ZH_CN_DATE_PATTERN       = "yyyy-MM-dd";

    public static String       ZH_CN_DATETIME_PATTERN   = "yyyy-MM-dd HH:mm:ss";

    public static String       NOMARK_DATETIME_PATTERN  = "yyyyMMddHHmmss";
    public static String       WITHOUTTIME_DATE_PATTERN = "yyyyMMdd";

    private static final long  MILLISECONDS_PER_SECOND  = 1000;

    /**
     * 
     */
    private static final long  MILLISECONDS_PER_MINUTE  = 1000 * 60;

    /**
     * 
     */
    private static final long  MILLISECONDS_PER_HOUR    = 1000 * 60 * 60;

    /**
     * 
     */
    private static final long  MILLISECONDS_PER_DAY     = 1000 * 60 * 60 * 24;

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
            return null;
        }
    }

    /**
     * Format a datetime into a specific pattern.
     */
    public static String formatDate(Date date, String pattern) {
        pattern = ZH_CN_DATETIME_PATTERN;
        DateFormat formatter = createFormatter(pattern);
        return formatter.format(date);
    }

    public static String formatDateDefault(Date date) {
        return formatDate(date, ZH_CN_DATETIME_PATTERN);
    }

    public static String formatDate(Date date, DateFormat formatter) {
        return formatter.format(date);
    }

    /**
     * Adds a number of days to a date returning a new date.
     */
    public static Date dayEnd(Date date) {
        Calendar calendar = dateToCalendar(date);
        adjustCalendar(calendar, Calendar.DAY_OF_MONTH, 1);
        adjustCalendar(calendar, Calendar.SECOND, -1);
        return calendarToDate(calendar);
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

    public static Date transDateFormat(Date date, String pattern) {
        String dateStr = getDateStr(date, pattern);
        return parseDate(dateStr, pattern);
    }

    public static Date parseDate(String dateStr, String parsePattern) {
        Date date = null;
        try {
            date = org.apache.commons.lang.time.DateUtils.parseDate(dateStr, new String[] { parsePattern.toString() });
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 计算两个日期间差值
     * 
     * @param a 日期1
     * @param b 日期2
     * @param unit 差值单位 a=2014-04-04, b=2014-04-04 则return 1 a=2014-04-04,
     *            b=2014-04-03 则return 0 a=2014-04-04, b=2014-03-03 则return 1
     *            a=2014-04-04, b=2014-03-05 则return 0
     * @return
     */
    public static int getDateDistance(Date a, Date b, int unit) {
        int result = 0;
        if (null != a && null != b) {
            String pattern = null;
            switch (unit) {
                case ACCURACY_HOUR: // '\003'
                    pattern = "yyyyMMddHH";
                    break;
                case ACCURACY_MINUTE: // '\002'
                    pattern = "yyyyMMddHHmm";
                    break;
                case ACCURACY_SECOND: // '\001'
                    pattern = "yyyyMMddHHmmss";
                    break;
                default:
                    pattern = "yyyyMMdd";
            }
            Date startDate = transDateFormat(1 != a.compareTo(b) ? a : b, pattern);
            Date endDate = transDateFormat(1 != a.compareTo(b) ? b : a, pattern);
            if (1 <= unit && 4 >= unit) {
                result = getDistanceByUnit(startDate, endDate, unit);
                return result;
            }
            GregorianCalendar startCalendar = new GregorianCalendar();
            startCalendar.setTime(startDate);
            int startYears = startCalendar.get(Calendar.YEAR);
            int startMonths = startCalendar.get(Calendar.MONTH);
            int startDays = startCalendar.get(Calendar.DAY_OF_MONTH);

            GregorianCalendar endCalendar = new GregorianCalendar();
            endCalendar.setTime(endDate);
            int endYears = endCalendar.get(Calendar.YEAR);
            int endMonths = endCalendar.get(Calendar.MONTH);
            int endDays = endCalendar.get(Calendar.DAY_OF_MONTH);

            int yearBetween = endYears - startYears;
            int monthBetween = endMonths - startMonths;
            if (endDays < startDays && endDays != endCalendar.getActualMaximum(Calendar.DATE)) {
                monthBetween--;
            }
            if (ACCURACY_YEAR == unit) {
                if (monthBetween < 0) {
                    yearBetween--;
                }
                result = yearBetween;
            }
            if (ACCURACY_MONTH == unit) {
                result = (yearBetween * 12 + monthBetween);
            }
        }
        return result;

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

    public static String getCNDateStr(Date date) {
        GregorianCalendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(date);
        return startCalendar.get(Calendar.YEAR) + "年" + (startCalendar.get(Calendar.MONTH) + 1) + "月"
                + startCalendar.get(Calendar.DAY_OF_MONTH) + "日";
    }

    public static Date parseDate(String dateStr) {
        try {
            if (dateStr.length() == 8) {
                return DateUtils.parseDate(dateStr, new String[] { "yyyyMMdd" });
            } else {
                return DateUtils.parseDate(dateStr, new String[] { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss",
                        "yyyyMMddHHmmss", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss" });

            }
        } catch (ParseException e) {
            return null;
        }

    }

    /**
     * 获取年份
     * 
     * @return
     */
    public static Integer getYear(Date date) {
        Calendar ca = Calendar.getInstance();
        if (date != null) {
            ca.setTime(date);
        }
        return ca.get(ca.YEAR);
    }
}
