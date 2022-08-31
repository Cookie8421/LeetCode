package com.leetcode.algorithms.EasyMode;

/**
 * Given an integer n, return true if it is a power of four. Otherwise, return false.
 *
 * An integer n is a power of four, if there exists an integer x such that n == 4x.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 16
 * Output: true
 *
 * Example 2:
 *
 * Input: n = 5
 * Output: false
 *
 * Example 3:
 *
 * Input: n = 1
 * Output: true
 *
 *
 *
 * Constraints:
 *
 *     -231 <= n <= 231 - 1
 *
 *
 * Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfFour {

    public boolean isPowerOfFour(int n) {
        /**
         * Runtime: 1 ms, faster than 100.00% of Java online submissions for Power of Four.
         * Memory Usage: 41.5 MB, less than 31.11% of Java online submissions for Power of Four.
         */
        if(n <= 0 || (n & (n-1)) != 0) return false;

        int count = 0;
        while(n != 0) {
            if((n & 1) == 0)
                count++;

            n >>>= 1;
        }

        return (count & 1) == 0;
    }

}
