package com.leetcode.algorithms.MediumMode;
/**
 * @author YHW
 * @ClassName: MyPow
 * @Description:
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * @date 2019/6/1 15:13
 */
public class MyPow {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Pow(x, n).
    //Memory Usage: 32.9 MB, less than 52.69% of Java online submissions for Pow(x, n).
    public double myPow(double x, int n) {
        if(x == 1){
            return 1;
        }
        if(n == 0){
            return 1;
        }

        if(n == Integer.MIN_VALUE && x >= 2) {
            return 0;
        }

        if(n<0){
            n = -n;
            x = 1/x;

        }
        if(n % 2 != 0){
            double r = myPow(x, (n - 1)/2);
            return x* r*r;
        }
        double r = myPow(x, n/2);
        return r * r;
    }

    public static void main(String[] args) {
        MyPow p = new MyPow();
        System.out.println(p.myPow(0.00001, 2147483647));
    }
}
