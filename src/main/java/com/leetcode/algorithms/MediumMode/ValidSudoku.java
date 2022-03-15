package com.leetcode.algorithms.MediumMode;


import java.util.ArrayList;
import java.util.List;

/**
 * Determine if a 9 x 9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the following rules:
 *
 *     Each row must contain the digits 1-9 without repetition.
 *     Each column must contain the digits 1-9 without repetition.
 *     Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Note:
 *
 *     A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 *     Only the filled cells need to be validated according to the mentioned rules.
 */
public class ValidSudoku {

    /**
     * Runtime: 5 ms, faster than 64.39% of Java online submissions for Valid Sudoku.
     * Memory Usage: 45.3 MB, less than 60.82% of Java online submissions for Valid Sudoku.
     */
    public static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                char current = board[i][j];
                if( (i - 48) % 3 == 0 && (j - 48) % 3 == 0){
                    List<Character> squareList = new ArrayList<>();
                    for(int a = 0; a < 3; a++){
                        for(int b = 0; b < 3; b++){
                            if(board[i+a][j+b] == '.'){
                                continue;
                            }
                            if(!squareList.contains(board[i+a][j+b])){
                                squareList.add(board[i+a][j+b]);
                            } else {
                                return false;
                            }
                        }
                    }
                }
                if(current == '.'){
                    continue;
                }
                for(int k = i+1; k < board.length; k++){
                    if(current == board[k][j]){
                        return false;
                    }
                }
                for(int l = j+1; l < board[i].length; l++){
                    if(current == board[i][l]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}}));

    }

}
