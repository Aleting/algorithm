package com.interview.xiecheng;

import java.util.*;

public class 表达式解析 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        String[] s = expr.split("");
        Stack<Integer> stack = new Stack<>();
if (s.length==0){

}
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("(")) {
                stack.push(i);
            }
            if (s[i].equals(")")) {
                String s1 = "";
                int k = stack.pop();
                for (int j = i - 1; j > k; j--) {
                    s1 += s[j];
                }
                String[] s2 = s1.split("");
                for (int j = k + 1, o = 0; j < i; j++) {
                    s[j] = s2[o++];
                }
            }
        }
        String s9 = "";
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("(") || s[i].equals(")")) {

            } else {
                s9 += s[i];
            }


        }   return s9;}
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
