package com.leetcode.algorithms.EasyMode;

/**
 * You are given a positive integer num. You may swap any two digits of num that have the same parity (i.e. both odd digits or both even digits).
 *
 * Return the largest possible value of num after any number of swaps.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 1234
 * Output: 3412
 * Explanation: Swap the digit 3 with the digit 1, this results in the number 3214.
 * Swap the digit 2 with the digit 4, this results in the number 3412.
 * Note that there may be other sequences of swaps but it can be shown that 3412 is the largest possible number.
 * Also note that we may not swap the digit 4 with the digit 1 since they are of different parities.
 *
 * Example 2:
 *
 * Input: num = 65875
 * Output: 87655
 * Explanation: Swap the digit 8 with the digit 6, this results in the number 85675.
 * Swap the first digit 5 with the digit 7, this results in the number 87655.
 * Note that there may be other sequences of swaps but it can be shown that 87655 is the largest possible number.
 *
 *
 *
 * Constraints:
 *
 *     1 <= num <= 109
 */
public class LargestNumberAfterDigitSwapsByParity {

    public int largestInteger(int num) {
        /**
         * Runtime: 1 ms, faster than 99.45% of Java online submissions for Largest Number After Digit Swaps by Parity.
         * Memory Usage: 40.9 MB, less than 70.99% of Java online submissions for Largest Number After Digit Swaps by Parity.
         */
        char[] a = String.valueOf(num).toCharArray();
        for(int i = 1; i < a.length; i++)   {
            int k = i;
            for(int j = i - 1; j >= 0; j--) {
                if((a[j] - a[k]) % 2 == 0)    {
                    if(a[j] < a[k]) {
                        char t = a[k];
                        a[k] = a[j];
                        a[j] = t;
                        k = j;
                    }
                }
            }
        }
        return Integer.parseInt(new String(a));
    }


}
