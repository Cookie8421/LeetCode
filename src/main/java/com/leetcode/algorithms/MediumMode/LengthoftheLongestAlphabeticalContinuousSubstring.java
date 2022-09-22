package com.leetcode.algorithms.MediumMode;

/**
 * An alphabetical continuous string is a string consisting of consecutive letters in the alphabet. In other words, it is any substring of the string "abcdefghijklmnopqrstuvwxyz".
 *
 *     For example, "abc" is an alphabetical continuous string, while "acb" and "za" are not.
 *
 * Given a string s consisting of lowercase letters only, return the length of the longest alphabetical continuous substring.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abacaba"
 * Output: 2
 * Explanation: There are 4 distinct continuous substrings: "a", "b", "c" and "ab".
 * "ab" is the longest continuous substring.
 *
 * Example 2:
 *
 * Input: s = "abcde"
 * Output: 5
 * Explanation: "abcde" is the longest continuous substring.
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 105
 *     s consists of only English lowercase letters.
 */
public class LengthoftheLongestAlphabeticalContinuousSubstring {

    public int longestContinuousSubstring(String s) {
        /**
         * Runtime: 19 ms, faster than 75.15% of Java online submissions for Length of the Longest Alphabetical Continuous Substring.
         * Memory Usage: 53.5 MB, less than 85.84% of Java online submissions for Length of the Longest Alphabetical Continuous Substring.
         */
        int ans = 0;
        int count = 0;
        char current = 'a' - 1;
        for(char c : s.toCharArray()){
            if(c == current + 1){
                count++;
            } else {
                ans = Math.max(ans, count);
                count = 1;
            }
            current = c;
        }
        ans = Math.max(ans, count);
        return ans;
    }

}
