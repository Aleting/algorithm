package com.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @ClassDesc: 功能描述：(通过线程池创建)
 * @author: 青岛理工大学-王玉军
 * @createTime：2019/9/24 16:37
 * @version: v1.0
 */
public class Thread06 {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(5);
        for (int i = 0;i < 10; i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" is Running");
                }
            });
        }
        System.out.println("main线程！");
    }
}
