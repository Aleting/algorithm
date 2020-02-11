package com.interview.qianxin;

import java.util.Scanner;

public class 找出最长数字串 {
        /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
        static String find_longest_num_str(String input) {
            String s = null;
            String[] s1 = input.replaceAll("[^0-9]",",").split(",");
            int max = 0;
            for (String s2:s1){
                if (s2.length()>max){
                    max=s2.length();
                    s = s2;
                }
            }
            return s;
        }
/******************************结束写代码******************************/


        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            String res;
            String _input;
            try {
                _input = in.nextLine();
            } catch (Exception e) {
                _input = null;
            }

            res = find_longest_num_str(_input);
            System.out.println(String.format("%d/%s", res.length(), res));
        }
    }

