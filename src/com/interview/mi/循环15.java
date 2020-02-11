package com.interview.mi;

import java.util.Scanner;

public class 循环15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] s=scanner.next().split(",");
        int x = Integer.parseInt(s[0]);
        int y =  Integer.parseInt(s[1]);
        for (int i = 0;i<y-x+1;i++){
            for (int j=1;j<=x+i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
