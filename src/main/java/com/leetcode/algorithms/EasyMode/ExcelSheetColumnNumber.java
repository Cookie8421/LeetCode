package com.leetcode.algorithms.EasyMode;

/**
 * Given a string columnTitle that represents the column title as appears in an Excel sheet,
 * return its corresponding column number.
 *
 * For example:
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 *
 *
 * Example 1:
 *
 * Input: columnTitle = "A"
 * Output: 1
 *
 * Example 2:
 *
 * Input: columnTitle = "AB"
 * Output: 28
 *
 * Example 3:
 *
 * Input: columnTitle = "ZY"
 * Output: 701
 *
 *
 *
 * Constraints:
 *
 *     1 <= columnTitle.length <= 7
 *     columnTitle consists only of uppercase English letters.
 *     columnTitle is in the range ["A", "FXSHRXW"].
 */
public class ExcelSheetColumnNumber {

    /**
     * Runtime: 2 ms, faster than 78.52% of Java online submissions for Excel Sheet Column Number.
     * Memory Usage: 42.9 MB, less than 44.24% of Java online submissions for Excel Sheet Column Number.
     */
    public String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public int titleToNumber(String columnTitle) {
        int sum = 0;
        int length = columnTitle.length();
        for(int i = 0; i < length; i++){
            sum += (alphabet.indexOf(columnTitle.charAt(i)) + 1) * Math.pow(26, length-i-1);
        }
        return sum;
    }

}
