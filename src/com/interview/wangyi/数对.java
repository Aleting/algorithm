package com.interview.wangyi;

import java.util.Scanner;

/*
牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。
但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。
牛牛希望你能帮他计算一共有多少个可能的数对。
 */
public class 数对 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long k = sc.nextInt();
        long ans = 0L;
        if (k == 0) {
            ans = n * n; // 任何两对数的余数都是大于等于零
        } else {
            for (long y = k + 1; y <= n; y++) {
                ans += (n / y) * (y - k) + Math.max(0, n % y - k + 1);
                    // 假设n=10,k=3，则对y来说只能是4,5,6,7,8,9,10
                    // 当y=4,(n/y)*(y-k)代表x小于等于8(8是4的整数倍)时有(3,4),(7,4)，Math.max(0,n%y-k+1)代表x大于8时符合题意的对数为0
                    // 当y=5,(n/y)*(y-k)代表x小于等于10(10是5的整数倍)时有(3,5),(4,5),(8,5),(9,5)，Math.max(0,n%y-k+1)代表x大于10时符合题意的对数为0
                    // 当y=6,(n/y)*(y-k)代表x小于等于6时有(3,6),(4,6),(5,6),Math.max(0,n%y-k+1)代表x大于6时符合题意的对数为2,分别是(9,6),(10,6)
                    // 当y=7,(n/y)*(y-k)代表x小于等于7时有(3,7),(4,7),(5,7),(6,7),Math.max(0,n%y-k+1)代表x大于7时符合题意的对数为1,是(10,7)
                    // ...以此类推
            }
        }
        System.out.println(ans);
    }
}