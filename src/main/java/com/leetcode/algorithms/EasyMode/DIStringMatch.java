package com.leetcode.algorithms.EasyMode;

/**
 * A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented as a string s of length n where:
 *
 *     s[i] == 'I' if perm[i] < perm[i + 1], and
 *     s[i] == 'D' if perm[i] > perm[i + 1].
 *
 * Given a string s, reconstruct the permutation perm and return it. If there are multiple valid permutations perm, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "IDID"
 * Output: [0,4,1,3,2]
 *
 * Example 2:
 *
 * Input: s = "III"
 * Output: [0,1,2,3]
 *
 * Example 3:
 *
 * Input: s = "DDI"
 * Output: [3,2,0,1]
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 105
 *     s[i] is either 'I' or 'D'.
 */
public class DIStringMatch {


    public int[] diStringMatch(String s) {
        /**
         * Runtime: 3 ms, faster than 78.49% of Java online submissions for DI String Match.
         * Memory Usage: 48.6 MB, less than 22.60% of Java online submissions for DI String Match.
         */
        int N = s.length();
        int lo = 0, hi = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            if (s.charAt(i) == 'I')
                ans[i] = lo++;
            else
                ans[i] = hi--;
        }

        ans[N] = lo;
        return ans;
    }

}
