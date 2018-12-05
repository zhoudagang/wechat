/**
 * DateStyle.java
 * Created at 2015-03-26
 * Created by rick
 * Copyright (C) 2015 CLY, All rights reserved.
 */
package what.fuck.util;

/**
 * <p>ClassName: DateStyle</p>
 * <p>Description: 日期格式</p>
 * <p>Author: rick</p>
 * <p>Date: 2015-03-26</p>
 */
public enum DateStyle {
    /**
     * <p>Field H_DATETIME_12: 12小时制 yyyy-MM-dd hh:mm:ss</p>
     */
    H_DATETIME_12("yyyy-MM-dd hh:mm:ss"),
    /**
     * <p>Field S_DATETIME_12: 12小时制 yyyy/MM/dd hh:mm:ss</p>
     */
    S_DATETIME_12("yyyy/MM/dd hh:mm:ss"),
    /**
     * <p>Field H_DATETIME_24: 24小时制 yyyy-MM-dd HH:mm:ss</p>
     */
    H_DATETIME_24("yyyy-MM-dd HH:mm:ss"),
    /**
     * <p>Field S_DATETIME_24: 24小时制 yyyy/MM/dd HH:mm:ss</p>
     */
    S_DATETIME_24("yyyy/MM/dd HH:mm:ss"),
    /**
     * <p>Field H_DATE: yyyy-MM-dd</p>
     */
    H_DATE("yyyy-MM-dd"),
    /**
     * <p>Field S_DATE: yyyy/MM/dd</p>
     */
    S_DATE("yyyy/MM/dd"),
    /**
     * <p>Field S_M_DATE: MM/dd/yyyy</p>
     */
    S_M_DATE("MM/dd/yyyy"),
    /**
     * <p>Field DATE_ALL: 年月日时分秒毫秒yyyyMMddHHmmssSSS</p>
     */
    DATE_ALL("yyyyMMddHHmmssSSS"),
    /**
     * <p>Field DATE_DAY: 年月日yyyyMMdd</p>
     */
    DATE_DAY("yyyyMMdd"),
    /**
     * <p>Field TIME_12: 12小时制时分秒hh:mm:ss</p>
     */
    TIME_12("hh:mm:ss"),
    /**
     * <p>Field TIME_24: 24小时制时分秒HH:mm:ss</p>
     */
    TIME_24("HH:mm:ss");

    /**
     * <p>Field value: 格式</p>
     */
    private String value;

    /**
     * <p>Description: 有参构造方法</p>
     * @param value 格式
     */
    DateStyle(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
