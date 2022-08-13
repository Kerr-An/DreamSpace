package com.dingqing;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Copyright (C), 2002-2022, 希音
 *
 * @FileName: UnitTest1
 * @Author: SunJian
 * @Date: 2022/8/9 14:28
 * @Description: TODO //模块目的、功能描述
 */
@Slf4j
public class UnitTest1 {

    // region Calendar add方法
    @Test
    public void testCalendarAdd() {
        int days = -2;

        System.out.println("add: Calendar.DAY_OF_YEAR：" + getDateYearAdd(new Date(), days));

        System.out.println("add: Calendar.DAY_OF_MONTH：" + getDateMonthAdd(new Date(), days));

        System.out.println("add: Calendar.DAY_OF_WEEK：" + getDateWeekAdd(new Date(), days));

        System.out.println("add: Calendar.DAY_OF_WEEK_IN_MONTH：" + getDateWeekInMonthAdd(new Date(), days));

    }

    /**
     * 获取指定日期 前（days为负）/ 后（days为正） days天的时间
     * @param days 天数
     * @return 时间
     */
    public static Date getDateYearAdd(Date sourceDate, Integer days){
        Calendar cale = Calendar.getInstance();
        cale.setTime(sourceDate);
        cale.add(Calendar.DAY_OF_YEAR, days);
        return cale.getTime();
    }

    /**
     * 在给定的日期加上或减去指定月份后的日期
     *
     * @param sourceDate 原始时间
     * @param month      要调整的月份，向前为负数，向后为正数
     * @return month月前的日期
     */
    public static Date getDateMonthAdd(Date sourceDate, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.add(Calendar.DAY_OF_MONTH, month);
        return c.getTime();
    }

    /**
     * 在给定的日期加上或减去指定月份后的日期
     *
     * @param sourceDate 原始时间
     * @param month      要调整的月份，向前为负数，向后为正数
     * @return month月前的日期
     */
    public static Date getDateWeekAdd(Date sourceDate, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.add(Calendar.DAY_OF_WEEK, month);
        return c.getTime();
    }

    /**
     * 在给定的日期加上或减去指定月份后的日期
     *
     * @param sourceDate 原始时间
     * @param month      要调整的月份，向前为负数，向后为正数
     * @return month月前的日期
     */
    public static Date getDateWeekInMonthAdd(Date sourceDate, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.add(Calendar.DAY_OF_WEEK_IN_MONTH, month);
        return c.getTime();
    }
    // endregion


    // region Calendar set方法
    @Test
    public void testCalendarSet() {
        int days = -2;

        System.out.println("set: Calendar.DAY_OF_YEAR：" + getDateYearSet(new Date(), days));

        System.out.println("set: Calendar.DAY_OF_MONTH：" + getDateMonthSet(new Date(), days));

        System.out.println("set: Calendar.DAY_OF_WEEK：" + getDateWeekSet(new Date(), days));

        System.out.println("set: Calendar.DAY_OF_WEEK_IN_MONTH：" + getDateWeekInMonthSet(new Date(), days));

    }

    /**
     * 获取指定日期 前（days为负）/ 后（days为正） days天的时间
     * @param days 天数
     * @return 时间
     */
    public static Date getDateYearSet(Date sourceDate, Integer days){
        Calendar cale = Calendar.getInstance();
        cale.setTime(sourceDate);
        cale.set(Calendar.DAY_OF_YEAR, days);
        return cale.getTime();
    }

    /**
     * 在给定的日期加上或减去指定月份后的日期
     *
     * @param sourceDate 原始时间
     * @param month      要调整的月份，向前为负数，向后为正数
     * @return month月前的日期
     */
    public static Date getDateMonthSet(Date sourceDate, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.set(Calendar.DAY_OF_MONTH, month);
        return c.getTime();
    }

    /**
     * 在给定的日期加上或减去指定月份后的日期
     *
     * @param sourceDate 原始时间
     * @param month      要调整的月份，向前为负数，向后为正数
     * @return month月前的日期
     */
    public static Date getDateWeekSet(Date sourceDate, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.set(Calendar.DAY_OF_WEEK, month);
        return c.getTime();
    }

    /**
     * 在给定的日期加上或减去指定月份后的日期
     *
     * @param sourceDate 原始时间
     * @param month      要调整的月份，向前为负数，向后为正数
     * @return month月前的日期
     */
    public static Date getDateWeekInMonthSet(Date sourceDate, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.set(Calendar.DAY_OF_WEEK_IN_MONTH, month);
        return c.getTime();
    }
    // endregion

}