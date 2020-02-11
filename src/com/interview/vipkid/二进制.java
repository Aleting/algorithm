package com.interview.vipkid;

import java.util.Scanner;

public class 二进制 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        String s1 = Integer.toBinaryString(s);
        String[] s2 = s1.split("");
        int count=0;
        for (String i:s2){
            if (Integer.parseInt(i)==1){
                count++;
            }
        }
        System.out.println(count);
    }
}
