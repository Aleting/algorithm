package com.atguigu.search;

import java.util.Arrays;

//斐波那契查找算法
public class FibonacciSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {
        int arr[] = {1,8,20,32,23212,123432};
        System.out.println("index="+fibSearch(arr,1));
    }
    //因为后面我们mid=low+F（k-1）-1，需要使用到斐波那契数列，因此我们需要获得一个斐波那契数列
    public static int[] fib(){
        int [] f = new int[maxSize];
        f[0] =1 ;
        f[1] = 1;
        for (int i = 2;i<maxSize;i++){
            f[i] = f[i-1]+f[i-2];
        }
        return f;
    }
    //编写斐波那契查找算法
    public static int fibSearch(int[] a,int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0;//表示斐波那契分割数值对应的下标
        int mid = 0;//存放mid
        int f[] = fib();//获取斐波那契数列
        //获取斐波那契分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }
        //因为f[k]的值可能大于a的长度，因此我们需要Arrays类，构造一个新的数组，并指向a[];
        int[] temp = Arrays.copyOf(a, f[k]);
        //实际上需要使用a数组最后的数填充
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }
        //使用while循环找到需要的Key
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {//我们应该向左边查找
                high = mid - 1;
                k--;
            }else if (key > temp[mid]){
                low = mid+1;
                //为什么是k-2
                //说明
                //1.全部元素=前面加后面
                k -= 2;
            }else {
                if (mid<=high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
