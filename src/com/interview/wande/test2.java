package com.interview.wande;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        List list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        String [] strings = scanner.next().split("->");
        int last = strings.length - 1;
        Arrays.stream(strings).forEach(s -> list.add(s));
        check(list,last);
        int key = scanner.nextInt();
        list.remove(key -1);
        check(list,last-1);
    }
    static public void check(List list,int last){
        int first = 0;
        while (true){
            if (first>=last){
                System.out.println("true");
                break;
            }
            if (list.get(last).equals(list.get(first))){
                first ++ ;
                last --;
            }else {
                System.out.println("false");
                break;
            }
        }
    }
}