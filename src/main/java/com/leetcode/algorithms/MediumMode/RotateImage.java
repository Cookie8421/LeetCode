package com.leetcode.algorithms.MediumMode;

/**
 * @author JoeyYoung
 * @version 1.0.0
 * @ClassName RotateImage
 * @Description TODO
 * @createTime 2022/3/28 14:39
 *
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 *
 * Example 2:
 *
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 *
 *
 * Constraints:
 *
 *     n == matrix.length == matrix[i].length
 *     1 <= n <= 20
 *     -1000 <= matrix[i][j] <= 1000
 */
public class RotateImage {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
     * Memory Usage: 42.9 MB, less than 47.54% of Java online submissions for Rotate Image.
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] ans = new int[n][n];
        for(int i=n-1; i>= 0; i--){
            for(int j=0; j<n; j++){
                ans[j][n-1-i] = matrix[i][j];
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = ans[i][j];
            }
        }
    }

}
