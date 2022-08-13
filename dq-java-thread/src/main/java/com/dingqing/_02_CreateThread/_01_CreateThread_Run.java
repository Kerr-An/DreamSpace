package com.dingqing._02_CreateThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author kerr
 * @Date 2022-07-27 00:15
 * @Desc 多线程基础
 *
 *         线程创建方式：
 *             1、重写Thread的run方法
 *             2、实现java.lang.Runnable接口，在创建Thread对象的时候传进去（实际上Thread就是实现的这个接口）
 *             3、使用FutureTask，在创建Thread对象的时候传过去
 */
public class _01_CreateThread_Run {
    public static void main(String[] args) throws InterruptedException {

        // 1、重写Thread的run方法
        threadCreate1();

    }

    /**
     * 线程创建方式1：重写Thread的run方法
     */
    private static void threadCreate1() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("我是子线程1");
            }
        };
        thread.start();
        System.out.println("main 结束");
    }
}
