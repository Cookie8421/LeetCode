package com.leetcode.algorithms.MediumMode;


/**
 * @author YHW
 * @ClassName: SearchA2DMatrix
 * @Description:
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 *
 *     Integers in each row are sorted from left to right.
 *     The first integer of each row is greater than the last integer of the previous row.
 * @date 2021/10/28 11:04
 */

public class SearchA2DMatrix {


    /**
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
     * Memory Usage: 38.8 MB, less than 48.54% of Java online submissions for Search a 2D Matrix.
     *
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        if(target < matrix[0][0]){
            return false;
        }
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] <= target){
                row = i;
            } else {
                break;
            }
        }
            return findCol(matrix, target, 0, matrix[row].length-1, row);
    }

    public static boolean findCol(int[][] matrix, int target, int leftIndex, int rightIndex, int row){
        int midIndex = (rightIndex - leftIndex) / 2 + leftIndex;
        if(matrix[row][leftIndex] == target || matrix[row][rightIndex] == target){
            return true;
        }
        while(rightIndex > leftIndex + 1){
            if(matrix[row][midIndex] == target){
                return true;
            } else if(matrix[row][midIndex] > target) {
                return findCol(matrix, target, leftIndex, midIndex, row);
            } else if(matrix[row][midIndex] < target) {
                return findCol(matrix, target, midIndex, rightIndex, row);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(SearchA2DMatrix.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13));
    }
}
