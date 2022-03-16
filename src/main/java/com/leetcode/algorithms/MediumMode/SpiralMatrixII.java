package com.leetcode.algorithms.MediumMode;


/**
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 *
 *
 *
 * Constraints:
 *
 *     1 <= n <= 20
 */
public class SpiralMatrixII {

    private int[][] matrix;

    private int x = 0, y = 0;

    private String direction = "right";

    /**
     * Runtime: 1 ms, faster than 10.14% of Java online submissions for Spiral Matrix II.
     * Memory Usage: 42 MB, less than 45.92% of Java online submissions for Spiral Matrix II.
     */
    public int[][] generateMatrix(int n) {
        if(n == 1){
            return new int[][]{{1}};
        }
        matrix = new int[n][n];
        int sum = n * n + 1;
        //genarate:
        for(int i = 1; i < sum; i++){
            switch (direction){
                case "right":
                    if(y < matrix.length - 1 && matrix[x][y+1] == 0){
                        matrix[x][y++] = i;
                    } else {
                        matrix[x++][y] = i;
                        direction = "down";
                    }
                    break;
                case "down":
                    if(x < matrix.length - 1 && matrix[x+1][y] == 0){
                        matrix[x++][y] = i;
                    } else {
                        matrix[x][y--] = i;
                        direction = "left";
                    }
                    break;
                case "left":
                    if(y > 0 && matrix[x][y-1] == 0){
                        matrix[x][y--] = i;
                    } else {
                        matrix[x--][y] = i;
                        direction = "up";
                    }
                    break;
                case "up":
                    if(x > 0 && matrix[x-1][y] == 0){
                        matrix[x--][y] = i;
                    } else {
                        matrix[x][y++] = i;
                        direction = "right";
                    }
                    break;
                case "done":
                    matrix[x][y] = i;
            }
        }
        return matrix;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix II.
     * Memory Usage: 42.2 MB, less than 32.10% of Java online submissions for Spiral Matrix II.
     */
    /*public int[][] generateMatrix(int n) {
        int[][] arr=new int[n][n];

        int a=0, b=0, k=0, s=0, e=arr.length-1, j=1;
        while(j<=n*n){
            // right
            for(int i=0; i<arr[s].length-k; i++){
                arr[a][b]=j;
                b++;
                j++;
            }
            b--;a++;k++;s++;
            if(j>n*n) break;
            // down
            for(int i=0; i<arr.length-k; i++){
                arr[a][b]=j;
                a++;
                j++;
            }
            a--; b--;

            if(j>n*n) break;
            // left
            for(int i=0; i<arr[e].length-k; i++){
                arr[a][b]=j;
                b--;
                j++;
            }
            e--;k++;a--;b++;
            if(j>n*n) break;
            // up
            for(int i=0; i<arr.length-k; i++){
                arr[a][b]=j;
                a--;
                j++;
            }
            a++;b++;
        }
        return arr;
    }*/
}
