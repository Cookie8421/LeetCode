package com.leetcode.algorithms.HardcoreMode;

import cn.hutool.core.lang.hash.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 *
 * Constraints:
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
public class MinimumWindowSubstring {


    public String minWindow(String s, String t) {
        /**
         * Runtime: 29 ms, faster than 45.10% of Java online submissions for Minimum Window Substring.
         * Memory Usage: 46.9 MB, less than 43.48% of Java online submissions for Minimum Window Substring.
         */
        if (t.length() > s.length() || t.equals(""))
            return "";
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for(char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
            sMap.put(c, 0);
        }
        int start=0, matched=0;
        int minLength = s.length();
        int[] result = new int[]{-1,-1};

        for (int end=0; end < s.length(); end++){
            char curr = s.charAt(end);

            // Check if current char is present in target, then update character count in source map
            if(tMap.containsKey(curr)){
                sMap.put(curr, sMap.get(curr) + 1);
                if(sMap.get(curr).equals(tMap.get(curr)))
                    matched++;
            }

            // When a valid window is found, try to reduce it until a valid window is not found
            if(matched == tMap.size()){
                // Iterate until the window is not valid
                while(matched == tMap.size()){
                    char first = s.charAt(start++);
                    // If current char is a character in target,
                    // then reduce its count from the sMap as we'll reduce its count
                    if(sMap.containsKey(first)){
                        sMap.put(first, sMap.get(first) - 1);
                        // If count of first char in window < count in tMap, then reduce the matched count
                        if(sMap.get(first) < tMap.get(first))
                            matched--;
                    }
                }
                // Update length if current length is smaller than previous
                // Note - Check 1 character before start index as the start idx was already incremented in the while loop
                if (end - (start - 1) < minLength){
                    minLength = end - (start - 1) + 1;
                    result[0] = start - 1;
                    result[1] = end;
                }
            }
        }
        return result[0] != -1 ? s.substring(result[0], result[1] + 1) : "";
    }

}
