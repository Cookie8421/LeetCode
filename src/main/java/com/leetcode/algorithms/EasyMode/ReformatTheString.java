package com.leetcode.algorithms.EasyMode;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).
 *
 * You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.
 *
 * Return the reformatted string or return an empty string if it is impossible to reformat the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "a0b1c2"
 * Output: "0a1b2c"
 * Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
 *
 * Example 2:
 *
 * Input: s = "leetcode"
 * Output: ""
 * Explanation: "leetcode" has only characters so we cannot separate them by digits.
 *
 * Example 3:
 *
 * Input: s = "1229857369"
 * Output: ""
 * Explanation: "1229857369" has only digits so we cannot separate them by characters.
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 500
 *     s consists of only lowercase English letters and/or digits.
 */
public class ReformatTheString {

    public String reformat(String s) {
        /**
         * Runtime: 19 ms, faster than 31.62% of Java online submissions for Reformat The String.
         * Memory Usage: 47.9 MB, less than 37.57% of Java online submissions for Reformat The String.
         */
        List<String> alphanumeric = new ArrayList<>();
        List<String> digit = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char tmp = s.charAt(i);
            if(tmp >= 'a' && tmp <= 'z'){
                alphanumeric.add(String.valueOf(tmp));
            } else if(tmp >= '0' && tmp <= '9'){
                digit.add(String.valueOf(tmp));
            }
        }
        if(Math.abs(alphanumeric.size() - digit.size()) > 1){
            return "";
        } else if(alphanumeric.size() > digit.size()){
            for(int j = 0; j < s.length(); j++){
                if(j%2==0){
                    stringBuilder.append(alphanumeric.get(0));
                    alphanumeric.remove(0);
                } else {
                    stringBuilder.append(digit.get(0));
                    digit.remove(0);
                }
            }
        } else {
            for(int j = 0; j < s.length(); j++){
                if(j%2!=0){
                    stringBuilder.append(alphanumeric.get(0));
                    alphanumeric.remove(0);
                } else {
                    stringBuilder.append(digit.get(0));
                    digit.remove(0);
                }
            }
        }
        return stringBuilder.toString();


        /**
         * Runtime: 5 ms, faster than 87.30% of Java online submissions for Reformat The String.
         * Memory Usage: 43.6 MB, less than 73.78% of Java online submissions for Reformat The String.
         */
        /*
        char[] anums = s.toCharArray();
        StringBuilder digits = new StringBuilder();

        for(char ch : anums) {
            if('0' <= ch && ch <= '9') {
                digits.append(ch);
            }
        }

        int diff =  2 * digits.length() - s.length();
        if(-1 > diff || diff > 1)  return "";

        int i = 0;
        int j = 1;
        int offset = 0;
        // inserting letters into digits;
        for(char ch : anums) {
            // skip digits
            if( '0' <= ch && ch <= '9') continue;

            offset =  diff == 1 ? j :  i++ * 2;
            digits.insert(offset, ch);
            j += 2;
        }

        return digits.toString();
         */
    }

}
