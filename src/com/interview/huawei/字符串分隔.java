package com.interview.huawei;

import java.util.Scanner;

/*
连续输入字符串(输入2次,每个字符串长度小于100)
 */
public class 字符串分隔{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = new String(sc.nextLine());
            if(s.length()%8 !=0 )
                s = s + "00000000";
            while(s.length()>=8){
                System.out.println(s.substring(0, 8));
                s = s.substring(8);
            }
        }
    }
}
