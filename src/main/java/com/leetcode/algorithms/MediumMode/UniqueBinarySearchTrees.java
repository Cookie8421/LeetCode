package com.leetcode.algorithms.MediumMode;


/**
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3
 * Output: 5
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= n <= 19
 */
public class UniqueBinarySearchTrees {

    public static int[] cacheArr;

    public int numTrees(int n) {
        cacheArr = new int[n];
        int res = recursion(n);
        return res;
    }

    /**
     * Runtime
     * 0 ms
     * Beats
     * 100%
     * Memory
     * 39.1 MB
     * Beats
     * 72.39%
     */
    public int recursion(int nodeNum){
        if(nodeNum == 1 || nodeNum == 0){
            return 1;
        }
        if(cacheArr[nodeNum-1] != 0){
            return cacheArr[nodeNum-1];
        }
        int sum = 0;
        for(int i = 1; i <= nodeNum; i++){
            sum += (recursion(i-1) * recursion(nodeNum-i));
        }
        cacheArr[nodeNum-1] = sum;
        return sum;
    }
}
