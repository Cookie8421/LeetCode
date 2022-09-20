package com.leetcode.algorithms.MediumMode;

import java.math.BigInteger;
import java.util.*;

/**
 * Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * Output: 3
 * Explanation: The repeated subarray with maximum length is [3,2,1].
 *
 * Example 2:
 *
 * Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * Output: 5
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums1.length, nums2.length <= 1000
 *     0 <= nums1[i], nums2[i] <= 100
 */
public class MaximumLengthofRepeatedSubarray {

    int P = 113;
    int MOD = 1_000_000_007;
    int Pinv = BigInteger.valueOf(P).modInverse(BigInteger.valueOf(MOD)).intValue();

    private int[] rolling(int[] source, int length) {
        int[] ans = new int[source.length - length + 1];
        long h = 0, power = 1;
        if (length == 0) return ans;
        for (int i = 0; i < source.length; ++i) {
            h = (h + source[i] * power) % MOD;
            if (i < length - 1) {
                power = (power * P) % MOD;
            } else {
                ans[i - (length - 1)] = (int) h;
                h = (h - source[i - (length - 1)]) * Pinv % MOD;
                if (h < 0) h += MOD;
            }
        }
        return ans;
    }

    private boolean check(int guess, int[] A, int[] B) {
        Map<Integer, List<Integer>> hashes = new HashMap();
        int k = 0;
        for (int x: rolling(A, guess)) {
            hashes.computeIfAbsent(x, z -> new ArrayList()).add(k++);
        }
        int j = 0;
        for (int x: rolling(B, guess)) {
            for (int i: hashes.getOrDefault(x, new ArrayList<Integer>()))
                if (Arrays.equals(Arrays.copyOfRange(A, i, i+guess),
                        Arrays.copyOfRange(B, j, j+guess))) {
                    return true;
                }
            j++;
        }
        return false;
    }

    public int findLength(int[] A, int[] B) {
        /**
         * Runtime: 49 ms, faster than 88.97% of Java online submissions for Maximum Length of Repeated Subarray.
         * Memory Usage: 53.5 MB, less than 75.09% of Java online submissions for Maximum Length of Repeated Subarray.
         * Complexity Analysis
         *
         *     Time Complexity: O((M+N)∗log(min(M,N))), where M,N are the lengths of A, B. The log factor is contributed by the binary search, while creating the rolling hashes is O(M+N)O(M + N)O(M+N). The checks for duplicate hashes are O(1). If we perform a naive check to make sure our answer is correct, it adds a factor of O(min(M,N)) to our cost of check, which keeps the complexity the same.
         *
         *     Space Complexity: O(M), the space used to store hashes and the subarrays in our final naive check.
         */
        int lo = 0, hi = Math.min(A.length, B.length) + 1;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (check(mi, A, B)) lo = mi + 1;
            else hi = mi;
        }
        return lo - 1;
    }

    /*public int findLength(int[] nums1, int[] nums2) {
        *//**
         * Runtime: 152 ms, faster than 10.16% of Java online submissions for Maximum Length of Repeated Subarray.
         * Memory Usage: 78.5 MB, less than 36.31% of Java online submissions for Maximum Length of Repeated Subarray.
         * Complexity Analysis
         *
         *     Time Complexity: O(M∗N), where M,N are the lengths of A, B.
         *
         *     Space Complexity: O(M∗N), the space used by dp.
         *//*
        int ans = 0;
        int[][] dp = new int[nums1.length][nums2.length];
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    } else {
                        if(dp[i-1][j-1] > 0){
                            dp[i][j] = 1 + dp[i-1][j-1];
                        } else {
                            dp[i][j] = 1;
                        }
                    }
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }*/

}
