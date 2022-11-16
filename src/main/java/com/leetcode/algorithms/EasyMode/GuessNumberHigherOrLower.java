package com.leetcode.algorithms.EasyMode;

/**
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 *
 * You call a pre-defined API int guess(int num), which returns three possible results:
 *
 * -1: Your guess is higher than the number I picked (i.e. num > pick).
 * 1: Your guess is lower than the number I picked (i.e. num < pick).
 * 0: your guess is equal to the number I picked (i.e. num == pick).
 * Return the number that I picked.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 10, pick = 6
 * Output: 6
 * Example 2:
 *
 * Input: n = 1, pick = 1
 * Output: 1
 * Example 3:
 *
 * Input: n = 2, pick = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= n <= 231 - 1
 * 1 <= pick <= n
 *
 * Forward declaration of guess API.
 *  * @param  num   your guess
 *  * @return 	     -1 if num is higher than the picked number
 *  *			      1 if num is lower than the picked number
 *  *               otherwise return 0
 *  * int guess(int num);
 */
public class GuessNumberHigherOrLower {

    /**
     * Runtime
     * 0 ms
     * Memory
     * 40.7 MB
     */
    public int guessNumber(int n) {
        return helper(1, n);
    }

    public int helper(int low, int high){
        if(guess(low) == 0){
            return low;
        } else if(guess(high) == 0){
            return high;
        }
        int medium = (high-low)/2+low;
        int guess = guess(medium);
        if(guess == 0){
            return medium;
        } else if(guess == -1){
            return helper(low, medium);
        } else{
            return helper(medium, high);
        }
    }


    private int guess(int i){
        return i;
    }

}
