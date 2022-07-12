package com.leetcode.algorithms.MediumMode;

/**
 * You are given an integer array nums.
 * You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what.
 * Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 104
 *     0 <= nums[i] <= 105
 */
public class JumpGame {

    /**
     * Runtime: 168 ms, faster than 24.43% of Java online submissions for Jump Game.
     * Memory Usage: 67.3 MB, less than 70.35% of Java online submissions for Jump Game.
     */
    public boolean canJump(int[] nums) {
        if(nums.length == 0){
            return false;
        }
        if(nums.length == 1){
            return true;
        }
        return recursion(nums, nums.length - 1);
    }

    public boolean recursion(int[] nums, int lastPos){
        for(int i = 0; i < lastPos; i++){
            if(nums[i] + i >= lastPos){
                if(i == 0){
                    return true;
                } else {
                    return recursion(nums, i);
                }
            }
        }
        return false;
    }

    /**
     * more effective
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Jump Game.
     * Memory Usage: 43 MB, less than 86.86% of Java online submissions for Jump Game.
     */
    /*public boolean canJump(int[] nums) {
        if (nums == null) return false;
        int end = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= end) end = i;
        }
        return end == 0;
    }*/
}
