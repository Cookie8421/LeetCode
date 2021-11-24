package com.leetcode.algorithms.MediumMode;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author JoeyYoung
 * @ClassName: Delete Operation for Two Strings
 * @Date 2021/11/24 11:21
 * @Description:
 *
 * Given two strings word1 and word2,
 * return the minimum number of steps required to make word1 and word2 the same.
 *
 * In one step, you can delete exactly one character in either string.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "sea", word2 = "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 *
 * Constraints:
 *
 *     1 <= word1.length, word2.length <= 500
 *     word1 and word2 consist of only lowercase English letters.
 *
 *
 */
public class DeleteOperationForTwoStrings {
    /**
     * indexArray[0]:Index of longestSubstr in word1
     * indexArray[1]:Index of longestSubstr in word2
     * indexArray[2]:Length of longestSubstr
     */
    public static int minDistance(String s1, String s2) {
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        return s1.length() + s2.length() - 2 * lcs(s1, s2, s1.length(), s2.length(), memo);
    }
    public static int lcs(String s1, String s2, int m, int n, int[][] memo) {
        if (m == 0 || n == 0)
            return 0;
        if (memo[m][n] > 0)
            return memo[m][n];
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            memo[m][n] = 1 + lcs(s1, s2, m - 1, n - 1, memo);
        else
            memo[m][n] = Math.max(lcs(s1, s2, m, n - 1, memo), lcs(s1, s2, m - 1, n, memo));
        return memo[m][n];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("sea", "creator"));
    }

}
