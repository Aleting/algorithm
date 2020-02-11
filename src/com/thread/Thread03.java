package com.thread;

/**
 * @ClassDesc: 功能描述：()
 * @author: 青岛理工大学-王玉军
 * @createTime：2019/9/24 16:02
 * @version: v1.0
 */
public class Thread03 {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                System.out.println("方法三：实现内部匿名类方式Thread");
            };
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("方法三：实现内部匿名类方式Runnable");
            };
        }).start();
        System.out.println("main线程！");
    }
}
