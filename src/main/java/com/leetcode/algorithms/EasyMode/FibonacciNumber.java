package com.leetcode.algorithms.EasyMode;

/**
 * @Author JoeyYoung
 * @ClassName: Fibonacci Number
 * @Date 2021/11/27 14:48
 * @Description:
 * The Fibonacci numbers, commonly denoted F(n) form a sequence,
 * called the Fibonacci sequence, such that each number is the sum of the two preceding ones,
 * starting from 0 and 1. That is,
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 *
 * Given n, calculate F(n).
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 * Example 2:
 *
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 *
 * Example 3:
 *
 * Input: n = 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 *
 *
 * Constraints:
 *
 *     0 <= n <= 30
 *
 */
public class FibonacciNumber {

    /**
     * Runtime: 13 ms, faster than 7.24% of Java online submissions for Fibonacci Number.
     * Memory Usage: 37.4 MB, less than 27.75% of Java online submissions for Fibonacci Number.
     */
    public static int fib(int n) {
        if(n == 1){
            return 1;
        } else if (n == 0){
            return 0;
        }
        return fib(n-1)+fib(n-2);

        //Better Solution:
        /*return (int)(((Math.pow(((1+ Math.sqrt(5))/2), n)) - (Math.pow(((1- Math.sqrt(5))/2), n))) / Math.sqrt(5));*/
    }

    public static void main(String[] args) {
        System.out.println(fib(10));
    }
}
