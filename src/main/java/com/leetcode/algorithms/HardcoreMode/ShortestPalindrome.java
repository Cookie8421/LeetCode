package com.leetcode.algorithms.HardcoreMode;

/**
 * You are given a string s. You can convert s to a palindrome by adding characters in front of it.
 *
 * Return the shortest palindrome you can find by performing this transformation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aacecaaa"
 * Output: "aaacecaaa"
 *
 * Example 2:
 *
 * Input: s = "abcd"
 * Output: "dcbabcd"
 *
 *
 *
 * Constraints:
 *
 *     0 <= s.length <= 5 * 104
 *     s consists of lowercase English letters only.
 */
public class ShortestPalindrome {

    /*public String shortestPalindrome(String s) {
        *//**
         * Brute-Force
         * Time Limit Exceeded
         *//*
        StringBuilder stringBuilder = new StringBuilder();
        int left = 0;
        int right = s.length()-1;
        int tl = left;
        int tr = right;
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;right--;
            } else {
                left = tl;
                right = tr;
                stringBuilder.append(s.charAt(right--));
                tr = right;
                while(s.charAt(left) != s.charAt(right)){
                    stringBuilder.append(s.charAt(right--));
                    tr = right;
                }
            }
        }
        stringBuilder.append(s);
        return stringBuilder.toString();
    }*/

    /**
     * Runtime: 7 ms, faster than 76.01% of Java online submissions for Shortest Palindrome.
     * Memory Usage: 43.7 MB, less than 40.83% of Java online submissions for Shortest Palindrome.
     */
    public String shortestPalindrome(String s) {
        if(s.isEmpty())
            return s;
        String rev = new StringBuilder(s).reverse().toString();
        String merged = s + rev;
        int lps = getLPS(merged, s.length());
        if(lps >= s.length())
            return s;
        String sub = s.substring(lps);
        return new StringBuilder(sub).reverse().append(s).toString();
    }

    int getLPS(String str, int length){
        int[] lps = new int[str.length()];
        int i=1, j=0;
        while(i < str.length()){
            if(i == length)
                j = 0;
            if(str.charAt(i) == str.charAt(j)){
                lps[i] = j+1;
                i++;
                j++;
            } else {
                if(j > 0){
                    j = lps[j-1];
                } else {
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps[str.length()-1];
    }

}
