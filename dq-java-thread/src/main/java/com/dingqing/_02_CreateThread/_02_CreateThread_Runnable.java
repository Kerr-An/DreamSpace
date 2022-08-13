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
 * 线程创建方式：
 *             1、重写Thread的run方法
 *             2、实现java.lang.Runnable接口，在创建Thread对象的时候传进去（实际上Thread就是实现的这个接口）
 *             3、使用FutureTask，在创建Thread对象的时候传过去
 */
public class _02_CreateThread_Runnable {
    public static void main(String[] args) throws InterruptedException {

        // 2、实现java.lang.Runnable接口，在创建Thread对象的时候传进去
        threadCreate2();

    }

    /**
     * 线程创建方式2：实现java.lang.Runnable接口，在创建Thread对象的时候传进去
     */
    private static void threadCreate2() {
        Thread thread = new Thread(
                () -> System.out.println("我是子线程2")
        );
        thread.start();
        System.out.println("main 结束");
    }
}
