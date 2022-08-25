package com.leetcode.algorithms.EasyMode;

/**
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 *
 * Return the running sum of nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 *
 * Example 2:
 *
 * Input: nums = [1,1,1,1,1]
 * Output: [1,2,3,4,5]
 * Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
 *
 * Example 3:
 *
 * Input: nums = [3,1,2,10,1]
 * Output: [3,4,6,16,17]
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 1000
 *     -10^6 <= nums[i] <= 10^6
 */
public class RunningSumOf1dArray {

    public int[] runningSum(int[] nums) {
        /**
         * Runtime: 1 ms, faster than 20.15% of Java online submissions for Running Sum of 1d Array.
         * Memory Usage: 43.5 MB, less than 30.07% of Java online submissions for Running Sum of 1d Array.
         */
        int[] ans = new int[nums.length];
        int current = 0;
        for(int i = 0; i < nums.length; i++){
            ans[i] = current + nums[i];
            current = ans[i];
        }
        return ans;

        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Running Sum of 1d Array.
         * Memory Usage: 42 MB, less than 96.78% of Java online submissions for Running Sum of 1d Array.
         */
        /*
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            ans[i] = ans[i-1] + nums[i];
        }
        return ans;
         */
    }

}
