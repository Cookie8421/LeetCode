package com.leetcode.algorithms.EasyMode;

/**
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 *
 * Recall that arr is a mountain array if and only if:
 *
 *     arr.length >= 3
 *     There exists some i with 0 < i < arr.length - 1 such that:
 *         arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 *         arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,1]
 * Output: false
 *
 * Example 2:
 *
 * Input: arr = [3,5,5]
 * Output: false
 *
 * Example 3:
 *
 * Input: arr = [0,3,2,1]
 * Output: true
 *
 *
 *
 * Constraints:
 *
 *     1 <= arr.length <= 104
 *     0 <= arr[i] <= 104
 */
public class ValidMountainArray {

    public boolean validMountainArray(int[] arr) {
        /**
         * Runtime: 2 ms, faster than 77.26% of Java online submissions for Valid Mountain Array.
         * Memory Usage: 54.1 MB, less than 54.25% of Java online submissions for Valid Mountain Array.
         */
        boolean isIncreasing = true;
        if(arr.length == 0 || arr.length == 1){
            return false;
        }
        if(arr[0] > arr[1]){
            return false;
        }
        int temp = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == temp){
                return false;
            }
            if(isIncreasing){
                if(arr[i] < temp){
                    isIncreasing = false;
                }
            } else {
                if(arr[i] > temp){
                    return false;
                }
            }
            temp = arr[i];
        }
        if(isIncreasing == true){
            return false;
        }
        return true;
    }

}
