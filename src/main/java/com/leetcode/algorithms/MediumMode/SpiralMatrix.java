package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JoeyYoung
 * @version 1.0.0
 * @ClassName SpiralMatrix
 * @Description TODO
 * @createTime 2022/3/28 16:18
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 *
 * Constraints:
 *
 *     m == matrix.length
 *     n == matrix[i].length
 *     1 <= m, n <= 10
 *     -100 <= matrix[i][j] <= 100
 */
public class SpiralMatrix {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
     * Memory Usage: 40.5 MB, less than 81.96% of Java online submissions for Spiral Matrix.
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int row = matrix.length;
        if(row==0) return list;
        int col = matrix[0].length;
        int l=0, r=col-1, t=0, b=row-1, d=0;
        while(l<=r && t<=b){
            if(d==0){
                for(int i=l; i<=r; i++){
                    list.add(matrix[t][i]);
                }
                d=1; t++;
            }else if(d==1){
                for(int i=t; i<=b; i++){
                    list.add(matrix[i][r]);
                }
                d=2;r--;
            }else if(d==2){
                for(int i=r; i>=l; i--){
                    list.add(matrix[b][i]);
                }
                d=3;b--;
            }else if(d==3){
                for(int i=b; i>=t; i--){
                    list.add(matrix[i][l]);
                }
                d=0;l++;
            }
        }

        return list;
    }

    enum Orientation{
        LEFT,
        RIGHT,
        UP,
        DOWN;
    }
}
