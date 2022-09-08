package com.leetcode.algorithms.MediumMode;

/**
 * Given two integers a and b, return any string s such that:
 *
 *     s has length a + b and contains exactly a 'a' letters, and exactly b 'b' letters,
 *     The substring 'aaa' does not occur in s, and
 *     The substring 'bbb' does not occur in s.
 *
 *
 *
 * Example 1:
 *
 * Input: a = 1, b = 2
 * Output: "abb"
 * Explanation: "abb", "bab" and "bba" are all correct answers.
 *
 * Example 2:
 *
 * Input: a = 4, b = 1
 * Output: "aabaa"
 *
 *
 *
 * Constraints:
 *
 *     0 <= a, b <= 100
 *     It is guaranteed such an s exists for the given a and b.
 */
public class StringWithoutAAAOrBBB {

    public String strWithout3a3b(int a, int b) {
        /**
         * Runtime: 1 ms, faster than 89.90% of Java online submissions for String Without AAA or BBB.
         * Memory Usage: 41.3 MB, less than 71.76% of Java online submissions for String Without AAA or BBB.
         */
        int length = a+b;
        StringBuilder stringBuilder = new StringBuilder();
        int countA = 0;
        int countB = 0;
        for(int i = 0; i < length; i++){
            if(a > b){
                if(++countA < 3){
                    countB = 0;
                    stringBuilder.append('a');a--;
                } else {
                    countA = 0;
                    countB = 1;
                    stringBuilder.append('b');b--;
                }
            } else {
                if(++countB < 3){
                    countA = 0;
                    stringBuilder.append('b');b--;
                } else {
                    countB = 0;
                    countA = 1;
                    stringBuilder.append('a');a--;
                }
            }
        }
        return stringBuilder.toString();
    }

}
