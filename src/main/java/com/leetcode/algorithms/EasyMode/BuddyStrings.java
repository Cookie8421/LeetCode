package com.leetcode.algorithms.EasyMode;

/**
 * Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
 *
 * Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
 *
 *     For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab", goal = "ba"
 * Output: true
 * Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
 *
 * Example 2:
 *
 * Input: s = "ab", goal = "ab"
 * Output: false
 * Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.
 *
 * Example 3:
 *
 * Input: s = "aa", goal = "aa"
 * Output: true
 * Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length, goal.length <= 2 * 104
 *     s and goal consist of lowercase letters.
 */
public class BuddyStrings {

    public boolean buddyStrings(String s, String goal) {
        /**
         * Runtime: 3 ms, faster than 69.12% of Java online submissions for Buddy Strings.
         * Memory Usage: 43.2 MB, less than 36.77% of Java online submissions for Buddy Strings.
         */
        if(s.length() != goal.length()){
            return false;
        }
        char[] c = s.toCharArray();
        if(s.equals(goal)){
            for(char ch:c) {
                if (s.indexOf(ch) != s.lastIndexOf(ch)) {
                    return true;
                }
            }
            return false;
        }
        int left = 0;
        int right = goal.length()-1;
        while(true){
            if(left > right){
                return false;
            }
            if(s.charAt(left) == goal.charAt(left)){
                left++;
            } else {
                if(s.charAt(right) == goal.charAt(right)){
                    right--;
                } else {
                    char t = c[left];
                    c[left] = c[right];
                    c[right] = t;
                    if(new String(c).equals(goal)){
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
    }

}
