package com.leetcode.algorithms.MediumMode;

/**
 * You are given a 0-indexed string pattern of length n consisting of the characters 'I' meaning increasing and 'D' meaning decreasing.
 *
 * A 0-indexed string num of length n + 1 is created using the following conditions:
 *
 *     num consists of the digits '1' to '9', where each digit is used at most once.
 *     If pattern[i] == 'I', then num[i] < num[i + 1].
 *     If pattern[i] == 'D', then num[i] > num[i + 1].
 *
 * Return the lexicographically smallest possible string num that meets the conditions.
 *
 *
 *
 * Example 1:
 *
 * Input: pattern = "IIIDIDDD"
 * Output: "123549876"
 * Explanation:
 * At indices 0, 1, 2, and 4 we must have that num[i] < num[i+1].
 * At indices 3, 5, 6, and 7 we must have that num[i] > num[i+1].
 * Some possible values of num are "245639871", "135749862", and "123849765".
 * It can be proven that "123549876" is the smallest possible num that meets the conditions.
 * Note that "123414321" is not possible because the digit '1' is used more than once.
 *
 * Example 2:
 *
 * Input: pattern = "DDD"
 * Output: "4321"
 * Explanation:
 * Some possible values of num are "9876", "7321", and "8742".
 * It can be proven that "4321" is the smallest possible num that meets the conditions.
 *
 *
 *
 * Constraints:
 *
 *     1 <= pattern.length <= 8
 *     pattern consists of only the letters 'I' and 'D'.
 */
public class ConstructSmallestNumberFromDIString {

    public String smallestNumber(String pattern) {
        /*
        Intuition

        If we meet I,II,III...
        we can greedily pick the smallest numebr.

        If we meet D,
        we can pick second smallest and then pick the smallest,
        like 21.

        If we meet D,
        we can pick the third smallest, then the second smallest, then the smallest,
        like 321.

        Explanation

        1 2 3 4 5 6 7 8 9
         D D I D D I D D

        Match the input string and the sequence 1,2,3,4,5,6,7,8,9.
        Reverse all numbers between "I".

        For example:
        first 'I' at 3, then reverse 1,2,3, we have 3,2,1
        second 'I' at 6, then reverse 4,5,6, we have 6,5,4
        Reverse the last group 7,8,9, we have 9,8,7

        Final result for D D I D D I D D,
        is 3,2,1,6,5,4,9,8,7

        We can have multiple approach to implement this process.

        Complexity

        Time O(n)
        Space O(n)

         */
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Construct Smallest Number From DI String.
         * Memory Usage: 40.2 MB, less than 96.82% of Java online submissions for Construct Smallest Number From DI String.
         */
        StringBuilder res = new StringBuilder(), stack = new StringBuilder();
        for (int i = 0; i <= pattern.length(); i++) {
            stack.append((char)('1' + i));
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                res.append(stack.reverse());
                stack = new StringBuilder();
            }
        }
        return res.toString();
    }

}
