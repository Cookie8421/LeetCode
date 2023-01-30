package com.leetcode.algorithms.EasyMode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The Tribonacci sequence Tn is defined as follows:
 *
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Given n, return the value of Tn.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * Example 2:
 *
 * Input: n = 25
 * Output: 1389537
 *
 *
 * Constraints:
 *
 * 0 <= n <= 37
 * The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
 */
public class NthTribonacciNumber {

    /**
     * Runtime
     * 0 ms
     * Memory
     * 39 MB
     */
    public int tribonacci(int n) {
        switch (n){
            case 0 :
                return 0;
            case 1 :
                return 1;
            case 2 :
                return 1;
            case 3 :
                return 2;
            default :
                int ans = 2;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(0);
                queue.add(1);
                queue.add(1);
                queue.add(2);
                for(int i = 0; i < n - 3; i++){
                    ans*=2;
                    ans-=queue.poll();
                    queue.add(ans);
                }
                return ans;
        }
    }

}
