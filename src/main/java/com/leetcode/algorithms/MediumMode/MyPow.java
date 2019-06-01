package com.leetcode.algorithms.MediumMode;
/**
 * @author YHW
 * @ClassName: AddTwoNumbers
 * @Description:
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
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
    //此法会栈溢出
    public double myPow1(double x, int n) {
        if(n == Integer.MIN_VALUE && x >= 2) {
            return 0;
        }
        Double result = x;
        try{
            result = pow(x, 1.0, n, 1);
        }catch(StackOverflowError error){
            error.printStackTrace();
        }
        return result;
    }
    public double pow(double x, double result, int n, int step){
        if(n < 0){
            result /= x;
        }else if(n > 0){
            result *= x;
        }else{
            return result;
        }

        if(n == step || n == -step){
            return result;
        }
        result = pow (x, result, n, step+1);
        return result;
    }

    public static void main(String[] args) {
        MyPow p = new MyPow();
        System.out.println(p.myPow(0.00001, 2147483647));
    }
}
