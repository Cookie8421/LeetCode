package com.leetcode.algorithms.MediumMode;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 *
 * Constraints:
 *
 *     m == grid.length
 *     n == grid[i].length
 *     1 <= m, n <= 300
 *     grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        /**
         * Runtime: 5 ms, faster than 55.04% of Java online submissions for Number of Islands.
         * Memory Usage: 58 MB, less than 18.46% of Java online submissions for Number of Islands.
         */
        Integer ans = 0;
        int[][] temp = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1' && temp[i][j] != -1) {
                    dfs(grid, temp, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int[][] temp, int i, int j){
        if(grid[i][j] == '1' && temp[i][j] != -1){
            temp[i][j] = -1;
            if(i > 0){
                dfs(grid, temp, i-1, j);
            }
            if(i < grid.length-1){
                dfs(grid, temp, i+1, j);
            }
            if(j > 0){
                dfs(grid, temp, i, j-1);
            }
            if(j < grid[i].length-1){
                dfs(grid, temp, i, j+1);
            }
        }
    }

}
