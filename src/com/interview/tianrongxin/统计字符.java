package com.interview.tianrongxin;

import java.util.Scanner;

public class 统计字符 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split("");
        int english = 0;
        int num = 0;
        int kongge = 0;
        int qita = 0;
        for (String s2:s1){
            if (s2.charAt(0)>='a'&&s2.charAt(0)<='z'){
                english++;
            }
            else if (s2.charAt(0)>='0'&&s2.charAt(0)<='9'){
                num++;
            }
            else if (s2.charAt(0)>='A'&&s2.charAt(0)<='Z'){
                english++;
            }
            else if (s2.equals(" ")){
                kongge++;
            }else {
                qita++;
            }


        }
        System.out.println("英文字母:"+english);
        System.out.println("空格:"+kongge);
        System.out.println("数字:"+num);
        System.out.print("其他字符:"+qita);
    }
}
