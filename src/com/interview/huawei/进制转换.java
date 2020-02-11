package com.interview.huawei;

import java.util.Scanner;

import static java.lang.Integer.*;
import static java.lang.Math.*;
/*
将16进制转化为10进制
 */
public class 进制转换 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next().substring(2);
            String[] c = s.split("");
            int sum = 0;
            for (int i = c.length-1,j=0;i>=0;i--,j++){
                switch (c[i]){
                    case "A": sum+=(10* pow(16,j));break;
                    case "B": sum+=(11* pow(16,j));break;
                    case "C": sum+=(12* pow(16,j));break;
                    case "D": sum+=(13* pow(16,j));break;
                    case "E": sum+=(14* pow(16,j));break;
                    case "F": sum+=(15* pow(16,j));break;
                    default: sum+=(parseInt(c[i])*pow(16,j));break;
                }
            }
            System.out.println(sum);
        }
    }
}
