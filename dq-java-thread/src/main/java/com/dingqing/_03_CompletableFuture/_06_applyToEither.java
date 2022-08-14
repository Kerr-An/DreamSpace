package com.dingqing._03_CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * @Author kerr
 * @Date 2022-08-14 01:28
 * @Desc CompletableFuture 的 applyToEither 方法
 * <p>
 * 场景模拟：小白饭后买单，要求开发票，服务员开发票的时候，小白同时也在接电话，朋友喊他回去打游戏，服务员开好发票后，小白拿到发票就走了
 */
public class _06_applyToEither {
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
        }), firstComeBus -> firstComeBus);

        SmallTool.printTimesAndThread(String.format("%s，准备回家", bus.join()));
    }
}
