package com.leetcode.algorithms.MediumMode;

import java.util.Arrays;

/**
 * You have n  tiles, where each tile has one letter tiles[i] printed on it.
 *
 * Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.
 *
 *
 *
 * Example 1:
 *
 * Input: tiles = "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 *
 * Example 2:
 *
 * Input: tiles = "AAABBC"
 * Output: 188
 *
 * Example 3:
 *
 * Input: tiles = "V"
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *     1 <= tiles.length <= 7
 *     tiles consists of uppercase English letters.
 */
public class LetterTilePossibilities {

    int count = 0;

    public void traverse(char theArray[], boolean used[]) {
        count++; // count the number of sub-permutation
        for(int i = 0; i < theArray.length; i++) {
            if( used[i] || (i > 0 && theArray[i] == theArray[i - 1] && !used[i - 1]) ) // duplicate removal
                continue;
            used[i] = true;
            traverse(theArray, used);
            used[i] = false;
        }
    }

    public int numTilePossibilities(String tiles) {
        /**
         * Runtime: 3 ms, faster than 96.56% of Java online submissions for Letter Tile Possibilities.
         * Memory Usage: 41.7 MB, less than 88.78% of Java online submissions for Letter Tile Possibilities.
         */
        char theArray[] = tiles.toCharArray();
        Arrays.sort(theArray); // sort the array for duplicate removal
        traverse(theArray, new boolean[theArray.length]);
        return count - 1;
    }

}
