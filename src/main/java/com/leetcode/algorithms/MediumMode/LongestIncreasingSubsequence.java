package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums, return the length of the longest strictly increasing
 * subsequence
 * .
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */
public class LongestIncreasingSubsequence {

    /**
     * Runtime
     * 6
     * ms
     * Beats
     * 84.28%
     * of users with Java
     * Memory
     * 43.92
     * MB
     * Beats
     * 26.09%
     * of users with Java
     */
    public int lengthOfLIS(int[] nums) {
        List<Integer> incrSubseq = new ArrayList<>();
        incrSubseq.add(nums[0]);

        for(int i=1; i < nums.length; i++){
            if(nums[i] > incrSubseq.get(incrSubseq.size() - 1))
                incrSubseq.add(nums[i]);
            else{
                int idx = getNextGreaterElement(incrSubseq, nums[i]);
                incrSubseq.set(idx, nums[i]);
            }
        }
        return incrSubseq.size();
    }

    // Return the index of the smallest element that is greater than or equal to the given number
    int getNextGreaterElement(List<Integer> list, int num){
        int left = 0, right = list.size() - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(num == list.get(mid))
                return mid; // When same number already present we return the index of that element
            if(num > list.get(mid))
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

}
