package com.leetcode.algorithms.EasyMode;

/**
 * You are given an integer n and an integer start.
 *
 * Define an array nums where nums[i] = start + 2 * i (0-indexed) and n == nums.length.
 *
 * Return the bitwise XOR of all elements of nums.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5, start = 0
 * Output: 8
 * Explanation: Array nums is equal to [0, 2, 4, 6, 8] where (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8.
 * Where "^" corresponds to bitwise XOR operator.
 *
 * Example 2:
 *
 * Input: n = 4, start = 3
 * Output: 8
 * Explanation: Array nums is equal to [3, 5, 7, 9] where (3 ^ 5 ^ 7 ^ 9) = 8.
 *
 *
 *
 * Constraints:
 *
 *     1 <= n <= 1000
 *     0 <= start <= 1000
 *     n == nums.length
 */
public class XOROperationInAnArray {

    public int xorOperation(int n, int start) {
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for XOR Operation in an Array.
         * Memory Usage: 38.7 MB, less than 99.45% of Java online submissions for XOR Operation in an Array.
         */
        int current = start;
        int ans = current;
        int count = 1;
        for(; n > 1; n--){
            current+=2;
            ans^=current;
        }
        return ans;
    }

}
