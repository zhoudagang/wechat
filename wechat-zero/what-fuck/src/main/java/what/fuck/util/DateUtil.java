package what.fuck.util;


/**
 * DateUtil.java
 * Created at 2015-03-26
 * Created by rick
 * Copyright (C) 2015 CLY, All rights reserved.
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * <p>ClassName: DateUtil</p>
 * <p>Description: 日期工具类</p>
 * <p>Author: rick</p>
 * <p>Date: 2015-03-26</p>
 */
public class DateUtil {
    /**
     * <p>Field GMT: 默认时区</p>
     */
    public static final TimeZone GMT = TimeZone.getTimeZone("GMT+8");

    /**
     * <p>Description: 获取日期的年份，失败返回0</p>
     * @param date 日期字符串
     * @return 年份
     */
    public static int getYear(String date) {
        return getYear(stringToDate(date));
    }

    /**
     * <p>Description: 获取日期的年份，失败返回0</p>
     * @param date 日期
     * @return 年份
     */
    public static int getYear(Date date) {
        return getInteger(date, Calendar.YEAR);
    }

    /**
     * <p>Description: 获取日期的月份，失败返回0</p>
     * @param date 日期字符串
     * @return 月份
     */
    public static int getMonth(String date) {
        return getMonth(stringToDate(date));
    }

    /**
     * <p>Description: 获取日期的月份，失败返回0</p>
     * @param date 日期
     * @return 月份
     */
    public static int getMonth(Date date) {
        return getInteger(date, Calendar.MONTH);
    }

    /**
     * <p>Description: 获取日期的天数，失败返回0</p>
     * @param date 日期字符串
     * @return 天
     */
    public static int getDay(String date) {
        return getDay(stringToDate(date));
    }

    /**
     * <p>Description: 获取日期的天数，失败返回0</p>
     * @param date 日期
     * @return 天
     */
    public static int getDay(Date date) {
        return getInteger(date, Calendar.DATE);
    }

    /**
     * <p>Description: 获取日期的小时，失败返回0</p>
     * @param date 日期字符串
     * @return 小时
     */
    public static int getHour(String date) {
        return getHour(stringToDate(date));
    }

    /**
     * <p>Description: 获取日期的小时，失败返回0</p>
     * @param date 日期
     * @return 小时
     */
    public static int getHour(Date date) {
        return getInteger(date, Calendar.HOUR_OF_DAY);
    }

    /**
     * <p>Description: 获取日期的分钟，失败返回0</p>
     * @param date 日期字符串
     * @return 分钟
     */
    public static int getMinute(String date) {
        return getMinute(stringToDate(date));
    }

    /**
     * <p>Description: 获取日期的分钟，失败返回0</p>
     * @param date 日期
     * @return 分钟
     */
    public static int getMinute(Date date) {
        return getInteger(date, Calendar.MINUTE);
    }

    /**
     * <p>Description: 获取日期的秒钟，失败返回0</p>
     * @param date 日期字符串
     * @return 秒钟
     */
    public static int getSecond(String date) {
        return getSecond(stringToDate(date));
    }

    /**
     * <p>Description: 获取日期的秒钟，失败返回0</p>
     * @param date 日期
     * @return 秒钟
     */
    public static int getSecond(Date date) {
        return getInteger(date, Calendar.SECOND);
    }

    /**
     * <p>Description: 获取日期 ，默认yyyy-MM-dd格式，失败返回null</p>
     * @param date 日期字符串
     * @return 日期
     */
    public static String getDate(String date) {
        return stringToString(date, DateStyle.H_DATE);
    }

    /**
     * <p>Description: 获取日期 ，默认yyyy-MM-dd格式，失败返回null</p>
     * @param date 日期
     * @return 日期
     */
    public static String getDate(Date date) {
        return dateToString(date, DateStyle.H_DATE);
    }

    /**
     * <p>Description: 获取日期的时间，默认HH:mm:ss格式，失败返回null</p>
     * @param date 日期字符串
     * @return 时间
     */
    public static String getTime(String date) {
        return stringToString(date, DateStyle.TIME_24);
    }

    /**
     * <p>Description: 获取日期的时间，默认HH:mm:ss格式，失败返回null</p>
     * @param date 日期
     * @return 时间
     */
    public static String getTime(Date date) {
        return dateToString(date, DateStyle.TIME_24);
    }

