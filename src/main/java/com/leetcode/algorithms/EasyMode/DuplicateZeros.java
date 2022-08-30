package com.leetcode.algorithms.EasyMode;

import java.util.Arrays;

/**
 * Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,0,2,3,0,4,5,0]
 * Output: [1,0,0,2,3,0,0,4]
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 *
 * Example 2:
 *
 * Input: arr = [1,2,3]
 * Output: [1,2,3]
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 *
 *
 *
 * Constraints:
 *
 *     1 <= arr.length <= 104
 *     0 <= arr[i] <= 9
 */
public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Duplicate Zeros.
         * Memory Usage: 42.6 MB, less than 92.54% of Java online submissions for Duplicate Zeros.
         */
        int[] origin = Arrays.copyOfRange(arr, 0, arr.length);
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if(origin[index] != 0){
                arr[i] = origin[index++];
            } else {
                arr[i++] = origin[index++];
                if(i < arr.length){
                    arr[i] = 0;
                }
            }
        }
    }

}
