package com.thread;

/**
 * @ClassDesc: 功能描述：(线程的创建方式)
 * @author: 青岛理工大学-王玉军
 * @createTime：2019/9/24 15:51
 * @version: v1.0
 */
public class Thread01 implements Runnable{
    @Override
    public void run() {
        System.out.println("方式一：实现Runnable接口方法，创建线程！");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Thread01());
        thread.start();
        System.out.println("main线程！");
    }
}
