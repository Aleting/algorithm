package com.interview.wangyi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。牛牛选工作的标准是在难度不超过自身能力值的情况下，
牛牛选择报酬最高的工作。在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，
牛牛依然使用自己的标准来帮助小伙伴们。牛牛的小伙伴太多了，于是他只好把这个任务交给了你。
 */
public class 牛牛找工作 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int [] ai = new int[M+N];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < N; i++) {
            ai[i] = scanner.nextInt();
            map.put(ai[i], scanner.nextInt());
        }
        int [] bi = new int[M];
        for (int i = 0; i < M; i++) {
            ai[N+i] = scanner.nextInt();
            bi[i] = ai[N+i];
            if (!map.containsKey(bi[i])) {
                map.put(ai[N+i], 0);
            }

        }
        Arrays.sort(ai);
        int max = 0;
        for (int i = 0; i < M+N; i++) {
            max = Math.max(max, map.get(ai[i]));
            map.put(ai[i], max);
        }

        for (int i = 0; i < M; i++) {
            System.out.println(map.get(bi[i]));
        }

    }
}
