package com.leetcode.algorithms.EasyMode;

/**
 * You are given an array of strings words and a string pref.
 *
 * Return the number of strings in words that contain pref as a prefix.
 *
 * A prefix of a string s is any leading contiguous substring of s.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["pay","attention","practice","attend"], pref = "at"
 * Output: 2
 * Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".
 *
 * Example 2:
 *
 * Input: words = ["leetcode","win","loops","success"], pref = "code"
 * Output: 0
 * Explanation: There are no strings that contain "code" as a prefix.
 *
 *
 *
 * Constraints:
 *
 *     1 <= words.length <= 100
 *     1 <= words[i].length, pref.length <= 100
 *     words[i] and pref consist of lowercase English letters.
 */
public class CountingWordsWithAGivenPrefix {

    public int prefixCount(String[] words, String pref) {
        /**
         * Runtime: 1 ms, faster than 86.24% of Java online submissions for Counting Words With a Given Prefix.
         * Memory Usage: 44.4 MB, less than 5.45% of Java online submissions for Counting Words With a Given Prefix.
         */
        int res = 0;
        for(int i = 0; i < words.length; i++){
            if(words[i].length() >= pref.length() && words[i].substring(0,pref.length()).equals(pref)){
                res++;
            }
        }
        return res;
    }

}
