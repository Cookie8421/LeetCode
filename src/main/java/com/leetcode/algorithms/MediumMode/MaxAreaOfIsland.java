package com.leetcode.algorithms.MediumMode;


/**
 * You are given an m x n binary matrix grid. An island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: grid =
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 *
 * Example 2:
 *
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *     m == grid.length
 *     n == grid[i].length
 *     1 <= m, n <= 50
 *     grid[i][j] is either 0 or 1.
 */
public class MaxAreaOfIsland {

    int[][] grid;
    boolean[][] seen;

    public int area(int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || seen[r][c] || grid[r][c] == 0) {
            return 0;
        }
        seen[r][c] = true;
        return 1 + area(r+1, c) + area(r-1, c) + area(r, c+1) + area(r, c-1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        int result = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                result = Math.max(result, area(r, c));
            }
        }

        return result;
    }

    /*public int maxAreaOfIsland(int[][] grid) {
        int[] res = {0};
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                recur(grid, i, j, res, false);
            }
        }
        return res[0];
    }

    public void recur(int[][] grid, int i, int j, int[] res, boolean continuously){
        if(grid[i][j] == 1){
            grid[i][j] = 0;
            if(i < grid.length - 1 && grid[i+1][j] == 1){
                recur(grid, i+1, j, res, true);
            }
            if(j < grid[i].length - 1 && grid[i][j+1] == 1){
                recur(grid, i, j+1, res, true);
            }
            if(i > 0 && grid[i-1][j] == 1){
                recur(grid, i-1, j, res, true);
            }
            if(j > 0 && grid[i][j-1] == 1){
                recur(grid, i, j-1, res, true);
            }
            if(!continuously){
                res[0] += 1;
            }
        }
    }*/

}
