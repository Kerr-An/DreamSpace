package com.dingqing._01_ThreadStatus;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author kerr
 * @Date 2022-07-27 00:15
 * @Desc 多线程基础
 */
public class ThreadStatus {
    public static void main(String[] args) throws InterruptedException {

        // 线程状态
        threadStatus();

    }

    /**
     * 线程的状态
     * @throws InterruptedException 异常
     */
    private static void threadStatus() throws InterruptedException {
        java.lang.Thread thread = new java.lang.Thread();
        System.out.println("1- " + thread.getState());
        thread.start();
        System.out.println("2- " + thread.getState());
        TimeUnit.SECONDS.sleep(1);
        System.out.println("3- " + thread.getState());
    }
}
