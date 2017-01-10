package com.cardpay.basic.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * @author liduo
 */
public class DateTimeUtil {
    /**
     * 标准日期时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public static final String NORM_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    /**
     * 去分割日期时间格式(yyyyMMddHHmmss)
     */
    public static final String DIGIT_DATETIME_PATTERN = "yyyyMMddHHmmss";
    /**
     * 标准日期格式(yyyy-MM-dd)
     */
    public static final String NORM_DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 去分割日期格式(yyyyMMdd)
     */
    public static final String DIGIT_DATE_PATTERN = "yyyyMMdd";
    /**
     * 日期时间格式化器 ,格式 [yyyy-MM-dd HH:mm:ss]
     */
    private static ThreadLocal<SimpleDateFormat> normDatetimePatternFormat = new ThreadLocal<SimpleDateFormat>() {
        protected synchronized SimpleDateFormat initialValue() {
            return new SimpleDateFormat(NORM_DATETIME_PATTERN);
        }

        ;
    };
    /**
     * 日期时间格式化器 ,格式 [yyyyMMddHHmmss]
     */
    private static ThreadLocal<SimpleDateFormat> digitDatetimePatternFormat = new ThreadLocal<SimpleDateFormat>() {
        protected synchronized SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DIGIT_DATETIME_PATTERN);
        }

        ;
    };
    /**
     * 日期格式化器, 格式[yyyy-MM-dd]
     */
    private static ThreadLocal<SimpleDateFormat> normDatePatternFormat = new ThreadLocal<SimpleDateFormat>() {
        protected synchronized SimpleDateFormat initialValue() {
            return new SimpleDateFormat(NORM_DATE_PATTERN);
        }

        ;
    };
    /**
     * 日期格式化器, 格式[yyyyMMdd]
     */
    private static ThreadLocal<SimpleDateFormat> digitDatePatternFormat = new ThreadLocal<SimpleDateFormat>() {
        protected synchronized SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DIGIT_DATE_PATTERN);
        }

        ;
    };

    /**
     * 获取当前日期或时间
     *
     * @param format 日期格式,使用已有格式
     * @return 格式化后的日期字符串
     */
    public static String getNow(String format) {
        if (format.equals(NORM_DATETIME_PATTERN)) {
            return normDatetimePatternFormat.get().format(new Date());
        } else if (format.equals(DIGIT_DATETIME_PATTERN)) {
            return digitDatetimePatternFormat.get().format(new Date());
        } else if (format.equals(NORM_DATE_PATTERN)) {
            return normDatePatternFormat.get().format(new Date());
        } else if (format.equals(DIGIT_DATE_PATTERN)) {
            return digitDatePatternFormat.get().format(new Date());
        } else {
            return null;
        }
    }

    /**
     * 根据特定格式格式化日期
     *
     * @param date   日期对象
     * @param format 日期格式,使用已有格式
     * @return 格式化后的日期字符串
     */
    public static String format(Date date, String format) {
        // 如果默认date为
        if (date == null) {
            return null;
        }
        if (format.equals(NORM_DATETIME_PATTERN)) {
            return normDatetimePatternFormat.get().format(date);
        } else if (format.equals(DIGIT_DATETIME_PATTERN)) {
            return digitDatetimePatternFormat.get().format(date);
        } else if (format.equals(NORM_DATE_PATTERN)) {
            return normDatePatternFormat.get().format(date);
        } else if (format.equals(DIGIT_DATE_PATTERN)) {
            return digitDatePatternFormat.get().format(date);
        } else {
            return null;
        }
    }

    /**
     * 把字符串解析转化成一个日期
     * <p>
     * 注意传送的日期字符串要和日期格式对应例如：<br>
     * format("20141212",DateTimeUtil.DIGIT_DATE_PATTERN)
     *
     * @param strDate 日期字符串
     * @param format  日期格式
     * @return 返回日期Date对象
     * @throws ParseException 日期字符串和格式不对应，解析异常
     */
    public static Date format(String strDate, String format)
            throws ParseException {
        if (null == strDate || "".equals(strDate)) {
            return null;
        }
        if (format.equals(NORM_DATETIME_PATTERN)) {
            return normDatetimePatternFormat.get().parse(strDate);
        } else if (format.equals(DIGIT_DATETIME_PATTERN)) {
            return digitDatetimePatternFormat.get().parse(strDate);
        } else if (format.equals(NORM_DATE_PATTERN)) {
            return normDatePatternFormat.get().parse(strDate);
        } else if (format.equals(DIGIT_DATE_PATTERN)) {
            return digitDatePatternFormat.get().parse(strDate);
        } else {
            return null;
        }
    }

    /**
     * 将String型格式化,比如想要将2011-11-11格式化成2011年11月11日,就StringPattern("2011-11-11","yyyy-MM-dd","yyyy年MM月dd日").
     *
     * @param date       String 想要格式化的日期
     * @param oldPattern String 想要格式化的日期的现有格式
     * @param newPattern String 想要格式化成什么格式
     * @return String
     */
    public final static String stringPattern(String date, String oldPattern, String newPattern) {
        if (date == null || oldPattern == null || newPattern == null)
            return "";
        SimpleDateFormat sdf1 = new SimpleDateFormat(oldPattern);        // 实例化模板对象
        SimpleDateFormat sdf2 = new SimpleDateFormat(newPattern);        // 实例化模板对象
        Date d = null;
        try {
            d = sdf1.parse(date);   // 将给定的字符串中的日期提取出来
        } catch (Exception e) {            // 如果提供的字符串格式有错误，则进行异常处理
            e.printStackTrace();       // 打印异常信息
        }
        return sdf2.format(d);
    }

    public static void main(String[] args) {
        System.out.println(stringPattern("20151225", DIGIT_DATE_PATTERN, NORM_DATE_PATTERN));
    }
}
