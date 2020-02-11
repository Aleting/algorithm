package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassDesc: 功能描述：()
 * @author: 青岛理工大学-王玉军
 * @createTime：2019/9/24 16:08
 * @version: v1.0
 */
public class Thread04 implements Callable<String> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread04 thread04 = new Thread04();
        FutureTask<String> futureTask = new FutureTask<String>(thread04);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("提前完成任务");
        String s = futureTask.get();
        System.out.println("线程执行结束："+s);
        System.out.println("main线程！");
    }

    @Override
    public String call() throws Exception {
        System.out.println("方法3：通过实现Callable接口来实现线程");
        Thread.sleep(3000);
        return "线程睡了3秒";
    }
}
