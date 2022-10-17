package com.leetcode.algorithms.MediumMode;

import java.util.ArrayDeque;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 105
 *     -231 <= nums[i] <= 231 - 1
 *     0 <= k <= 105
 *
 *
 *
 * Follow up:
 *
 *     Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 *     Could you do it in-place with O(1) extra space?
 */
public class RotateArray {

    /*public void rotate(int[] nums, int k) {
        *//**
         * Runtime: 7 ms, faster than 15.72% of Java online submissions for Rotate Array.
         * Memory Usage: 64.8 MB, less than 20.20% of Java online submissions for Rotate Array.
         *//*
        if(k == nums.length){
            return;
        } else if(k > nums.length){
            k%=nums.length;
        }
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for(int i = 0; i < k; i++){
            arrayDeque.add(nums[i]);
        }
        for(int i = nums.length - k, j = 0; j < k; i++,j++){
            nums[j] = nums[i];
        }
        for(int i = k; i < nums.length; i++){
            arrayDeque.add(nums[i]);
            nums[i] = arrayDeque.poll();
        }
    }*/

    public void rotate(int[] nums, int k) {
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Array.
         * Memory Usage: 58.5 MB, less than 86.90% of Java online submissions for Rotate Array.
         */
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

}
