package com.leetcode.algorithms.EasyMode;

import java.util.Arrays;
import java.util.List;

/**
 * You are given a string s formed by digits and '#'. We want to map s to English lowercase characters as follows:
 *
 *     Characters ('a' to 'i') are represented by ('1' to '9') respectively.
 *     Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
 *
 * Return the string formed after mapping.
 *
 * The test cases are generated so that a unique mapping will always exist.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "10#11#12"
 * Output: "jkab"
 * Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 *
 * Example 2:
 *
 * Input: s = "1326#"
 * Output: "acz"
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 1000
 *     s consists of digits and the '#' letter.
 *     s will be a valid string such that mapping is always possible.
 */
public class DecryptStringFromAlphabetToIntegerMapping {

    public String freqAlphabets(String s) {
        /**
         * Runtime: 1 ms, faster than 92.14% of Java online submissions for Decrypt String from Alphabet to Integer Mapping.
         * Memory Usage: 41.7 MB, less than 87.91% of Java online submissions for Decrypt String from Alphabet to Integer Mapping.
         */
        StringBuilder stringBuilder = new StringBuilder();
        int n=s.length();
        for (int i = n-1; i >=0 ; i--) {
            char c= s.charAt(i);
            if(c=='#'){
                if(s.charAt(i-2)=='2'){
                    stringBuilder.append((char)('j'+Character.getNumericValue(s.charAt(i-1))+10));
                } else {
                    stringBuilder.append((char)('j'+Character.getNumericValue(s.charAt(i-1))));
                }
                i-=2;
            }
            else{
                stringBuilder.append((char)('a'+Character.getNumericValue(s.charAt(i))-1));
            }
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

}
