package com.leetcode.algorithms.MediumMode;

/**
 * Given an integer n, return a binary string representing its representation in base -2.
 *
 * Note that the returned string should not have leading zeros unless the string is "0".
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: "110"
 * Explantion: (-2)2 + (-2)1 = 2
 *
 * Example 2:
 *
 * Input: n = 3
 * Output: "111"
 * Explantion: (-2)2 + (-2)1 + (-2)0 = 3
 *
 * Example 3:
 *
 * Input: n = 4
 * Output: "100"
 * Explantion: (-2)2 = 4
 *
 *
 *
 * Constraints:
 *
 *     0 <= n <= 109
 */
public class ConvertToBase {

    public String baseNeg2(int n) {
        /**
         * Runtime: 2 ms, faster than 44.17% of Java online submissions for Convert to Base -2.
         * Memory Usage: 41.6 MB, less than 44.17% of Java online submissions for Convert to Base -2.
         */
        if(n == 0){
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(Math.abs(n) >= 2){
            stringBuilder.append(Math.abs(n % -2));
            if(n%-2 == -1){
                n/=-2;n++;
            } else {
                n/=-2;
            }
        }
        if(n == -1){
            stringBuilder.append(11);
        } else if(n == 1){
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }

}
