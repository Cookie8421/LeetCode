package com.leetcode.algorithms.EasyMode;

import lombok.var;

import java.util.HashMap;

/**
 * You are given two 0-indexed strings s and target. You can take some letters from s and rearrange them to form new strings.
 *
 * Return the maximum number of copies of target that can be formed by taking letters from s and rearranging them.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ilovecodingonleetcode", target = "code"
 * Output: 2
 * Explanation:
 * For the first copy of "code", take the letters at indices 4, 5, 6, and 7.
 * For the second copy of "code", take the letters at indices 17, 18, 19, and 20.
 * The strings that are formed are "ecod" and "code" which can both be rearranged into "code".
 * We can make at most two copies of "code", so we return 2.
 *
 * Example 2:
 *
 * Input: s = "abcba", target = "abc"
 * Output: 1
 * Explanation:
 * We can make one copy of "abc" by taking the letters at indices 0, 1, and 2.
 * We can make at most one copy of "abc", so we return 1.
 * Note that while there is an extra 'a' and 'b' at indices 3 and 4, we cannot reuse the letter 'c' at index 2, so we cannot make a second copy of "abc".
 *
 * Example 3:
 *
 * Input: s = "abbaccaddaeea", target = "aaaaa"
 * Output: 1
 * Explanation:
 * We can make one copy of "aaaaa" by taking the letters at indices 0, 3, 6, 9, and 12.
 * We can make at most one copy of "aaaaa", so we return 1.
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 100
 *     1 <= target.length <= 10
 *     s and target consist of lowercase English letters.
 */
public class RearrangeCharactersToMakeTargetString {

    public int rearrangeCharacters(String s, String target) {
        /**
         * Runtime: 3 ms, faster than 27.39% of Java online submissions for Rearrange Characters to Make Target String.
         * Memory Usage: 42.5 MB, less than 19.40% of Java online submissions for Rearrange Characters to Make
         */
        HashMap<Character,Integer[]> multiple = new HashMap();
        int res = -1;
        for(int i = 0; i < target.length(); i++){
            if(multiple.containsKey(target.charAt(i))){
                Integer[] t = multiple.get(target.charAt(i));
                t[0]++;
                multiple.replace(target.charAt(i), t);
            } else {
                multiple.put(target.charAt(i), new Integer[]{1,0});
            }
        }
        for(int j = 0; j < s.length(); j++){
            if(multiple.containsKey(s.charAt(j))){
                Integer[] t = multiple.get(s.charAt(j));
                t[1]++;
            }
        }
        for(var map : multiple.entrySet()){
            Integer[] t = map.getValue();
            t[1] = t[1]/t[0];
            if((res == -1) || (t[1] < res)){
                res = t[1];
            }
        }
        return res;


        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rearrange Characters to Make Target String.
         * Memory Usage: 40 MB, less than 99.14% of Java online submissions for Rearrange Characters to Make Target String.
         */
        /*
        int answer = s.length();
        int[] countString = new int[26];
        int[] countTarget = new int[26];
        for (char c: s.toCharArray()) {
            ++countString[c - 'a'];
        }
        for(char c: target.toCharArray()) {
            ++countTarget[c - 'a'];
        }
        for(char c: target.toCharArray()) {
            answer = Math.min(answer, countString[c - 'a'] / countTarget[c - 'a']);
        }
        return answer;
         */
    }

}
