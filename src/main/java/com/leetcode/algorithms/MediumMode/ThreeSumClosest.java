package com.leetcode.algorithms.MediumMode;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Example 2:
 *
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 *
 *
 *
 * Constraints:
 *
 *     3 <= nums.length <= 1000
 *     -1000 <= nums[i] <= 1000
 *     -104 <= target <= 104
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        /**
         * Runtime: 5 ms, faster than 100.00% of Java online submissions for 3Sum Closest.
         * Memory Usage: 42.1 MB, less than 96.03% of Java online submissions for 3Sum Closest.
         */
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int n = nums.length;
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n - 2; i++) {
            //This means the smallest element with two biggest elements can't satisfity the target. There is no need to move the right pointer.
            if (nums[i] + nums[n - 1] + nums[n - 2] < target) {
                sum = nums[i] + nums[n - 1] + nums[n - 2];
                continue;
            }
            //These three smallest elements in the sums are the closest elements to target. We can't find another possible.
            if (nums[i] + nums[i + 1] + nums[i + 2] > target) {
                int temp = nums[i] + nums[i + 1] + nums[i + 2];
                if(Math.abs(sum - target) < Math.abs(temp - target)){
                    return sum;
                }else{
                    return temp;
                }
            }
            //The ordinary seek with three pointers.
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (temp == target) {
                    return target;
                }
                if (temp < target) {
                    left++;
                } else {
                    right--;
                }

                if(Math.abs(sum - target) >= Math.abs(temp - target)){
                    sum = temp;
                }
            }
        }
        return sum;
    }

}
