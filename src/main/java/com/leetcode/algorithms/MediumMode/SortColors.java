package com.leetcode.algorithms.MediumMode;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 *
 *
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
public class SortColors {

    public void sortColors(int[] nums) {
        quickSortPri(nums, 0, nums.length-1);
    }

    /**
     * Runtime
     * 0 ms
     * Beats
     * 100%
     * Memory
     * 40.9 MB
     * Beats
     * 62.81%
     */
    public void quickSortPri(int arr[],int _left,int _right){
        int left = _left;
        int right = _right;
        int temp = 0;
        if(left <= right){
            temp = arr[left];
            while(left != right){

                while(right > left && arr[right] >= temp)
                    right --;
                arr[left] = arr[right];

                while(left < right && arr[left] <= temp)
                    left ++;
                arr[right] = arr[left];

            }
            arr[right] = temp;
            quickSortPri(arr,_left,left-1);
            quickSortPri(arr, right+1,_right);
        }
    }


}
