package com.leetcode.algorithms.MediumMode;

/**
 * You are given an array of binary strings strs and two integers m and n.
 *
 * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
 *
 * A set x is a subset of a set y if all elements of x are also elements of y.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
 * Output: 4
 * Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
 * Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
 * {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
 * Example 2:
 *
 * Input: strs = ["10","0","1"], m = 1, n = 1
 * Output: 2
 * Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] consists only of digits '0' and '1'.
 * 1 <= m, n <= 100
 */
public class OnesAndZeroes {
    /**
     * Runtime
     * 147 ms
     * Memory
     * 80.1 MB
     * // DP 0-1 knapsack solution
     * // dp[i][j][k] means the length of largest subset at most j 0's and k 1's with first i strings.
     * // If there is enough 0 and 1, then use it dp[i][j][k] = max(dp[i-1][j][k], 1 + dp[i-1][j-pair.zero][k-pair.one]).
     * // Otherwise dp[i][j][k] = dp[i-1][j][k].
     * // Time complexity: O(L*M*N)
     * // Space compelexity: O(L*M*N)
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][][] dp = new int[l+1][m+1][n+1];
        Pair[] pairs = new Pair[l];
        for (int i = 0; i < l; i++) {
            pairs[i] = count01(strs[i]);
        }
        for (int i = 1; i <= l; i++) {
            Pair pair = pairs[i-1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j-pair.zero >= 0 && k-pair.one >= 0) {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], 1 + dp[i-1][j-pair.zero][k-pair.one]);
                    } else {
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }
        return dp[l][m][n];
    }

    private Pair count01(String str) {
        int count0 = 0, count1 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                count0++;
            } else {
                count1++;
            }
        }
        return new Pair(count0, count1);
    }

    class Pair {
        int zero, one;
        Pair(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
    }


}
