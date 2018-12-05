/**
 * DateWeek.java
 * Created at 2015-03-26
 * Created by rick
 * Copyright (C) 2015 CLY, All rights reserved.
 */
package what.fuck.util;

/**
 * <p>ClassName: DateWeek</p>
 * <p>Description: 星期定义</p>
 * <p>Author: rick</p>
 * <p>Date: 2015-03-26</p>
 */
public enum DateWeek {
    /**
     * <p>Field MONDAY: 星期一</p>
     */
    MONDAY("星期一", "Monday", "Mon.", 1),
    /**
     * <p>Field TUESDAY: 星期二</p>
     */
    TUESDAY("星期二", "Tuesday", "Tues.", 2),
    /**
     * <p>Field WEDNESDAY: 星期三</p>
     */
    WEDNESDAY("星期三", "Wednesday", "Wed.", 3),
    /**
     * <p>Field THURSDAY: 星期四</p>
     */
    THURSDAY("星期四", "Thursday", "Thur.", 4),
    /**
     * <p>Field FRIDAY: 星期五</p>
     */
    FRIDAY("星期五", "Friday", "Fri.", 5),
    /**
     * <p>Field SATURDAY: 星期六</p>
     */
    SATURDAY("星期六", "Saturday", "Sat.", 6),
    /**
     * <p>Field SUNDAY: 星期日</p>
     */
    SUNDAY("星期日", "Sunday", "Sun.", 7);

    /**
     * <p>Field nameCn: 星期中文描述</p>
     */
    private String nameCn;
    /**
     * <p>Field nameEn: 星期英文描述</p>
     */
    private String nameEn;
    /**
     * <p>Field nameEnShort: 星期英文缩写描述</p>
     */
    private String nameEnShort;
    /**
     * <p>Field number: 星期</p>
     */
    private int number;

    /**
     * <p>Description: 有参构造方法</p>
     * @param nameCn 星期中文描述
     * @param nameEn 星期英文描述
     * @param nameEnShort 星期英文缩写描述
     * @param number 星期
     */
    DateWeek(String nameCn, String nameEn, String nameEnShort, int number) {
        this.nameCn = nameCn;
        this.nameEn = nameEn;
        this.nameEnShort = nameEnShort;
        this.number = number;
    }

    public String getChineseName() {
        return nameCn;
    }

    public String getName() {
        return nameEn;
    }

    public String getShortName() {
        return nameEnShort;
    }

    public int getNumber() {
        return number;
    }
}
