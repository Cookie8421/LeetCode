package com.leetcode.algorithms.EasyMode;

/**
 * You are given a positive integer num consisting only of digits 6 and 9.
 *
 * Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 *
 *
 *
 * Example 1:
 *
 * Input: num = 9669
 * Output: 9969
 * Explanation:
 * Changing the first digit results in 6669.
 * Changing the second digit results in 9969.
 * Changing the third digit results in 9699.
 * Changing the fourth digit results in 9666.
 * The maximum number is 9969.
 *
 * Example 2:
 *
 * Input: num = 9996
 * Output: 9999
 * Explanation: Changing the last digit 6 to 9 results in the maximum number.
 *
 * Example 3:
 *
 * Input: num = 9999
 * Output: 9999
 * Explanation: It is better not to apply any change.
 *
 *
 *
 * Constraints:
 *
 *     1 <= num <= 104
 *     num consists of only 6 and 9 digits.
 */
public class Maximum69Number {

    public int maximum69Number (int num) {
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum 69 Number.
         * Memory Usage: 41.2 MB, less than 44.85% of Java online submissions for Maximum 69 Number.
         */
        int res = num;
        boolean flag = false;
        int i = 0;
        int current = 0;
        while(num > 0){
            if(num % 10 == 6){
                flag = true;
                current = i;
            }
            num = num / 10;
            i++;
        }
        return res + (flag ? 3 * (int)Math.pow(10, current) : 0);
    }

}
