package com.leetcode.algorithms.EasyMode;

import java.util.HashSet;

/**
 * You are given a non-negative integer array nums. In one operation, you must:
 *
 *     Choose a positive integer x such that x is less than or equal to the smallest non-zero element in nums.
 *     Subtract x from every positive element in nums.
 *
 * Return the minimum number of operations to make every element in nums equal to 0.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,5,0,3,5]
 * Output: 3
 * Explanation:
 * In the first operation, choose x = 1. Now, nums = [0,4,0,2,4].
 * In the second operation, choose x = 2. Now, nums = [0,2,0,0,2].
 * In the third operation, choose x = 2. Now, nums = [0,0,0,0,0].
 *
 * Example 2:
 *
 * Input: nums = [0]
 * Output: 0
 * Explanation: Each element in nums is already 0 so no operations are needed.
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 100
 *     0 <= nums[i] <= 100
 */
public class MakeArrayZeroBySubtractingEqualAmounts {

    public int minimumOperations(int[] nums) {
        /**
         * Runtime: 2 ms, faster than 71.13% of Java online submissions for Make Array Zero by Subtracting Equal Amounts.
         * Memory Usage: 42.5 MB, less than 14.78% of Java online submissions for Make Array Zero by Subtracting Equal Amounts.
         */
        HashSet hashSet = new HashSet();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                hashSet.add(nums[i]);
            }
        }
        return hashSet.size();
    }

}
