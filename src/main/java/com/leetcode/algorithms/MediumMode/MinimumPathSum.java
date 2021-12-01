package com.leetcode.algorithms.MediumMode;

/**
 * @Author JoeyYoung
 * @ClassName: Minimum Path Sum
 * @Date 2021/12/1 16:21
 * @Description:
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right,
 * which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 *
 * Example 2:
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *
 *
 *
 * Constraints:
 *
 *     m == grid.length
 *     n == grid[i].length
 *     1 <= m, n <= 200
 *     0 <= grid[i][j] <= 100
 */
public class MinimumPathSum {

    /**
     * Runtime: 2 ms, faster than 84.79% of Java online submissions for Minimum Path Sum.
     * Memory Usage: 42.1 MB, less than 43.12% of Java online submissions for Minimum Path Sum.
     */
    public static int minPathSum(int[][] grid) {
        int[][] result = new int[grid.length][grid[0].length];
        result[0][0] = grid[0][0];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                if(i == 0){
                    result[i][j] = result[i][j-1] + grid[i][j];
                } else if(j == 0){
                    result[i][j] = result[i-1][j] + grid[i][j];
                } else {
                    result[i][j] = Math.min(result[i-1][j], result[i][j-1]) + grid[i][j];
                }
            }
        }
        return result[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }

}
