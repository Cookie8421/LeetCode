package com.leetcode.algorithms.EasyMode;

import java.util.HashSet;

/**
 * You are given two integer arrays of equal length target and arr. In one step, you can select any non-empty sub-array of arr and reverse it. You are allowed to make any number of steps.
 *
 * Return true if you can make arr equal to target or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: target = [1,2,3,4], arr = [2,4,1,3]
 * Output: true
 * Explanation: You can follow the next steps to convert arr to target:
 * 1- Reverse sub-array [2,4,1], arr becomes [1,4,2,3]
 * 2- Reverse sub-array [4,2], arr becomes [1,2,4,3]
 * 3- Reverse sub-array [4,3], arr becomes [1,2,3,4]
 * There are multiple ways to convert arr to target, this is not the only way to do so.
 *
 * Example 2:
 *
 * Input: target = [7], arr = [7]
 * Output: true
 * Explanation: arr is equal to target without any reverses.
 *
 * Example 3:
 *
 * Input: target = [3,7,9], arr = [3,7,11]
 * Output: false
 * Explanation: arr does not have value 9 and it can never be converted to target.
 *
 *
 *
 * Constraints:
 *
 *     target.length == arr.length
 *     1 <= target.length <= 1000
 *     1 <= target[i] <= 1000
 *     1 <= arr[i] <= 1000
 */
public class MakeTwoArraysEqualByReversingSubarrays {

    public boolean canBeEqual(int[] target, int[] arr) {
        /**
         * Runtime: 3 ms, faster than 86.60% of Java online submissions for Make Two Arrays Equal by Reversing Sub-arrays.
         * Memory Usage: 45.5 MB, less than 68.99% of Java online submissions for Make Two Arrays Equal by Reversing Sub-arrays.
         */
        int[] targetArr = new int[1000];
        int[] arrArr = new int[1000];
        for(int i = 0; i < target.length; i++){
            targetArr[target[i]-1]++;
        }
        for(int i = 0; i < arr.length; i++){
            arrArr[arr[i]-1]++;
        }
        for(int i = 0; i < 1000; i++){
            if(targetArr[i] != arrArr[i]){
                return false;
            }
        }
        return true;
    }

}
