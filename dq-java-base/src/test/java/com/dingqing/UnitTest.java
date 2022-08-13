package com.dingqing;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.assertj.core.util.DateUtil;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Copyright (C), 2002-2022, 希音
 *
 * @FileName: UnitTest
 * @Author: SunJian
 * @Date: 2022/8/7 18:58
 * @Description: TODO //模块目的、功能描述
 */
@Slf4j
public class UnitTest {

    public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    @Test
    public void test01() {
        Date oldDate = parse("2022-08-06 08:16:00", YYYY_MM_DD_HH_MM_SS);
        assert oldDate != null;
        String l = differentDaysByMillisecond(oldDate, DateUtil.now(), 1D);
        System.out.println(l);
    }

    /**
     * 日期解析－将<code>String</code>类型的日期解析为<code>Date</code>型
     *
     * @param strDate 待解析的日期字符串
     * @param pattern 日期格式
     * @return 一个被格式化了的<code>Date</code>日期
     * @BusinessException ParseException 如果所给的字符串不能被解析成一个日期
     */
    public static Date parse(String strDate, String pattern) {
        try {
            return DateUtils.parseDate(strDate, pattern);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 通过秒毫秒数判断两个时间的间隔的天数（注意是2-1）
     * @param smallDate 小日期
     * @param bigDate 大日期
     * @param size 尺寸
     * @return 天数
     */
    public String differentDaysByMillisecond(Date smallDate, Date bigDate, double size)
    {
        return millsToDaysConvert((bigDate.getTime() - smallDate.getTime()) / size);
    }

    /**
     * 毫秒转天数，保留两位小数
     * @param mills 毫秒数
     * @return 保留两位小数的天数
     */
    private String millsToDaysConvert(double mills) {
        return String.format("%.2f", mills / 1000 / 60 / 60 / 24);
    }


    @Test
    public void testCipherTools() throws IOException {
//        log.info(CipherTools.SHA256("lilypayamps@gmail.com"));

        // CipherTools.decrypt(BdmsConst.BUSINESS_SECRET_KEY,"OUhrbGh3ckFQU3E5TnIxVIjG7+wx/5EurSMe3HzpRcO7PbOx07vKYjcIlQFAZFDA");
        // OUhrbGh3ckFQU3E5TnIxVIjG7+wx/5EurSMe3HzpRcO7PbOx07vKYjcIlQFAZFDA
    }

    @Test
    public void testCollectionUtils() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);

        //获取并集
        Collection<Integer> unionList = CollectionUtils.union(list, list2);
        System.out.println(unionList); // [1, 2, 3, 4]

        //获取交集
        Collection<Integer> intersectionList = CollectionUtils.intersection(list, list2);
        System.out.println(intersectionList); // [2]

        //获取交集的补集
        Collection<Integer> disjunctionList = CollectionUtils.disjunction(list, list2);
        System.out.println(disjunctionList); // [1, 3, 4]

        //获取差集 1-2
        Collection<Integer> subtractList = CollectionUtils.subtract(list, list2);
        System.out.println(subtractList); // [1, 3]

        //获取差集 2-1
        Collection<Integer> sub2tractList = CollectionUtils.subtract(list2, list);
        System.out.println(sub2tractList); // [4]
    }

    @Test
    public void cool() {
        List<Integer> list1 = Lists.newArrayList(75, 140, 156, 173, 181, 192, 193, 194, 195, 196, 197, 198,
                207, 212, 213, 217, 219, 226, 229, 235, 237, 247, 248, 250, 252, 254, 257, 258, 260, 266, 267, 269, 271,
                273, 275, 277, 278, 298, 299, 301, 305, 311, 312, 321, 332);
        List<Integer> list2 = Lists.newArrayList(215, 186, 224, 226, 156, 219, 213, 235, 252, 254, 250, 247,
                237, 212, 258, 273, 259, 269, 277, 267, 217, 278, 299, 298, 311, 312, 301, 170, 321, 211, 195);
        Collection<Integer> intersection = CollectionUtils.intersection(list1, list2);
        List<Integer> collect = intersection.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println(collect.size());
        System.out.println(collect);
    }



}