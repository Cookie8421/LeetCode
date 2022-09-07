package com.leetcode.algorithms.MediumMode;

import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 *
 *
 *
 * Example 1:
 *
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 *
 * Example 2:
 *
 * Input: triangle = [[-10]]
 * Output: -10
 *
 *
 *
 * Constraints:
 *
 *     1 <= triangle.length <= 200
 *     triangle[0].length == 1
 *     triangle[i].length == triangle[i - 1].length + 1
 *     -104 <= triangle[i][j] <= 104
 *
 *
 * Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
 */
public class Triangle {

    /**
     * Time Limit Exceeded
     */
    /*public int minimumTotal(List<List<Integer>> triangle) {
        int ans = 0;
        int currentIndex = 0;
        ans+=triangle.get(0).get(0);
        if(triangle.size() > 1){
            ans = Math.min(dfs(triangle, 1, currentIndex, ans), dfs(triangle, 1, currentIndex+1, ans));
        }
        return ans;
    }

    public int dfs(List<List<Integer>> triangle, int row, int currentIndex, int currentSum){
        if(row < triangle.size()){
            currentSum+=triangle.get(row).get(currentIndex);
            return Math.min(dfs(triangle, row+1, currentIndex, currentSum), dfs(triangle, row+1, currentIndex+1, currentSum));
        } else {
            return currentSum;
        }
    }*/


    /**
     * Runtime: 1 ms, faster than 99.96% of Java online submissions for Triangle.
     * Memory Usage: 42 MB, less than 93.39% of Java online submissions for Triangle.
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int[] oned:dp){
            Arrays.fill(oned, 10001);
        }
        return minimumTotalHelper(triangle, 0, 0, dp);
    }

    public int minimumTotalHelper(List<List<Integer>> triangle, int i, int j, int[][] dp){
        if(i==triangle.size()-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j]!=10001){
            return dp[i][j];
        }
        int down = triangle.get(i).get(j) + minimumTotalHelper(triangle, i+1, j, dp);
        int dia = triangle.get(i).get(j) + minimumTotalHelper(triangle, i+1, j+1, dp);
        return dp[i][j] = Math.min(down, dia);
    }

}
