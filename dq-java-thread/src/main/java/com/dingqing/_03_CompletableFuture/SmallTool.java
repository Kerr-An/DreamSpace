package com.dingqing._03_CompletableFuture;

import java.util.StringJoiner;

/**
 * @Author kerr
 * @Date 2022-08-14 00:47
 * @Desc 小工具
 */
public class SmallTool {

    /**
     * 让线程睡一会
     * @param mills 时长（ms）
     */
    public static void sleepMills(Long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印时间和线程信息
     * @param tag 消息
     */
    public static void printTimesAndThread(String tag) {
        String result = new StringJoiner("\t|\t")
                .add(String.valueOf(System.currentTimeMillis()))
                .add(String.valueOf(Thread.currentThread().getId()))
                .add(String.valueOf(Thread.currentThread().getName()))
                .add(tag)
                .toString();
        System.out.println(result);
    }

}