    /**
     * <p>Description: 获取日期的星期，失败返回null</p>
     * @param date 日期字符串
     * @return 星期
     */
    public static DateWeek getWeek(String date) {
        DateWeek week = null;
        DateStyle dateStyle = getDateStyle(date);
        if (dateStyle != null) {
            Date myDate = stringToDate(date, dateStyle);
            week = getWeek(myDate);
        }
        return week;
    }

    /**
     * <p>Description: 获取日期的星期，失败返回null</p>
     * @param date 日期
     * @return 星期
     */
    public static DateWeek getWeek(Date date) {
        DateWeek week = null;
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        int weekNumber = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        switch (weekNumber) {
            case 0:
                week = DateWeek.SUNDAY;
                break;
            case 1:
                week = DateWeek.MONDAY;
                break;
            case 2:
                week = DateWeek.TUESDAY;
                break;
            case 3:
                week = DateWeek.WEDNESDAY;
                break;
            case 4:
                week = DateWeek.THURSDAY;
                break;
            case 5:
                week = DateWeek.FRIDAY;
                break;
            case 6:
                week = DateWeek.SATURDAY;
                break;
            default:
                break;
        }
        return week;
    }

    /**
     * <p>Description: 获取日期中的某数值，如获取月份</p>
     * @param date 日期
     * @param dateType 日期格式
     * @return 数值
     */
    public static int getInteger(Date date, int dateType) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        return calendar.get(dateType);
    }

    /**
     * <p>Description: 获取两个日期相差的天数</p>
     * @param date 日期字符串
     * @param otherDate 另一个日期字符串
     * @return 相差天数
     */
    public static int getIntervalDays(String date, String otherDate) {
        return getIntervalDays(stringToDate(date, DateStyle.H_DATETIME_24),
                stringToDate(otherDate, DateStyle.H_DATETIME_24));
    }

    /**
     * <p>Description: 获取两个日期相差的分钟</p>
     * @param date 日期字符串
     * @param otherDate 另一个日期字符串
     * @return 相差分钟
     */
    public static int getIntervalMinute(String date, String otherDate) {
        return getIntervalMinute(stringToDate(date, DateStyle.H_DATETIME_24),
                stringToDate(otherDate, DateStyle.H_DATETIME_24));
    }

    /**
     * <p>Description: 获取两个日期相差的天数</p>
     * @param date 日期
     * @param otherDate 另一个日期
     * @return 相差天数
     */
    public static int getIntervalDays(Date date, Date otherDate) {
        // 毫秒/24小时/60分/60秒/1000毫秒 得到天数
        Long result = date.getTime() / 24 / 60 / 60 / 1000 - otherDate.getTime() / 24 / 60 / 60 / 1000;
        return result.intValue();
    }

    /**
     * <p>Description: 获取两个日期相差的分钟</p>
     * @param date 日期
     * @param otherDate 另一个日期
     * @return 相差分钟
     */
    public static int getIntervalMinute(Date date, Date otherDate) {
        // 毫秒/24小时/60分/60秒/1000毫秒 得到天数
        Long result = date.getTime() / 60 / 1000 - otherDate.getTime() / 60 / 1000;
        return result.intValue();
    }

    /**
     * <p>Description: 获取当前时间</p>
     * @return 字符串时间
     */
    public static String getCurrentDate() {
        return dateToString(getDefaultDate(), DateStyle.H_DATETIME_24);
    }

    /**
     * <p>Description: 获取当前时间</p>
     * @param dateStyle 时间样式
     * @return 时间
     */
    public static String getCurrentDate(DateStyle dateStyle) {
        return dateToString(getDefaultDate(), dateStyle);
    }

    /**
     * <p>Description: 获取当前时间</p>
     * @param format 时间格式
     * @return 时间
     */
    public static String getCurrentDate(String format) {
        return dateToString(getDefaultDate(), format);
    }

    /**
     * <p>Description: 获取当前日期</p>
     * @return 日期
     */
    public static Date getDefaultDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(GMT);
        return calendar.getTime();
    }

    /**
     * <p>Description: 获取精确的日期</p>
     * @param timestamps 时间long集合
     * @return 日期
     */
    public static Date getAccurateDate(List<Long> timestamps) {
        Date date = null;
        long timestamp = 0;
        Map<Long, long[]> map = new HashMap<Long, long[]>();
        List<Long> absoluteValues = new ArrayList<Long>();
    
        if (timestamps != null && timestamps.size() > 0) {
            if (timestamps.size() > 1) {
                for (int i = 0; i < timestamps.size(); i++) {
                    for (int j = i + 1; j < timestamps.size(); j++) {
                        long absoluteValue = Math.abs(timestamps.get(i) - timestamps.get(j));
                        absoluteValues.add(absoluteValue);
                        long[] timestampTmp = { timestamps.get(i), timestamps.get(j) };
                        map.put(absoluteValue, timestampTmp);
                    }
                }
    
                // 有可能有相等的情况，如2012-11和2012-11-01，时间戳是相等的
                long minAbsoluteValue = -1;
                if (!absoluteValues.isEmpty()) {
                    // 如果timestamps的size为2，这是差值只有一个，因此要给默认值
                    minAbsoluteValue = absoluteValues.get(0);
                }
                for (int i = 0; i < absoluteValues.size(); i++) {
                    for (int j = i + 1; j < absoluteValues.size(); j++) {
                        if (absoluteValues.get(i) > absoluteValues.get(j)) {
                            minAbsoluteValue = absoluteValues.get(j);
                        } else {
                            minAbsoluteValue = absoluteValues.get(i);
                        }
                    }
                }
    
                if (minAbsoluteValue != -1) {
                    long[] timestampsLastTmp = map.get(minAbsoluteValue);
                    if (absoluteValues.size() > 1) {
                        timestamp = Math.max(timestampsLastTmp[0], timestampsLastTmp[1]);
                    } else if (absoluteValues.size() == 1) {
                        // 当timestamps的size为2，需要与当前时间作为参照
                        long dateOne = timestampsLastTmp[0];
                        long dateTwo = timestampsLastTmp[1];
                        if ((Math.abs(dateOne - dateTwo)) < 100000000000L) {
                            timestamp = Math.max(timestampsLastTmp[0], timestampsLastTmp[1]);
                        } else {
                            long now = getDefaultDate().getTime();
                            if (Math.abs(dateOne - now) <= Math.abs(dateTwo - now)) {
                                timestamp = dateOne;
                            } else {
                                timestamp = dateTwo;
                            }
                        }
                    }
                }
            } else {
                timestamp = timestamps.get(0);
            }
        }
    
        if (timestamp != 0) {
            date = new Date(timestamp);
        }
        return date;
    }

    /**
     * <p>Description: 获取日历对象</p>
     * @return 日历对象
     */
    public static Calendar getCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(GMT);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    /**
     * <p>Description: 获取日期字符串的日期风格，失敗返回null</p>
     * @param date 日期字符串
     * @return 日期风格
     */
    public static DateStyle getDateStyle(String date) {
        DateStyle dateStyle = null;
        Map<Long, DateStyle> map = new HashMap<Long, DateStyle>();
        List<Long> timestamps = new ArrayList<Long>();
        for (DateStyle style : DateStyle.values()) {
            Date dateTmp = stringToDate(date, style.getValue());
            if (dateTmp != null) {
                timestamps.add(dateTmp.getTime());
                map.put(dateTmp.getTime(), style);
            }
        }
        dateStyle = map.get(getAccurateDate(timestamps).getTime());
        return dateStyle;
    }

    /**
     * <p>Description: 获取SimpleDateFormat</p>
     * @param parttern 日期格式
     * @return SimpleDateFormat对象
     */
    public static SimpleDateFormat getDateFormat(String parttern) {
        return new SimpleDateFormat(parttern);
    }

    /**
     * <p>Description: 将日期字符串转化为日期，失败返回null</p>
     * @param date 日期字符串
     * @return 日期
     */
    public static Date stringToDate(String date) {
        DateStyle dateStyle = null;
        return stringToDate(date, dateStyle);
    }

    /**
     * <p>Description: 将日期字符串转化为日期，失败返回null</p>
     * @param date 日期字符串
     * @param parttern 日期格式
     * @return 日期
     */
    public static Date stringToDate(String date, String parttern) {
        Date myDate = null;
        if (date != null) {
            try {
                myDate = getDateFormat(parttern).parse(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return myDate;
    }

    /**
     * <p>Description: 将日期字符串转化为日期，失败返回null</p>
     * @param date 日期字符串
     * @param dateStyle 日期风格
     * @return 日期
     */
    public static Date stringToDate(String date, DateStyle dateStyle) {
        Date myDate = null;
        if (dateStyle == null) {
            List<Long> timestamps = new ArrayList<Long>();
            for (DateStyle style : DateStyle.values()) {
                Date dateTmp = stringToDate(date, style.getValue());
                if (dateTmp != null) {
                    timestamps.add(dateTmp.getTime());
                }
            }
            myDate = getAccurateDate(timestamps);
        } else {
            myDate = stringToDate(date, dateStyle.getValue());
        }
        return myDate;
    }

    /**
     * <p>Description: 将日期字符串转化为另一日期字符串，失败返回null</p>
     * @param date 旧日期字符串
     * @param parttern 新日期格式
     * @return 新日期字符串
     */
    public static String stringToString(String date, String parttern) {
        return stringToString(date, null, parttern);
    }

    /**
     * <p>Description: 将日期字符串转化为另一日期字符串，失败返回null</p>
     * @param date 旧日期字符串
     * @param dateStyle 新日期风格
     * @return 新日期字符串
     */
    public static String stringToString(String date, DateStyle dateStyle) {
        return stringToString(date, null, dateStyle);
    }

    /**
     * <p>Description: 将日期字符串转化为另一日期字符串，失败返回null</p>
     * @param date 旧日期字符串
     * @param oldParttern 旧日期格式
     * @param newParttern 新日期格式
     * @return 新日期字符串
     */
    public static String stringToString(String date, String oldParttern, String newParttern) {
        String dateString = null;
        if (oldParttern == null) {
            DateStyle style = getDateStyle(date);
            if (style != null) {
                Date myDate = stringToDate(date, style.getValue());
                dateString = dateToString(myDate, newParttern);
            }
        } else {
            Date myDate = stringToDate(date, oldParttern);
            dateString = dateToString(myDate, newParttern);
        }
        return dateString;
    }

    /**
     * <p>Description: 将日期字符串转化为另一日期字符串，失败返回null</p>
     * @param date 旧日期字符串
     * @param oldDteStyle 旧日期风格
     * @param newDateStyle 新日期风格
     * @return 新日期字符串
     */
    public static String stringToString(String date, DateStyle oldDteStyle, DateStyle newDateStyle) {
        String dateString = null;
        if (oldDteStyle == null) {
            DateStyle style = getDateStyle(date);
            dateString = stringToString(date, style.getValue(), newDateStyle.getValue());
        } else {
            dateString = stringToString(date, oldDteStyle.getValue(), newDateStyle.getValue());
        }
        return dateString;
    }

    /**
     * <p>Description: 将日期转化为日期字符串，失败返回null</p>
     * @param date 日期
     * @param parttern 日期格式
     * @return 日期字符串
     */
    public static String dateToString(Date date, String parttern) {
        String dateString = null;
        if (date != null) {
            try {
                dateString = getDateFormat(parttern).format(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dateString;
    }

    /**
     * <p>Description: 将日期转化为日期字符串，失败返回null</p>
     * @param date 日期
     * @param dateStyle 日期风格
     * @return 日期字符串
     */
    public static String dateToString(Date date, DateStyle dateStyle) {
        String dateString = null;
        if (dateStyle != null) {
            dateString = dateToString(date, dateStyle.getValue());
        }
        return dateString;
    }

    /**
     * <p>Description: 增加日期的年份，失败返回null</p>
     * @param date 日期字符串
     * @param yearAmount 增加数量，可为负数
     * @return 增加年份后的日期字符串
     */
    public static String addYear(String date, int yearAmount) {
        return addInteger(date, Calendar.YEAR, yearAmount);
    }

    /**
     * <p>Description: 增加日期的年份，失败返回null</p>
     * @param date 日期
     * @param yearAmount 增加数量，可为负数
     * @return 增加年份后的日期
     */
    public static Date addYear(Date date, int yearAmount) {
        return addInteger(date, Calendar.YEAR, yearAmount);
    }

    /**
     * <p>Description: 增加日期的月份，失败返回null</p>
     * @param date 日期
     * @param yearAmount 增加数量，可为负数
     * @return 增加月份后的日期字符串
     */
    public static String addMonth(String date, int yearAmount) {
        return addInteger(date, Calendar.MONTH, yearAmount);
    }

    /**
     * <p>Description: 增加日期的月份，失败返回null</p>
     * @param date 日期
     * @param yearAmount 增加数量，可为负数
     * @return 增加月份后的日期
     */
    public static Date addMonth(Date date, int yearAmount) {
        return addInteger(date, Calendar.MONTH, yearAmount);
    }

    /**
     * <p>Description: 增加日期的天数，失败返回null</p>
     * @param date 日期字符串
     * @param dayAmount 增加数量，可为负数
     * @return 增加天数后的日期字符串
     */
    public static String addDay(String date, int dayAmount) {
        return addInteger(date, Calendar.DATE, dayAmount);
    }

    /**
     * <p>Description: 增加日期的天数，失败返回null</p>
     * @param date 日期
     * @param dayAmount 增加数量，可为负数
     * @return 增加天数后的日期
     */
    public static Date addDay(Date date, int dayAmount) {
        return addInteger(date, Calendar.DATE, dayAmount);
    }

    /**
     * <p>Description: 增加日期的小时，失败返回null</p>
     * @param date 日期字符串
     * @param hourAmount 增加数量，可为负数
     * @return 增加小时后的日期字符串
     */
    public static String addHour(String date, int hourAmount) {
        return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);
    }

    /**
     * <p>Description: 增加日期的小时，失败返回null</p>
     * @param date 日期
     * @param hourAmount 增加数量，可为负数
     * @return 增加小时后的日期
     */
    public static Date addHour(Date date, int hourAmount) {
        return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);
    }

    /**
     * <p>Description: 增加日期的分钟，失败返回null</p>
     * @param date 日期字符串
     * @param hourAmount 增加数量，可为负数
     * @return 增加分钟后的日期字符串
     */
    public static String addMinute(String date, int hourAmount) {
        return addInteger(date, Calendar.MINUTE, hourAmount);
    }

    /**
     * <p>Description: 增加日期的分钟，失败返回null</p>
     * @param date 日期
     * @param hourAmount 增加数量，可为负数
     * @return 增加分钟后的日期
     */
    public static Date addMinute(Date date, int hourAmount) {
        return addInteger(date, Calendar.MINUTE, hourAmount);
    }

    /**
     * <p>Description: 增加日期的秒钟，失败返回null</p>
     * @param date 日期字符串
     * @param hourAmount 增加数量，可为负数
     * @return 增加秒钟后的日期字符串
     */
    public static String addSecond(String date, int hourAmount) {
        return addInteger(date, Calendar.SECOND, hourAmount);
    }

    /**
     * <p>Description: 增加日期的秒钟，失败返回null</p>
     * @param date 日期
     * @param hourAmount 增加数量，可为负数
     * @return 增加秒钟后的日期
     */
    public static Date addSecond(Date date, int hourAmount) {
        return addInteger(date, Calendar.SECOND, hourAmount);
    }

    /**
     * <p>Description: 增加日期中某类型的某数值，如增加日期</p>
     * @param date 日期字符串
     * @param dateType 类型
     * @param amount 数值
     * @return 计算后日期字符串
     */
    public static String addInteger(String date, int dateType, int amount) {
        String dateString = null;
        DateStyle dateStyle = getDateStyle(date);
        if (dateStyle != null) {
            Date myDate = stringToDate(date, dateStyle);
            myDate = addInteger(myDate, dateType, amount);
            dateString = dateToString(myDate, dateStyle);
        }
        return dateString;
    }

    /**
     * <p>Description: 增加日期中某类型的某数值，如增加日期</p>
     * @param date 日期
     * @param dateType 类型
     * @param amount 数值
     * @return 计算后日期
     */
    public static Date addInteger(Date date, int dateType, int amount) {
        Date myDate = null;
        if (date != null) {
            Calendar calendar = getCalendar();
            calendar.setTime(date);
            calendar.add(dateType, amount);
            myDate = calendar.getTime();
        }
        return myDate;
    }

    /**
     * <p>Description: 判断字符串是否为日期字符串</p>
     * @param date 日期字符串
     * @return true or false
     */
    public static boolean isDate(String date) {
        boolean isDate = false;
        if (date != null) {
            if (stringToDate(date) != null) {
                isDate = true;
            }
        }
        return isDate;
    }
}
