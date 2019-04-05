package com.leetcode.algorithms.MediumMode;

/**
 * @author YHW
 * @ClassName: DivideTwoIntegers
 * @Description:
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero.
 * @date 2019/4/5 15:13
 */

public class DivideTwoIntegers {

    /**
     * @Status:Accepted
     * @Runtime:1 ms
     * @Memory:32.4 MB
     */
    public int divide(int dividend, int divisor) {
        long num1 = Math.abs((long)dividend);
        long num2 = Math.abs((long)divisor);
        boolean flag = (dividend > 0) ^ (divisor > 0);
        if(num2 == 1)
            return flag ? -Math.abs(dividend):(num1 == Math.abs(dividend)?Math.abs(dividend):Integer.MAX_VALUE);
        int result = 0;
        while (num1 >= num2){
            int count = 0;
            while (num1 >= num2<<count){
                result += 1<<count;
                num1 -= num2<<count;
                count++;
            }
        }
        return flag? -result: result;
    }
}
