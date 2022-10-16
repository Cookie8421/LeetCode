package com.leetcode.algorithms.MediumMode;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *
 *
 * Example 1:
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 *
 * Example 2:
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 *
 * Example 3:
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *     m == board.length
 *     n = board[i].length
 *     1 <= m, n <= 6
 *     1 <= word.length <= 15
 *     board and word consists of only lowercase and uppercase English letters.
 *
 *
 *
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        /**
         * Runtime: 118 ms, faster than 90.58% of Java online submissions for Word Search.
         * Memory Usage: 41.9 MB, less than 68.91% of Java online submissions for Word Search.
         */
        if(word.length() > board.length * board[0].length){
            return false;
        }
        int[][] dp = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0, dp)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int index, int[][] dp){
        dp[i][j] = 1;
        if(index == word.length()-1){
            return true;
        }
        if(i > 0 && dp[i-1][j] != 1 && board[i-1][j] == word.charAt(index+1)){
            if(dfs(board, word, i-1, j, index+1, dp)){
                return true;
            }
        }
        if(i < board.length-1 && dp[i+1][j] != 1 && board[i+1][j] == word.charAt(index+1)){
            if(dfs(board, word, i+1, j, index+1, dp)){
                return true;
            }
        }
        if(j > 0 && dp[i][j-1] != 1 && board[i][j-1] == word.charAt(index+1)){
            if(dfs(board, word, i, j-1, index+1, dp)){
                return true;
            }
        }
        if(j < board[i].length-1 && dp[i][j+1] != 1 && board[i][j+1] == word.charAt(index+1)){
            if(dfs(board, word, i, j+1, index+1, dp)){
                return true;
            }
        }
        dp[i][j] = 0;
        return false;
    }

}
