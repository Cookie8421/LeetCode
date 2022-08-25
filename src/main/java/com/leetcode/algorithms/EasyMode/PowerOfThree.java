package com.leetcode.algorithms.EasyMode;


/**
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 *
 * An integer n is a power of three, if there exists an integer x such that n == 3x.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 27
 * Output: true
 *
 * Example 2:
 *
 * Input: n = 0
 * Output: false
 *
 * Example 3:
 *
 * Input: n = 9
 * Output: true
 *
 *
 *
 * Constraints:
 *
 *     -231 <= n <= 231 - 1
 *
 *
 * Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        /**
         * Runtime: 15 ms, faster than 98.30% of Java online submissions for Power of Three.
         * Memory Usage: 41.6 MB, less than 99.28% of Java online submissions for Power of Three.
         */
        if(n == 0){
            return false;
        }
        while(true){
            if(n != 0){
                if(n%3 == 0){
                    n = n/3;
                } else if (n == 1){
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

}
