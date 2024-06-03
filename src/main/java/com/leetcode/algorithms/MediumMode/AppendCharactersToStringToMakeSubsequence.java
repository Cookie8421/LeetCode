package com.leetcode.algorithms.MediumMode;

/**
 * You are given two strings s and t consisting of only lowercase English letters.

Return the minimum number of characters that need to be appended to the end of s so that t becomes a subsequence of s.

A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.

 

Example 1:

Input: s = "coaching", t = "coding"
Output: 4
Explanation: Append the characters "ding" to the end of s so that s = "coachingding".
Now, t is a subsequence of s ("coachingding").
It can be shown that appending any 3 characters to the end of s will never make t a subsequence.
Example 2:

Input: s = "abcde", t = "a"
Output: 0
Explanation: t is already a subsequence of s ("abcde").
Example 3:

Input: s = "z", t = "abcde"
Output: 5
Explanation: Append the characters "abcde" to the end of s so that s = "zabcde".
Now, t is a subsequence of s ("zabcde").
It can be shown that appending any 4 characters to the end of s will never make t a subsequence.
 

Constraints:

1 <= s.length, t.length <= 105
s and t consist only of lowercase English letters.
 */
public class AppendCharactersToStringToMakeSubsequence {

    /**
     * Runtime
        8
        ms
        Beats
        8.26%
        of users with Java
        Memory
        45.36
        MB
        Beats
        35.15%
        of users with Java
     */
    public static int appendCharacters(String s, String t) {
        int currentIndex = 0;
        int res = t.length();
        for(int i = 0; i < s.length(); i++){
            if(currentIndex >= t.length()){
                return res;
            }
            if(s.charAt(i) == t.charAt(currentIndex)){
                res--;
                currentIndex++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(appendCharacters("z", "abcde"));
    }

}
