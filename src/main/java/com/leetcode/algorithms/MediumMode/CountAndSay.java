package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.List;

/**
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 *
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 * To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
 *
 * For example, the saying and conversion for digit string "3322251":
 *
 *
 * Given a positive integer n, return the nth term of the count-and-say sequence.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: "1"
 * Explanation: This is the base case.
 * Example 2:
 *
 * Input: n = 4
 * Output: "1211"
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = say "1" = one 1 = "11"
 * countAndSay(3) = say "11" = two 1's = "21"
 * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 *
 *
 * Constraints:
 *
 * 1 <= n <= 30
 */
public class CountAndSay {

    public String countAndSay(int n) {
        /**
         * Runtime: 2 ms, faster than 99.34% of Java online submissions for Count and Say.
         * Memory Usage: 41.8 MB, less than 66.45% of Java online submissions for Count and Say.
         */
        if(n == 1){
            return "1";
        }
        int current = 0;
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        String ans = countAndSay(n-1);
        for(int i = 0; i < ans.length(); i++){
            int t = ans.charAt(i);
            if(current == 0){
                current = t;
                count++;
            } else{
                if(current != t){
                    stringBuilder.append(count).append(current - '0');
                    count = 1;
                    current = t;
                } else {
                    count++;
                }
            }
        }
        stringBuilder.append(count).append(current - '0');
        return stringBuilder.toString();
    }

}
