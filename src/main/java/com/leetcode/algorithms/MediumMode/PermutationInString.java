package com.leetcode.algorithms.MediumMode;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
 */
public class PermutationInString {

    /**
     * Runtime
        1040
        ms
        Beats
        5.02%
        of users with Java
        Memory
        44.64
        MB
        Beats
        25.11%
        of users with Java
     */
    public static boolean checkInclusion(String s1, String s2) {
        int index = 0;
        int[] algebra = new int[26];
        int sum = 0;
        while(index <= s2.length() - s1.length()){
            if(!s1.contains(s2.charAt(index) + "")){
                index++;
                algebra = new int[26];
                continue;
            }
            sum = 0;
            for(int i = index; i < s1.length() + index; i++){
                char s2Char = s2.charAt(i);
                int indexOf = s1.indexOf(s2Char, algebra[s2Char-97]);
                if(indexOf != -1){
                    algebra[s2Char-97] = indexOf + 1;
                    sum++;
                } else {
                    break;
                }
            }
            if(sum == s1.length()){
                return true;
            } else {
                index++;
                algebra = new int[26];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("adc", "dcda"));
    }

}
