package com.leetcode.algorithms.EasyMode;

/**
 * You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 *
 * We repeatedly make duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 * Example 2:
 *
 * Input: s = "azxxzy"
 * Output: "ay"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 */
public class RemoveAllAdjacentDuplicatesInString {

    /**
     * Runtime
     * 1531 ms
     * Memory
     * 469.7 MB
     */
    public String removeDuplicates(String s) {
        int l = 0;
        int r = 1;
        while(r < s.length()){
            if(s.charAt(l) == s.charAt(r)){
                s = l == 0 ? s.substring(r+1) : s.substring(0,l) + s.substring(r+1);
                l = l>0 ? l-1 : 0;
                r = l+1;
                continue;
            } else {
                l++;
                r++;
            }
        }
        return s;
    }

}
