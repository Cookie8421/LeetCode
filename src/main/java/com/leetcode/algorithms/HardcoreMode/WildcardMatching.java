package com.leetcode.algorithms.HardcoreMode;

/**
 * @Author JoeyYoung
 * @ClassName: Wildcard Matching
 * @Date 2021/12/2 15:03
 * @Description:
 * Given an input string (s) and a pattern (p),
 * implement wildcard pattern matching with support for '?' and '*' where:
 *
 *     '?' Matches any single character.
 *     '*' Matches any sequence of characters (including the empty sequence).
 *
 * The matching should cover the entire input string (not partial).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 *
 * Input: s = "aa", p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 *
 * Example 3:
 *
 * Input: s = "cb", p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 *
 * Example 4:
 *
 * Input: s = "adceb", p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 *
 * Example 5:
 *
 * Input: s = "acdcb", p = "a*c?b"
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *     0 <= s.length, p.length <= 2000
 *     s contains only lowercase English letters.
 *     p contains only lowercase English letters, '?' or '*'.
 *
 */
public class WildcardMatching {


    /**
     * Runtime: 2 ms, faster than 100.00% of Java online submissions for Wildcard Matching.
     * Memory Usage: 38.9 MB, less than 96.32% of Java online submissions for Wildcard Matching.
     */
    public boolean isMatch(String s, String p) {
        int i=0;
        int j=0;
        int starIdx=-1;
        int lastMatch=-1;

        while(i<s.length()){
            if(j<p.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')){
                i++;
                j++;
            }else if(j<p.length() && p.charAt(j)=='*'){
                starIdx=j;
                lastMatch=i;
                j++;
            }else if(starIdx!=-1){
                //there is a no match and there was a previous star, we will reset the j to indx after star_index
                //lastMatch will tell from which index we start comparing the string if we encounter * in pattern
                j=starIdx+1;
                lastMatch++; // we are saying we included more characters in * so we incremented the index
                i=lastMatch;

            }else{
                return false;
            }
        }

        while(j<p.length() && p.charAt(j)=='*') j++;

        if(i!=s.length() || j!=p.length()) return false;

        return true;
    }

    public static void main(String[] args) {
        WildcardMatching t = new WildcardMatching();
        System.out.println(t.isMatch("aabba","*a*a"));
    }

}
