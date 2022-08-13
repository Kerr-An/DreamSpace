package com.dingqing._03_CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * @Author kerr
 * @Date 2022-08-14 01:28
 * @Desc CompletableFuture 的 supplyAsync方法
 *
 * 场景模拟：小白进入餐厅的同时点了个菜之后开始打游戏，同时厨师开始做菜，同时服务员蒸饭，最后都做好了再给小白打饭
 */
public class _03_thenCombine {
    public static void main(String[] args) {
        SmallTool.printTimesAndThread("小白进入餐厅");
        SmallTool.printTimesAndThread("小白点了一份 番茄炒蛋 + 一份米饭");

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimesAndThread("厨师做番茄炒蛋");
            SmallTool.sleepMills(200L);
            return "番茄炒蛋";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimesAndThread("服务员蒸饭");
            SmallTool.sleepMills(300L);
            return "米饭";
        }), (dish, rice) -> {
            SmallTool.printTimesAndThread("服务员打饭");
            SmallTool.sleepMills(100L);
            return String.format("%s + %s 好了", dish, rice);
        });

        SmallTool.printTimesAndThread("小白在打王者");
        SmallTool.printTimesAndThread(String.format("%s ， 小白开吃", cf.join()));
    }
}
