package com.interview.huawei;

import java.util.Scanner;

/*
计算字符串最后一个单词的长度，单词以空格隔开。
 */
public class 字符串最后一个单词的长度 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String[] aWord = word.split(" ");
        System.out.println(aWord[aWord.length-1].length());
    }
}
