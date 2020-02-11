package com.thread;

        import java.util.Arrays;
        import java.util.List;

/**
 * @ClassDesc: 功能描述：()
 * @author: 青岛理工大学-王玉军
 * @createTime：2019/9/24 16:53
 * @version: v1.0
 */

public class Thread07 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Thread07 demo = new Thread07();
        int result = demo.add(list);
        System.out.println("计算后的结果为" + result);
    }

    public int add(List<Integer> list) {
        //若Lambda是串行执行,则应顺序打印
        list.parallelStream().forEach(System.out::println);
        //Lambda有stream和parallelSteam(并行)
        return list.parallelStream().mapToInt(i -> i).sum();
    }
}
