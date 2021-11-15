package com.leetcode.algorithms.MediumMode;

/**
 * @Author JoeyYoung
 * @ClassName: Longest Substring Without Repeating Characters
 * @Date 2021/11/15 8:56
 * @Description:
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubstringWithoutRepeatingCharacters {


    /**
     *
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 38.9 MB, less than 88.57% of Java online submissions for Longest Substring Without Repeating Characters.
     *
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        } else if(s.length() == 1){
            return 1;
        }
        int leftIndex = 0;
        int rightIndex = 1;
        int result = 1;
        char[] sc = s.toCharArray();
        for(; rightIndex < sc.length; rightIndex++){
            if(leftIndex == rightIndex){
                continue;
            }
            for(int j = leftIndex; j < rightIndex; j++){
                if(sc[rightIndex] == sc[j]){
                    leftIndex = j + 1;
                    break;
                }
            }
            result = Math.max(rightIndex - leftIndex + 1, result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcabc"));
    }
}
