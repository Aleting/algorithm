package com.test;

import java.util.ArrayList;
import java.util.List;

public class Iterator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        java.util.Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer integer = iterator.next();
            System.out.println(integer);
        }
    }
}
