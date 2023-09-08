package com.leetcode.algorithms.MediumMode;

/**
 * Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.
 *
 *
 *
 * Example 1:
 *
 * Input: left = 5, right = 7
 * Output: 4
 * Example 2:
 *
 * Input: left = 0, right = 0
 * Output: 0
 * Example 3:
 *
 * Input: left = 1, right = 2147483647
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= left <= right <= 231 - 1
 */
public class BitwiseANDOfNumbersRange {

    /**
     * Runtime
     * 4 ms
     * Beats
     * 40.31%
     * Memory
     * 43.1 MB
     * Beats
     * 25.94%
     */
    public int rangeBitwiseAnd(int left, int right) {
        /*
            Runtime
            3 ms
            Beats
            100%
            Memory
            42.9 MB
            Beats
            46.35%
        while(right>left)
           right = right & right-1;
        return right;
         */
        int res = 0;
        if(left == right){
            res = left;
        } else {
            String binLeft = Integer.toBinaryString(left);
            String binRight = Integer.toBinaryString(right);
            if(binLeft.length() != binRight.length()){
                return 0;
            }
            int i = 0;
            while(i < binLeft.length()){
                if(binLeft.charAt(i) == '1' && binRight.charAt(i) == '1'){
                    res+=Math.pow(2, binLeft.length()-1-i++);
                } else if(binLeft.charAt(i) == '0' && binRight.charAt(i) == '0'){
                    i++;
                    continue;
                } else {
                    break;
                }
            }
        }
        return res;
    }

}
