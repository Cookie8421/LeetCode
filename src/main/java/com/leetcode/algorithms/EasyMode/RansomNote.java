package com.leetcode.algorithms.EasyMode;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 *
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 *
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 *
 *
 * Constraints:
 *
 *     1 <= ransomNote.length, magazine.length <= 105
 *     ransomNote and magazine consist of lowercase English letters.
 */
public class RansomNote {


    public boolean canConstruct(String ransomNote, String magazine) {
        /**
         * Runtime: 6 ms, faster than 63.99% of Java online submissions for Ransom Note.
         * Memory Usage: 45.3 MB, less than 81.66% of Java online submissions for Ransom Note.
         */
        int[] a = new int[26];
        int[] b = new int[26];
        for(int i = 0; i < ransomNote.length(); i++){
            a[ransomNote.charAt(i) - 'a']+=1;
        }
        for(int i = 0; i < magazine.length(); i++){
            b[magazine.charAt(i) - 'a']+=1;
        }
        for(int i = 0; i < 26; i++){
            if(a[i] < b[i]){
                return false;
            }
        }
        return true;
    }


}
