package com.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassDesc: 功能描述：()
 * @author: 青岛理工大学-王玉军
 * @createTime：2019/9/24 16:31
 * @version: v1.0
 */
public class Thread05 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("方法五：利用定时器Timer进行创建");
            }
            //0是第一次执行时间，10000每隔十秒执行一次
        },0,10000);
        System.out.println("main线程！");
    }
}
