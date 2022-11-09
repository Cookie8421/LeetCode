package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 * Example 2:
 *
 * Input: mat = [[1,2],[3,4]]
 * Output: [1,2,3,4]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * -105 <= mat[i][j] <= 105
 */
public class DiagonalTraverse {

    /**
     * Runtime
     * 17 ms
     * Memory
     * 54.7 MB
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int i = 0,j = 0;
        int[] ans = new int[mat.length*mat[0].length];
        int index = 0;
        boolean flag = true;
        while(i < mat.length && j < mat[0].length){
            ans[index++] = mat[i][j];
            if(flag){
                if(j == mat[i].length-1){
                    i++;
                    flag = false;
                } else if(i == 0){
                    j++;
                    flag = false;
                } else {
                    i--;j++;
                }
            } else {
                if(i == mat.length-1){
                    j++;
                    flag = true;
                } else if(j == 0){
                    i++;
                    flag = true;
                } else {
                    i++;j--;
                }
            }
        }
        return ans;
    }

}
