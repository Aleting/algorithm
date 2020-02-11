package com.interview.mi;

import java.util.Scanner;

public class 求最大素数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String[] s2 = s.substring(1,s.length()-1).split(",");
        int max = -1;
        for (String s3 : s2){
            int x = Integer.parseInt(s3);
            if(isPrimer(x)){
                if (x>=max){
                    max=x;
                }
            }
        }
        System.out.println(max);
    }
    public static boolean isPrimer(int x){
        double sqrt = Math.sqrt(x);
        if (x<2){
            return false;
        }
        if (x == 2||x==3){
            return true;
        }
        if (x%2==0){
            return false;
        }
        for (int i=3;i<=sqrt;i+=2){
            if (x%i==0){
                return false;
            }
        }
        return true;
    }
}
