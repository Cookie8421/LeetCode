package com.leetcode.algorithms.MediumMode;

import java.util.Arrays;

/**
 * @Author JoeyYoung
 * @ClassName: Knight Probability in Chessboard
 * @Date 2021/12/6 10:25
 * @Description:
 * On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves.
 * The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).
 *
 * A chess knight has eight possible moves it can make, as illustrated below.
 * Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.
 *
 * Each time the knight is to move, it chooses one of eight possible moves uniformly at random
 * (even if the piece would go off the chessboard) and moves there.
 *
 * The knight continues moving until it has made exactly k moves or has moved off the chessboard.
 *
 * Return the probability that the knight remains on the board after it has stopped moving.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3, k = 2, row = 0, column = 0
 * Output: 0.06250
 * Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
 * From each of those positions, there are also two moves that will keep the knight on the board.
 * The total probability the knight stays on the board is 0.0625.
 *
 * Example 2:
 *
 * Input: n = 1, k = 0, row = 0, column = 0
 * Output: 1.00000
 *
 *
 *
 * Constraints:
 *
 *     1 <= n <= 25
 *     0 <= k <= 100
 *     0 <= row, column <= n
 */
public class KnightProbabilityInChessboard {
    //Knight can move in 8 possible directions.
    public static int[][] directions= {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};

    public static double knightProbability(int n, int k, int row, int column) {
        //memoization array--
        //2D chessboard for each step
        double[][][] dp =new double[k][n][n];
        for(double[][] arr: dp){
            for(double[] a: arr){
                Arrays.fill(a,-1);
            }
        }
        return probability(n,k,row,column,dp);
    }

    public static double probability(int n, int k,int row, int col, double[][][] dp){
        //If invalid position then return 0
        if(row<0 || row>=n || col<0 || col>=n) return 0;
        //If valid position and last step of knight then return 1
        if(k==0) return 1;
        //If value already present in dp array then return it
        if(dp[k-1][row][col] != -1) return dp[k-1][row][col];
        double res=0;
        //Traverse through each direction and decrement 1 step of knight
        for(int[] dir : directions){
            res += probability(n, k-1, row+dir[0], col+dir[1], dp)/8;
        }
        //Store probability of current position(row,col) at current step(k) in dp array
        dp[k-1][row][col]=res;
        return res;
    }
}
