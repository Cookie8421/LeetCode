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
     * Counting Sort
     * Runtime
     * 4 ms
     * Beats
     * 96.93%
     * Memory
     * 56.4 MB
     * Beats
     * 26.98%
     */
    public int findKthLargest(int[] nums, int k) {
        //find the MaxValue and MinValue
        int max = nums[0];
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        //create Count Array
        int[] countArr = new int[max-min+1];
        for(int i = 0; i < nums.length; i++){
            countArr[nums[i]-min]++;
        }
        //create new Sorted Array based on Count Array
        int[] sortedArr = new int[nums.length];
        int sortedArrPos = 0;
        for(int i = countArr.length-1; i >= 0; i--){
            for(int j = 0; j < countArr[i]; j++){
                sortedArr[sortedArrPos++] = i+min;
            }
        }
        return sortedArr[k-1];
        //quickSelect(nums, 0, nums.length-1, k);
        //return nums[nums.length - k];
    }

    /**
     * Quick Sort
     * Runtime
     * 2199 ms
     * Beats
     * 5.28%
     * Memory
     * 58.3 MB
     * Beats
     * 5.90%
     */
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
