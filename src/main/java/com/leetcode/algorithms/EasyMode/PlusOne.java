package com.leetcode.algorithms.EasyMode;

import java.util.Arrays;

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 *
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 *
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 *
 * Example 3:
 *
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 *
 *
 *
 * Constraints:
 *
 *     1 <= digits.length <= 100
 *     0 <= digits[i] <= 9
 *     digits does not contain any leading 0's.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        /**
         * Runtime: 1 ms, faster than 28.18% of Java online submissions for Plus One.
         * Memory Usage: 42.5 MB, less than 54.44% of Java online submissions for Plus One.
         */
        boolean shift = true;
        int[] ans = new int[digits.length+1];
        for(int i = digits.length-1; i >= 0; i--){
            if(shift){
                if(digits[i] == 9){
                    ans[i+1] = 0;
                } else {
                    shift = false;
                    ans[i+1] = digits[i]+1;
                }
            } else {
                ans[i+1] = digits[i];
            }
        }
        if(shift){
            ans[0] = 1;
            return ans;
        } else {
            return Arrays.copyOfRange(ans, 1, ans.length);
        }
    }

}
