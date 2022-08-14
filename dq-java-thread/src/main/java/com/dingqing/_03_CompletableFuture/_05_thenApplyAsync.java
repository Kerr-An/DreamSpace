package com.dingqing._03_CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * @Author kerr
 * @Date 2022-08-14 01:28
 * @Desc CompletableFuture 的 thenApplyAsync方法
 * <p>
 * 场景模拟：小白饭后买单，要求开发票，服务员开发票的时候，小白同时也在接电话，朋友喊他回去打游戏，服务员开好发票后，小白拿到发票就走了
 */
public class _05_thenApplyAsync {
    public static void main(String[] args) {
        SmallTool.printTimesAndThread("小白吃好了");
        SmallTool.printTimesAndThread("小白结账，要求开发票");

        CompletableFuture<String> invoice = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimesAndThread("服务员收款码 500元");
            SmallTool.sleepMills(200L);
            return "500";
        }).thenApplyAsync(money -> {
            SmallTool.printTimesAndThread(String.format("服务员开发票 面额 %s元", money));
            SmallTool.sleepMills(100L);
            return String.format("%s元发票", money);
        });

        SmallTool.printTimesAndThread("小白接到朋友电话，想一起打游戏");
        SmallTool.printTimesAndThread(String.format("小白拿到%s ， 准备回家", invoice.join()));
    }
}
