package com.leetcode.algorithms.MediumMode;

/**
 * @author JoeyYoung
 * @version 1.0.0
 * @ClassName MultiplyStrings
 * @Description
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 *
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 *
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 *
 *
 * Constraints:
 *
 *     1 <= num1.length, num2.length <= 200
 *     num1 and num2 consist of digits only.
 *     Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * @createTime 2022/4/7 13:40
 */
public class MultiplyStrings {

    /**
     * Runtime: 7 ms, faster than 62.61% of Java online submissions for Multiply Strings.
     * Memory Usage: 43.2 MB, less than 46.39% of Java online submissions for Multiply Strings.
     */
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        if (m == 0 || n == 0 || "0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        if ("1".equals(num1)) {
            return num2;
        }
        if ("1".equals(num2)) {
            return num1;
        }
        int[] result = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // Adding previous values in result array into this product.
                product += result[i + j + 1];

                // Adding the new product into the result array
                result[i + j + 1] = product % 10;
                result[i + j] += product / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int r : result) {
            if (sb.length() == 0 && r == 0) {
                continue;
            }
            sb.append(r);
        }

        return sb.toString();
    }

}
