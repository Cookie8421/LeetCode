package com.leetcode.algorithms.MediumMode;

/**
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 *
 *
 *
 * Example 1:
 *
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 *
 * Input: a = 2, b = 3
 * Output: 5
 *
 *
 * Constraints:
 *
 * -1000 <= a, b <= 1000
 */
public class SumOfTwoIntegers {

    /**
     * Runtime
     * 0 ms
     * Beats
     * 100%
     * Memory
     * 39 MB
     * Beats
     * 71.42%
     */
    public int getSum(int a, int b) {
        /*
            a = 12 # binary: 1100
            b = 7 # binary: 0111
            result = ~((~a) & b) + ~(~b & a)
            按位与和异或运算，都是转为补码运算的，java的int类型是32位的
            负数的补码：原码按位取反加一
         */
        int carry=0;
        while (b != 0){
            carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

}
