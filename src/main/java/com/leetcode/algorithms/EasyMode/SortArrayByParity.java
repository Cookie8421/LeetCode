package com.leetcode.algorithms.EasyMode;

/**
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 *
 * Return any array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,1,2,4]
 * Output: [2,4,3,1]
 * Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 5000
 *     0 <= nums[i] <= 5000
 */
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        /**
         * Runtime: 1 ms, faster than 100.00% of Java online submissions for Sort Array By Parity.
         * Memory Usage: 48.4 MB, less than 47.28% of Java online submissions for Sort Array By Parity.
         */
        int[] ans = new int[nums.length];
        int left = 0;
        int right = ans.length-1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                ans[left++] = nums[i];
            } else {
                ans[right--] = nums[i];
            }
        }
        return ans;
    }

}
