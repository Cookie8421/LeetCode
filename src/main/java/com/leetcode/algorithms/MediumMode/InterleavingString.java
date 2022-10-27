package com.leetcode.algorithms.MediumMode;

/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 *
 * An interleaving of two strings s and t is a configuration where s and t are divided into n and m non-empty substrings respectively, such that:
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Explanation: One way to obtain s3 is:
 * Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
 * Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
 * Since s3 can be obtained by interleaving s1 and s2, we return true.
 * Example 2:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.
 * Example 3:
 *
 * Input: s1 = "", s2 = "", s3 = ""
 * Output: true
 *
 *
 * Constraints:
 *
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1, s2, and s3 consist of lowercase English letters.
 *
 *
 * Follow up: Could you solve it using only O(s2.length) additional memory space?
 */
public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {
        /**
         * Runtime: 1 ms, faster than 99.85% of Java online submissions for Interleaving String.
         * Memory Usage: 40.5 MB, less than 94.88% of Java online submissions for Interleaving String.
         */

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int[][] map = new int[s1.length()][s2.length()];

        return isInterleave(s1, 0, s2, 0, s3, 0,map);
    }

    public static boolean isInterleave(String str1, int s1, String str2, int s2, String str3, int s3,int[][] map) {

        if (s1 == str1.length()) {
            return str2.substring(s2).equals(str3.substring(s3));
        }

        if (s2 == str2.length()) {
            return str1.substring(s1).equals(str3.substring(s3));
        }

        if(map[s1][s2]>=1) {
            return map[s1][s2]==2;
        }

        boolean result = false;
        if (str1.charAt(s1) == str3.charAt(s3) && isInterleave(str1, s1 + 1, str2, s2, str3, s3 + 1,map)
                || str2.charAt(s2) == str3.charAt(s3)
                && isInterleave(str1, s1, str2, s2 + 1, str3, s3 + 1,map)) {
            result = true;
        }
        map[s1][s2] = result?2:1;
        return result;
    }

}
