package com.leetcode.algorithms.MediumMode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author JoeyYoung
 * @ClassName: Search in Rotated Sorted Array II
 * @Date 2021/11/25 10:22
 * @Description:
 *
 * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 *
 * Before being passed to your function,
 * nums is rotated at an unknown pivot index k (0 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
 *
 * Given the array nums after the rotation and an integer target,
 * return true if target is in nums, or false if it is not in nums.
 *
 * You must decrease the overall operation steps as much as possible.
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 5000
 *     -104 <= nums[i] <= 104
 *     nums is guaranteed to be rotated at some pivot.
 *     -104 <= target <= 104
 *
 */
public class SearchInRotatedSortedArrayII {


    /**
     * Runtime: 1 ms, faster than 38.80% of Java online submissions for Search in Rotated Sorted Array II.
     * Memory Usage: 41.2 MB, less than 7.50% of Java online submissions for Search in Rotated Sorted Array II.
     */
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
        if(nums.length == 1 && nums[0] == target){
            return true;
        }
        int start = 0;
        int mid = nums.length / 2;
        int end = nums.length - 1;
        if(target == nums[start] || target == nums[mid] || target == nums[end]) return true;
        if(nums[start] == nums[mid] && nums[mid] == nums[end]){
            if(search(Arrays.copyOfRange(nums, start, mid), target) || search(Arrays.copyOfRange(nums, mid, end), target)){
                return true;
            }
        } else if(nums[start] > nums[mid]){
            if(target < nums[start] && target > nums[mid]){
                return search(Arrays.copyOfRange(nums, mid, end), target);
            } else {
                return search(Arrays.copyOfRange(nums, start, mid), target);
            }
        } else if(nums[mid] > nums[end]){
            if(target < nums[mid] && target > nums[start]){
                return search(Arrays.copyOfRange(nums, start, mid), target);
            } else {
                return search(Arrays.copyOfRange(nums, mid, end), target);
            }
        } else if(nums[start] < nums[mid] && nums[mid] < nums[end]){
            if(target > nums[mid]){
                return search(Arrays.copyOfRange(nums, mid, end), target);
            } else {
                return search(Arrays.copyOfRange(nums, start, mid), target);
            }
        }
        return false;
    }

    //Better Solution
    /*public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            //If we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
            //any of the two sides won't change the result but can help remove duplicate from
            //consideration, here we just use end-- but left++ works too
            } else {
                end--;
            }
        }

        return false;
    }*/

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        System.out.println(Arrays.stream(Arrays.copyOfRange(array, 0, 2)).mapToObj(i -> String.valueOf(i)).collect( Collectors.joining("❤")));
    }
}
