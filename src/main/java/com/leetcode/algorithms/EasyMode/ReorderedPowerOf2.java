package com.leetcode.algorithms.EasyMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.
 *
 * Return true if and only if we can do this so that the resulting number is a power of two.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: true
 *
 * Example 2:
 *
 * Input: n = 10
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *     1 <= n <= 109
 */
public class ReorderedPowerOf2 {

    public boolean reorderedPowerOf2(int n) {
        /**
         * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reordered Power of 2.
         * Memory Usage: 41.4 MB, less than 39.33% of Java online submissions for Reordered Power of 2.
         */
        final int[] frequency = new int[10];
        int digitCount = 0;

        while (n > 0) {
            frequency[n % 10]++;
            n /= 10;
            digitCount++;
        }

        int currP = 1;

        while (currP > 0) {
            final int[] currFreq = new int[10];
            int currDigitCount = 0;
            int currN = currP;

            while (currN > 0) {
                currFreq[currN % 10]++;
                currN /= 10;
                currDigitCount++;
            }

            if (currDigitCount > digitCount) return false;
            if (currDigitCount == digitCount && Arrays.equals(currFreq, frequency)) return true;

            currP <<= 1;
        }

        return false;
    }

}
