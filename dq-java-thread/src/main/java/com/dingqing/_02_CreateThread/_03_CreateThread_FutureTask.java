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
public class _03_CreateThread_FutureTask {
    public static void main(String[] args) throws InterruptedException {

        // 3、使用FutureTask，在创建Thread对象的时候传过去
        threadCreate3();

    }

    /**
     * 线程创建方式3：使用FutureTask，在创建Thread对象的时候传过去
     */
    private static void threadCreate3() {
        Callable<String> callable = () -> {
            System.out.println("我是子任务");
            return "sub task done";
        };
        FutureTask<String> futureTask = new FutureTask(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("子线程启动");
        try {
            // 主线程调用get()方法，会一直询问子线程的情况，一直到子线程执行完毕或者发生异常，主线程才能得到结果，然后继续往下执行
            String subResult = futureTask.get();
            System.out.println("子线程返回值：" + subResult);
        } catch (ExecutionException e) {
            // 子线程异常
            Throwable cause = e.getCause();
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main 结束");
    }
}
