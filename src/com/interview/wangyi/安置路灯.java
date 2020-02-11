package com.interview.wangyi;

import java.util.Scanner;

/*
小Q正在给一条长度为n的道路设计路灯安置方案。
为了让问题更简单,小Q把道路视为n个方格,需要照亮的地方用'.'表示, 不需要照亮的障碍物格子用'X'表示。
小Q现在要在道路上设置一些路灯, 对于安置在pos位置的路灯, 这盏路灯可以照亮pos - 1, pos, pos + 1这三个位置。
小Q希望能安置尽量少的路灯照亮所有'.'区域, 希望你能帮他计算一下最少需要多少盏路灯。
 */
public class 安置路灯 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int ludeng = 0;
            String s = scanner.next();
            if (s.length()!=n) {
                break;
            }
            int count = 0;
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                if(c=='.'){
                    ludeng++;
                    j+=2;
                }

            }System.out.println(ludeng);
        }
    }
}
