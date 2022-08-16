package com.leetcode.algorithms.EasyMode;

import java.util.HashSet;

/**
 * Given a string s consisting of lowercase English letters, return the first letter to appear twice.
 *
 * Note:
 *
 *     A letter a appears twice before another letter b if the second occurrence of a is before the second occurrence of b.
 *     s will contain at least one letter that appears twice.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abccbaacz"
 * Output: "c"
 * Explanation:
 * The letter 'a' appears on the indexes 0, 5 and 6.
 * The letter 'b' appears on the indexes 1 and 4.
 * The letter 'c' appears on the indexes 2, 3 and 7.
 * The letter 'z' appears on the index 8.
 * The letter 'c' is the first letter to appear twice, because out of all the letters the index of its second occurrence is the smallest.
 *
 * Example 2:
 *
 * Input: s = "abcdd"
 * Output: "d"
 * Explanation:
 * The only letter that appears twice is 'd' so we return 'd'.
 *
 *
 *
 * Constraints:
 *
 *     2 <= s.length <= 100
 *     s consists of lowercase English letters.
 *     s has at least one repeated letter.
 */
public class FirstLetterToAppearTwice {

    public char repeatedCharacter(String s) {
        /**
         * Runtime: 2 ms, faster than 12.29% of Java online submissions for First Letter to Appear Twice.
         * Memory Usage: 42 MB, less than 68.98% of Java online submissions for First Letter to Appear Twice.
         */
        char res = s.charAt(0);
        HashSet hashSet = new HashSet();
        for(int i = 0; i < s.length(); i++){
            if(hashSet.contains(s.charAt(i))){
                return s.charAt(i);
            } else {
                hashSet.add(s.charAt(i));
            }
        }
        return res;


        /**
         * Runtime: 1 ms, faster than 63.38% of Java online submissions for First Letter to Appear Twice.
         * Memory Usage: 41.8 MB, less than 79.86% of Java online submissions for First Letter to Appear Twice.
         */
        /*int[] freq = new int[26];
        char c='0';
        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a'] == 1) {
                c=s.charAt(i);
                break;
            }
            freq[s.charAt(i)-'a']++;
        }
        return c;*/
    }

}
