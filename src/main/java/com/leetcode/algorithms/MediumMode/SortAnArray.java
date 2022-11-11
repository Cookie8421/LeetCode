package com.leetcode.algorithms.MediumMode;

/**
 * Given an array of integers nums, sort the array in ascending order and return it.
 *
 * You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
 * Example 2:
 *
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * Explanation: Note that the values of nums are not necessairly unique.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 */
public class SortAnArray {

    /**
     * Runtime
     * 2292 ms
     * Memory
     * 97.2 MB
     */
    public int[] sortArray(int[] nums) {
        quickSortPri(nums, 0, nums.length-1);
        return nums;
    }

    private static void quickSortPri(int arr[],int _left,int _right){
        int left = _left;
        int right = _right;
        int temp = 0;
        if(left < right){
            temp = arr[left];
            while(left != right){
                while(left != right){

                    while(right > left && arr[right] >= temp)
                        right --;
                    arr[left] = arr[right];

                    while(left < right && arr[left] <= temp)
                        left ++;
                    arr[right] = arr[left];

                }
                arr[right] = temp;
                quickSortPri(arr, _left, left-1);
                quickSortPri(arr, right+1, _right);
            }
        }
    }

}
