package com.leetcode.algorithms.MediumMode;

/**
 * @Author JoeyYoung
 * @ClassName: Longest Palindromic Substring
 * @Date 2021/11/23 11:27
 * @Description:
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Constraints:
 *
 *     1 <= s.length <= 1000
 *     s consist of only digits and English letters.
 */
public class LongestPalindromicSubstring {

    /**
     * Runtime: 1432 ms, faster than 5.02% of Java online submissions for Longest Palindromic Substring.
     * Memory Usage: 40.4 MB, less than 36.51% of Java online submissions for Longest Palindromic Substring.
     */
    public static String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int maxLength = 1;
        String result = s.substring(0,1);
        for(int i = 0; i < charArray.length; i++){
            for(int j = charArray.length - 1; j > i; j--){
                if(charArray[i] == charArray[j]){
                    int front = i;
                    int back = j;
                    boolean isPalindrome = true;
                    while(front < back){
                        if(charArray[front++] != charArray[back--]){
                            isPalindrome = false;
                            break;
                        }
                    }
                    if(isPalindrome && j - i + 1 > maxLength){
                        maxLength = j - i + 1;
                        result = s.substring(i, j+1);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String a = "cccabababa";
        System.out.println(longestPalindrome(a));
    }

    /**
     * Optimized Solution for continuous repeating characters.
     * Expand Palindrome around center.
     *
     * Time Complexity: O(N^2)
     *
     * Space Complexity: O(1)
     *
     * N = Length of the input string s.
     */
    //Better Solution:
    /*class Solution {
    public String longestPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Input is null");
        }

        int len = s.length();
        if (len <= 1) {
            return s;
        }

        int[] maxStartOffset = new int[] { 0, 1 };
        int i = 0;

        while (i < len) {
            int start = i++;
			// Finding the continuous repeating characters
            // We can optimize by finding all such chars and treat them as the palindrome
            // center for the next expandPalindrome call.
            while (i < len && s.charAt(i) == s.charAt(start)) {
                i++;
            }
            // Expanding palindrome around the center defined by [start, i-1]
            expandPalindrome(s, start - 1, i, maxStartOffset);

            // Early Exit Condition
            // Remaining Characters = len - i - 1
            // Longest palindrome possible using remaining chars = (len - i - 1) * 2
            // We can safely exit if current maxStartOffset[1] >= (len - i - 1) * 2
            if (maxStartOffset[1] >= (len - i - 1) * 2) {
                break;
            }
        }

        return s.substring(maxStartOffset[0], maxStartOffset[0] + maxStartOffset[1]);
    }

    private void expandPalindrome(String s, int left, int right, int[] maxStartOffset) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (right - left - 1 > maxStartOffset[1]) {
            maxStartOffset[0] = left + 1;
            maxStartOffset[1] = right - left - 1;
        }
    }
}*/
}
