package com.leetcode.Learning.Note;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.
 *
 * In one shift operation:
 *
 *     Element at grid[i][j] moves to grid[i][j + 1].
 *     Element at grid[i][n - 1] moves to grid[i + 1][0].
 *     Element at grid[m - 1][n - 1] moves to grid[0][0].
 *
 * Return the 2D grid after applying shift operation k times.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * Output: [[9,1,2],[3,4,5],[6,7,8]]
 *
 * Example 2:
 *
 * Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 *
 * Example 3:
 *
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * Output: [[1,2,3],[4,5,6],[7,8,9]]
 *
 *
 *
 * Constraints:
 *
 *     m == grid.length
 *     n == grid[i].length
 *     1 <= m <= 50
 *     1 <= n <= 50
 *     -1000 <= grid[i][j] <= 1000
 *     0 <= k <= 100
 */
public class Shift2DGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        /**
         * Runtime: 4 ms, faster than 96.23% of Java online submissions for Shift 2D Grid.
         * Memory Usage: 54.5 MB, less than 63.52% of Java online submissions for Shift 2D Grid.
         */
        // just bruteforce??? O(i*j*k)
        // instead we calculate the final position at once!

        int m = grid.length;  // row
        int n = grid[0].length;  // column

        int[][] arr = new int[m][n];

        // Since moving m*n times will result in same matrix, we do this:
        k = k % (m*n);

        // Then we move each element
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // for calculating column, it back to the original position
                // every n steps
                int column = (j + k) % n;

                // for calculating row, we move to the next row each time
                // it exceed the last element on the current row.
                // For example when 2 moves k=5 steps it turns to the (+2) row.
                // Thus it's original row + ((original column + steps) / n)
                // But if 2 moves k=8 steps it turns to the (0,0),
                // and row + ((original column + steps) / n) gives 0+(9/3)=3 (out of bounds)
                // so we'll need to % number of rows to get 0. (circle back)
                int row = (i + ((j + k) / n)) % m;
                arr[row][column] = grid[i][j];
            }
        }
        return (List) Arrays.asList(arr);
    }

}
