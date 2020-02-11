package com.interview.vipkid;

import java.util.*;

public class 寻找zero组数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> set1 = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();
        int pair = 0;
        String s = scanner.nextLine();
        String[] num = s.split(",");
        for (int i =0;i<num.length;i++){
            if (Integer.parseInt(num[i])>0){

               if (set1.contains(Integer.parseInt(num[i]))){
                  continue;
              }
                set1.add(Integer.parseInt(num[i]));
            }else if (Integer.parseInt(num[i])<0){
               if (set2.contains(Integer.parseInt(num[i]))){
                   continue;
               }
                set2.add(Integer.parseInt(num[i]));
            }else {
                set2.add(Integer.parseInt(num[i]));
                set1.add(Integer.parseInt(num[i]));
            }
        }
        for (int i:set1){
            if (set2.contains(-i)){
                pair++;
            }
        }
        System.out.println(pair);
    }
}