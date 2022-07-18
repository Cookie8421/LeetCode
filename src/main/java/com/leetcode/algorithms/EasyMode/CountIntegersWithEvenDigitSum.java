package com.leetcode.algorithms.EasyMode;

/**
 * Given a positive integer num,
 * return the number of positive integers less than or equal to num whose digit sums are even.
 *
 * The digit sum of a positive integer is the sum of all its digits.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 4
 * Output: 2
 * Explanation:
 * The only integers less than or equal to 4 whose digit sums are even are 2 and 4.
 *
 * Example 2:
 *
 * Input: num = 30
 * Output: 14
 * Explanation:
 * The 14 integers less than or equal to 30 whose digit sums are even are
 * 2, 4, 6, 8, 11, 13, 15, 17, 19, 20, 22, 24, 26, and 28.
 *
 *
 *
 * Constraints:
 *
 *     1 <= num <= 1000
 */
public class CountIntegersWithEvenDigitSum {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Integers With Even Digit Sum.
     * Memory Usage: 41.7 MB, less than 10.83% of Java online submissions for Count Integers With Even Digit Sum.
     */
    public int countEven(int num) {
        int res = 0;
        boolean curIsEven = true;
        int t = num / 10;
        int tres = num%10;
        if(!isEven(t)){
            curIsEven = false;
        }
        res += 5*t-1;
        if(!curIsEven && num%2 == 0){
            res += tres/2;
        } else {
            res += tres/2+1;
        }
        return res;
    }

    public boolean isEven(int num){
        int res = 0;
        while(true){
            res += num % 10;
            if(num < 10) break;
            num /= 10;
        }
        if(res%2 == 0) return true;
        return false;
    }

}
