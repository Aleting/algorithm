package com.interview.wangyi;

import java.util.Scanner;

/*
牛牛去犇犇老师家补课，出门的时候面向北方，但是现在他迷路了。
虽然他手里有一张地图，但是他需要知道自己面向哪个方向，请你帮帮他。
 */
public class 迷路的牛牛 {
    public static String[] c = {"N","E","S","W"};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //无用参数，题目需要
        //int n = scanner.nextInt();
        String s = scanner.next();
        int before = 0;
        String[] s1 = s.split("");
        for (String s2 : s1){
            if (s2.equals("L")){
                if (before==0){
                    before = 3;
                }
                else {
                    before -= 1;
                }
            }else {
                if(before==3){
                    before=0;
                }else {
                    before+=1;
                }
            }
        }
        System.out.println(c[before]);
    }
}
