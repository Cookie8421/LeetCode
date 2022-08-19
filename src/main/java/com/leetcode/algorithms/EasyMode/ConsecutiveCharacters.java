package com.leetcode.algorithms.EasyMode;

/**
 * The power of the string is the maximum length of a non-empty substring that contains only one unique character.
 *
 * Given a string s, return the power of s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 2
 * Explanation: The substring "ee" is of length 2 with the character 'e' only.
 *
 * Example 2:
 *
 * Input: s = "abbcccddddeeeeedcba"
 * Output: 5
 * Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
 *
 * Constraints:
 *
 *     1 <= s.length <= 500
 *     s consists of only lowercase English letters.
 */
public class ConsecutiveCharacters {

    public int maxPower(String s) {
        /**
         * Runtime: 3 ms, faster than 39.18% of Java online submissions for Consecutive Characters.
         * Memory Usage: 42.6 MB, less than 61.58% of Java online submissions for Consecutive Characters.
         */
        int res = 1;
        char temp = s.charAt(0);
        int count = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == temp){
                count++;
            } else {
                temp = s.charAt(i);
                res = Math.max(res, count);
                count = 1;
            }
        }
        return Math.max(res, count);
    }

}
