package com.leetcode.algorithms.EasyMode;

/**
 * Given an integer n, add a dot (".") as the thousands separator and return it in string format.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 987
 * Output: "987"
 *
 * Example 2:
 *
 * Input: n = 1234
 * Output: "1.234"
 *
 *
 *
 * Constraints:
 *
 *     0 <= n <= 231 - 1
 */
public class ThousandSeparator {

    public String thousandSeparator(int n) {
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Thousand Separator.
         * Memory Usage: 41.2 MB, less than 58.50% of Java online submissions for Thousand Separator.
         */
        String str = Integer.toString(n);
        int length = str.length() + (str.length()%3 > 0 ? str.length()/3 : str.length()/3 - 1);
        char[] ans = new char[length];
        int ansIndex = str.length()-1;
        int count = 0;
        for(int i = length-1; i >= 0; i--){
            if(count > 2){
                count = 0;
                ans[i] = '.';
            } else {
                ans[i] = str.charAt(ansIndex--);
                count++;
            }
        }
        return new String(ans);
    }

}
