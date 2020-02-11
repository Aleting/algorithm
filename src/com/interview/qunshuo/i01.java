package com.interview.qunshuo;

import java.util.*;

/**
 * @ClassDesc: 功能描述：()
 * @author: 青岛理工大学-王玉军
 * @createTime：2019/10/09 14:09
 * @version: v1.0
 */
public class i01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] set1 = new int[1000000];
        int[] set2 = new int[1000000];
        String[] s1 = scanner.nextLine().split(",");
        int a = 0;
        for(String s:s1){
            set1[a++]=Integer.parseInt(s);
        }
        Arrays.sort(set1,0,s1.length);
        a = 0;
        String[] s2 = scanner.nextLine().split(",");
        for(String s:s2){
            set2[a++]=Integer.parseInt(s);
        }
        Arrays.sort(set2,0,s2.length);
        int m = 0;
        int z = 0;
        for (int i = 0;i<s1.length;i++){
            for (int j = z;j<s2.length;j++){
                if (set1[i]>=set2[j]){
                    z = j+1;
                    m++;
                    break;
                }
            }
        }
        System.out.println("最终有"+m+"位队友能被复活");
    }
}
