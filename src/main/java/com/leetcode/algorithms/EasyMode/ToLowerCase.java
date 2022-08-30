package com.leetcode.algorithms.EasyMode;

/**
 * Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Hello"
 * Output: "hello"
 *
 * Example 2:
 *
 * Input: s = "here"
 * Output: "here"
 *
 * Example 3:
 *
 * Input: s = "LOVELY"
 * Output: "lovely"
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 100
 *     s consists of printable ASCII characters.
 */
public class ToLowerCase {

    public String toLowerCase(String s) {
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for To Lower Case.
         * Memory Usage: 40.4 MB, less than 94.10% of Java online submissions for To Lower Case.
         */
        char[] charArr = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if('A' <= s.charAt(i) && s.charAt(i) <= 'Z'){
                charArr[i] = (char)(charArr[i] + 32);
            }
        }
        return String.valueOf(charArr);
    }

}
