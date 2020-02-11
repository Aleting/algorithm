package com.thread;

/**
 * @ClassDesc: 功能描述：()
 * @author: 青岛理工大学-王玉军
 * @createTime：2019/9/24 16:00
 * @version: v1.0
 */
public class Thread02 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("方法二：继承Thread实现重写run方法");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Thread02());
        thread.start();
        System.out.println("main线程！");
    }
}
