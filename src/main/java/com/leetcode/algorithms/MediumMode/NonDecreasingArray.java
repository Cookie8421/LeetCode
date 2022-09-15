package com.leetcode.algorithms.MediumMode;

/**
 * Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
 *
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 *
 * Example 2:
 *
 * Input: nums = [4,2,1]
 * Output: false
 * Explanation: You cannot get a non-decreasing array by modifying at most one element.
 *
 *
 *
 * Constraints:
 *
 *     n == nums.length
 *     1 <= n <= 104
 *     -105 <= nums[i] <= 105
 */
public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        /**
         * Runtime: 2 ms, faster than 34.83% of Java online submissions for Non-decreasing Array.
         * Memory Usage: 54.4 MB, less than 20.79% of Java online submissions for Non-decreasing Array.
         */
        boolean flag = false;
        int dis = -1;
        int current = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < current){
                if(flag){
                    return false;
                } else {
                    flag = true;
                    if((dis != -1 && dis >= current - nums[i])
                    || (dis == -1)){
                        current = nums[i];
                    }
                    dis = 0;
                }
            } else if(nums[i] > current){
                dis = nums[i] - current;
                current = nums[i];
            } else {
                dis = nums[i] - current;
            }
        }
        return true;
    }


    /**
     * Runtime: 1 ms, faster than 98.11% of Java online submissions for Non-decreasing Array.
     * Memory Usage: 43.5 MB, less than 92.35% of Java online submissions for Non-decreasing Array.
     */
    /*
    int n = nums.length;
        int count=0;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                count++;
                if(count>1){
                    return false;
                }
                if(i>0 && nums[i-1]>nums[i+1]){
                    nums[i+1]=nums[i];
                }
            }

        }

        return true;
     */

}
