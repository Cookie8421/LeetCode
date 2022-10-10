package com.leetcode.algorithms.MediumMode;

/**
 * Given a palindromic string of lowercase English letters palindrome, replace exactly one character with any lowercase English letter so that the resulting string is not a palindrome and that it is the lexicographically smallest one possible.
 *
 * Return the resulting string. If there is no way to replace a character to make it not a palindrome, return an empty string.
 *
 * A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, a has a character strictly smaller than the corresponding character in b. For example, "abcc" is lexicographically smaller than "abcd" because the first position they differ is at the fourth character, and 'c' is smaller than 'd'.
 *
 *
 *
 * Example 1:
 *
 * Input: palindrome = "abccba"
 * Output: "aaccba"
 * Explanation: There are many ways to make "abccba" not a palindrome, such as "zbccba", "aaccba", and "abacba".
 * Of all the ways, "aaccba" is the lexicographically smallest.
 *
 * Example 2:
 *
 * Input: palindrome = "a"
 * Output: ""
 * Explanation: There is no way to replace a single character to make "a" not a palindrome, so return an empty string.
 *
 *
 *
 * Constraints:
 *
 *     1 <= palindrome.length <= 1000
 *     palindrome consists of only lowercase English letters.
 */
public class BreakAPalindrome {

    public String breakPalindrome(String palindrome) {
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Break a Palindrome.
         * Memory Usage: 41.9 MB, less than 66.45% of Java online submissions for Break a Palindrome.
         */
        if(palindrome.length() == 1){
            return "";
        }
        boolean isEven = true;
        if((palindrome.length() & 1) == 1){
            isEven = false;
        }
        char[] t = palindrome.toCharArray();
        boolean flag = false;
        for(int i = 0; i < palindrome.length(); i++){
            if(!isEven && i == palindrome.length()/2){
                continue;
            }
            if(t[i] > 'a'){
                t[i] = 'a';
                flag = true;
                break;
            }
        }
        if(flag){
            return String.valueOf(t);
        } else {
            return palindrome.substring(0, palindrome.length()-1) + 'b';
        }
    }

}
