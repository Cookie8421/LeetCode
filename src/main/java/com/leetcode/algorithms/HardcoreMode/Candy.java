package com.leetcode.algorithms.HardcoreMode;

import java.util.Arrays;

/**
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 *
 *
 *
 * Example 1:
 *
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * Example 2:
 *
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 *
 *
 * Constraints:
 *
 * n == ratings.length
 * 1 <= n <= 2 * 104
 * 0 <= ratings[i] <= 2 * 104
 */
public class Candy {


    /**
     * Two-Pass Greedy
     * Runtime
     * 3 ms
     * Beats
     * 79.95%
     * Memory
     * 43.9 MB
     * Beats
     * 44.79%
     *
     * Detailed Steps
     * Step 1: Initialize Candies Array
     *
     * Initialize an array candies of length n with all values set to 1. This ensures the first condition is met: every child gets at least one candy.
     * Step 2: Forward Pass
     *
     * Iterate through the array from left to right. If a child has a higher rating than their left neighbor, they get one more candy than that neighbor.
     * Step 3: Backward Pass
     *
     * Iterate through the array from right to left. If a child has a higher rating than their right neighbor, they get the maximum of their current candies and one more than that neighbor.
     * Step 4: Calculate Total Candies
     *
     * Sum up the candies array to get the minimum total number of candies needed.
     * Time and Space Complexity
     * Time Complexity: O(n), because we make two passes through the array.
     * Space Complexity: O(n), for storing the candies array.
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }

    /**
     * Runtime
     * 479 ms
     * Beats
     * 8.11%
     * Memory
     * 43.8 MB
     * Beats
     * 54.9%
     */
    /*public int candy(int[] ratings) {
        int res = 0;
        int length = ratings.length;
        if(length == 1){
            return 1;
        }
        int[] candy = new int[length];
        Arrays.fill(candy, 1);
        int left = 0;
        int right = 1;
        while(right < length){
            if(ratings[left] > ratings[right]){
                int _left = left;
                int _right = right;
                while(_left >= 0 && candy[_left] <= candy[_right]){
                    if(ratings[_left] > ratings[_right]){
                        res+=(candy[_right]-candy[_left]+1);
                        candy[_left] = candy[_right]+1;
                    } else if(ratings[_left] < ratings[_right]){
                        break;
                    }
                    _left--;_right--;
                }
            } else {
                if(candy[left] >= candy[right]){
                    res+=(candy[left]-candy[right]+1);
                    candy[right] = candy[left]+1;
                }
            }
            left++;right++;
        }
        return res+length;
    }*/

}
