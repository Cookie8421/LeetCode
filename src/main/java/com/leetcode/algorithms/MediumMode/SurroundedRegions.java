package com.leetcode.algorithms.MediumMode;

/**
 * @Author JoeyYoung
 * @ClassName: Surrounded Regions
 * @Date 2021/11/19 17:17
 * @Description:
 *
 * Given an m x n matrix board containing 'X' and 'O',
 * capture all regions that are 4-directionally surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 *Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Surrounded regions should not be on the border,
 * which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 *
 * Constraints:
 *
 *     m == board.length
 *     n == board[i].length
 *     1 <= m, n <= 200
 *     board[i][j] is 'X' or 'O'.
 */

public class SurroundedRegions {

    /**
     * Runtime: 2 ms, faster than 54.83% of Java online submissions for Surrounded Regions.
     * Memory Usage: 41.2 MB, less than 47.68% of Java online submissions for Surrounded Regions.
     */
    public static void solve(char[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if( board[i][j] == 'O' && isBoundry(board, i, j)){
                    dfsMark(board, i, j);
                }
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == '1'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public static boolean isBoundry(char[][] board, int row, int col){
        if(row == 0 || col == 0 || row == board.length - 1 || col == board[row].length - 1){
            board[row][col] = '1';
            return true;
        }
        return false;
    }
    public static void dfsMark(char[][] board, int row, int col){
        if(board[row][col] == 'X'){
            return;
        }
        if(row != 0){
            board[row][col] = '1';
            if(board[row - 1][col] != '1'){
                dfsMark(board, row - 1, col);
            }
        }
        if(row != board.length - 1){
            board[row][col] = '1';
            if(board[row + 1][col] != '1'){
                dfsMark(board, row + 1, col);
            }
        }
        if(col != 0){
            board[row][col] = '1';
            if(board[row][col - 1] != '1'){
                dfsMark(board, row, col - 1);
            }
        }
        if(col != board[row].length - 1){
            board[row][col] = '1';
            if(board[row][col + 1] != '1'){
                dfsMark(board, row, col + 1);
            }
        }
    }


    public static void main(String[] args) {

        char[][] c = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(c);
        for(int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(c[i][j]);
            }
            System.out.println(",");
        }
    }
}
