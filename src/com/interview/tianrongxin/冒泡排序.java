package com.interview.tianrongxin;

import java.util.Scanner;

public class 冒泡排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split("");
        char[] s2 = new char[s1.length];
        for (int i = 0;i<s1.length;i++){
            s2[i] = s1[i].charAt(0);
        }
        BubbleSort(s2);

    }

    // 冒泡排序
    public static void BubbleSort(char[] arr) {
        char temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        String s3 = "";
        for (char a : arr){
            s3+=a;
        }
        System.out.println(s3);
    }
}
