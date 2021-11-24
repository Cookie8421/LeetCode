package com.leetcode.algorithms.EasyMode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author JoeyYoung
 * @ClassName: Divisor Game
 * @Date 2021/11/24 9:40
 * @Description:
 * Alice and Bob take turns playing a game, with Alice starting first.
 *
 * Initially, there is a number n on the chalkboard.
 * On each player's turn, that player makes a move consisting of:
 *
 *     Choosing any x with 0 < x < n and n % x == 0.
 *     Replacing the number n on the chalkboard with n - x.
 *
 * Also, if a player cannot make a move, they lose the game.
 *
 * Return true if and only if Alice wins the game, assuming both players play optimally.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: true
 * Explanation: Alice chooses 1, and Bob has no more moves.
 *
 * Constraints:
 *
 *     1 <= n <= 1000
 */
public class DivisorGame {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Divisor Game.
     * Memory Usage: 37.8 MB, less than 8.55% of Java online submissions for Divisor Game.
     */
    public static boolean divisorGame(int n) {
        return divisor(n, true);
    }
    public static boolean divisor(int n, boolean isAlice){
        if(n == 1 && isAlice == false){
            return true;
        }
        for(int i = 1; i < n; i++){
            if(n % i == 0){
                return divisor(n - i, !isAlice);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(divisorGame(5));
    }
}
