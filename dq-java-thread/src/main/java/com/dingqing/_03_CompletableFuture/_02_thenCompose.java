package com.dingqing._03_CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * @Author kerr
 * @Date 2022-08-14 01:28
 * @Desc CompletableFuture 的 supplyAsync方法
 *
 * 场景模拟：小白进入餐厅的同时点了个菜之后开始打游戏，同时厨师开始做菜，做好菜之后服务员给小白打饭
 */
public class _02_thenCompose {
    public static void main(String[] args) {
        SmallTool.printTimesAndThread("小白进入餐厅");
        SmallTool.printTimesAndThread("小白点了一份 番茄炒蛋 + 一份米饭");

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimesAndThread("厨师做番茄炒蛋");
            SmallTool.sleepMills(200L);
            return "番茄炒蛋";
        }).thenCompose(dish -> CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimesAndThread("服务员打饭");
            SmallTool.sleepMills(100L);
            return dish + "米饭";
        }));

        SmallTool.printTimesAndThread("小白在打王者");
        SmallTool.printTimesAndThread(String.format("%s ， 小白开吃", cf.join()));
    }
}
