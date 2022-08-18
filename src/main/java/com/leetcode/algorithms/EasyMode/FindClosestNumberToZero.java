package com.leetcode.algorithms.EasyMode;

/**
 * Given an integer array nums of size n, return the number with the value closest to 0 in nums. If there are multiple answers, return the number with the largest value.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-4,-2,1,4,8]
 * Output: 1
 * Explanation:
 * The distance from -4 to 0 is |-4| = 4.
 * The distance from -2 to 0 is |-2| = 2.
 * The distance from 1 to 0 is |1| = 1.
 * The distance from 4 to 0 is |4| = 4.
 * The distance from 8 to 0 is |8| = 8.
 * Thus, the closest number to 0 in the array is 1.
 *
 * Example 2:
 *
 * Input: nums = [2,-1,1]
 * Output: 1
 * Explanation: 1 and -1 are both the closest numbers to 0, so 1 being larger is returned.
 *
 *
 *
 * Constraints:
 *
 *     1 <= n <= 1000
 *     -105 <= nums[i] <= 105
 */
public class FindClosestNumberToZero {

    public int findClosestNumber(int[] nums) {
        /**
         * Runtime: 3 ms, faster than 68.45% of Java online submissions for Find Closest Number to Zero.
         * Memory Usage: 51.2 MB, less than 80.61% of Java online submissions for Find Closest Number to Zero.
         */
        int maxInMin = nums[0];
        int min = Math.abs(nums[0]);
        for(int i = 1; i < nums.length; i++){
            int t = Math.abs(nums[i]);
            if(t < min || (t == min && t > maxInMin)){
                min = t;
                maxInMin = nums[i];
            }
        }
        return maxInMin;
    }

}
