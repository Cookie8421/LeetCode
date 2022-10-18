package com.leetcode.algorithms.MediumMode;

/**
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 * Example 2:
 *
 * Input: n = 0
 * Output: 0
 *
 * Example 3:
 *
 * Input: n = 1
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *     0 <= n <= 5 * 106
 */
public class CountPrimes {

    public int countPrimes(int n) {
        /**
         * Runtime: 106 ms, faster than 94.25% of Java online submissions for Count Primes.
         * Memory Usage: 46.8 MB, less than 87.66% of Java online submissions for Count Primes.
         */
        boolean[] arr = new boolean[n+1];
        return sieveE(n,arr);
    }
    public int sieveE(int n, boolean[] arr) {
        int count=0;
        for (int i = 2; i*i <= n; i++) {
            if (arr[i]==false) {
                for (int j = i*2; j <= n; j+=i) {
                    arr[j] = true;
                }
            }
        }

        for (int i = 2; i <n; i++) {
            if (arr[i]==false) {
                count++;
            }
        }
        return count;
    }

}
