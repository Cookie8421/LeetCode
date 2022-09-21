package com.leetcode.algorithms.MediumMode;

import java.util.ArrayDeque;

/**
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 *
 * The test cases are generated so that the length of the output will never exceed 105.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 *
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 *
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 30
 *     s consists of lowercase English letters, digits, and square brackets '[]'.
 *     s is guaranteed to be a valid input.
 *     All the integers in s are in the range [1, 300].
 */
public class DecodeString {

    public String decodeString(String s) {
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Decode String.
         * Memory Usage: 40.3 MB, less than 94.85% of Java online submissions for Decode String.
         */
        StringBuilder ans = new StringBuilder();
        ArrayDeque<Object> arrayDeque = new ArrayDeque();
        int currentCount = 0;
        StringBuilder stringBuidler = new StringBuilder();
        for(char c : s.toCharArray()){
            if('0' <= c && c <= '9'){
                if(currentCount == 0){
                    currentCount = c - '0';
                } else {
                    currentCount = currentCount * 10 + c - '0';
                }
                if(stringBuidler.toString().length() > 0){
                    arrayDeque.push(stringBuidler.toString());
                    stringBuidler = new StringBuilder();
                }
            } else if('a' <= c && c <= 'z'){
                stringBuidler.append(c);
            } else if(c == '['){
                arrayDeque.push(currentCount);
                currentCount = 0;
            } else if(c == ']'){
                if(arrayDeque.size() > 0){
                    if(arrayDeque.peek() instanceof Integer){
                        String temp = stringBuidler.toString();
                        int t = (int)arrayDeque.pop();
                        for(int i = 0; i < t-1; i++){
                            stringBuidler.append(temp);
                        }
                    }
                    while(arrayDeque.peek() instanceof String){
                        stringBuidler.insert(0, arrayDeque.pop());
                    }
                }
            }
        }
        ans.append(stringBuidler);
        return ans.toString();
    }

}
