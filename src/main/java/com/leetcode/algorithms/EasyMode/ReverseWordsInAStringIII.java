package com.leetcode.algorithms.EasyMode;

/**
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * Example 2:
 *
 * Input: s = "God Ding"
 * Output: "doG gniD"
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 5 * 104
 *     s contains printable ASCII characters.
 *     s does not contain any leading or trailing spaces.
 *     There is at least one word in s.
 *     All the words in s are separated by a single space.
 */
public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        /**
         * Runtime: 14 ms, faster than 45.52% of Java online submissions for Reverse Words in a String III.
         * Memory Usage: 50.4 MB, less than 56.12% of Java online submissions for Reverse Words in a String III.
         */
        String[] sp = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < sp.length; i++){
            if(i != 0){
                stringBuilder.append(" ");
            }
            for(int j = sp[i].length()-1; j >= 0; j--){
                stringBuilder.append(sp[i].charAt(j));
            }
        }
        return stringBuilder.toString();
    }

}
