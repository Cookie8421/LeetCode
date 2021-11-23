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
}
