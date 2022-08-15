package com.leetcode.algorithms.EasyMode;

import java.util.Arrays;

import static java.util.Arrays.stream;

/**
 * Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,1,2]
 * Output: 5
 *
 * Example 2:
 *
 * Input: nums = [1,2,1]
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *     3 <= nums.length <= 104
 *     1 <= nums[i] <= 106
 */
public class LargestPerimeterTriangle {

    public int largestPerimeter(int[] nums) {
        /**
         * Runtime: 10 ms, faster than 75.36% of Java online submissions for Largest Perimeter Triangle.
         * Memory Usage: 54.7 MB, less than 21.82% of Java online submissions for Largest Perimeter Triangle.
         */
        //sort
        Arrays.sort(nums);
        //find
        for(int i = nums.length - 1; i > 1; i --)
            if(nums[i] < nums[i - 1] + nums[i - 2])
                return nums[i] + nums[i - 1] + nums[i - 2];

        return 0;
    }

}
