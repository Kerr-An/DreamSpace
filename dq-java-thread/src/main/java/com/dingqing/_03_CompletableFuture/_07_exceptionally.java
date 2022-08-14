package com.dingqing._03_CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * @Author kerr
 * @Date 2022-08-14 01:28
 * @Desc CompletableFuture 链式调用中的 exceptionally 方法
 * <p>
 * 场景模拟：小白出来准备坐公交回家，有两路公交可以回家，666路和999路，小白决定哪一路先来坐哪一路；
 *          结果公交车撞树上了，小白只能下车打车回家
 */
public class _07_exceptionally {
    public static void main(String[] args) {
        SmallTool.printTimesAndThread("小白走出餐厅，来到公交站");
        SmallTool.printTimesAndThread("等待 666路 或者 999路 公交到来");

        CompletableFuture<String> bus = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimesAndThread("666路公交正在赶来");
            SmallTool.sleepMills(100L);
            return "666路到了";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimesAndThread("999路公交正在赶来");
            SmallTool.sleepMills(200L);
            return "999路到了";
        }), firstComeBus -> {
            SmallTool.printTimesAndThread(firstComeBus);
            if (firstComeBus.startsWith("666")) {
                throw new RuntimeException("撞树了...");
            }
            return firstComeBus;
        }).exceptionally(e -> {
            SmallTool.printTimesAndThread(e.getMessage());
            SmallTool.printTimesAndThread("小白叫出租车");
            return "出租车 到了";
        });

        SmallTool.printTimesAndThread(String.format("%s，小白乘车回家", bus.join()));
    }
}
