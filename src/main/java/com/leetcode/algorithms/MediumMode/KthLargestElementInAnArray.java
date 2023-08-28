package com.leetcode.algorithms.MediumMode;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Can you solve it without sorting?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class KthLargestElementInAnArray {


    /**
     * Quick Sort Approach
     * Runtime
     * 2199 ms
     * Beats
     * 5.28%
     * Memory
     * 58.3 MB
     * Beats
     * 5.90%
     */
    public int findKthLargest(int[] nums, int k) {
        quickSelect(nums, 0, nums.length-1, k);
        return nums[nums.length - k];
    }

    public void quickSelect(int[] nums, int _left, int _right, int k){
        int temp = 0;
        int left = _left;
        int right = _right;
        if(left <= right){
            temp = nums[left];
            while(left != right){

                while(right > left && nums[right] >= temp)
                    right --;
                nums[left] = nums[right];

                while(left < right && nums[left] <= temp)
                    left ++;
                nums[right] = nums[left];
            }
            nums[right] = temp;
            int targetIndex = nums.length - k;
            if(right == targetIndex){
                return;
            } else if(right > targetIndex){
                quickSelect(nums,_left,left-1,k);

            } else {
                quickSelect(nums, right+1,_right,k);
            }
        }
    }

}
