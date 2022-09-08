package com.leetcode.algorithms.MediumMode;

/**
 * Given an array of positive integers arr (not necessarily distinct), return the lexicographically largest permutation that is smaller than arr, that can be made with exactly one swap (A swap exchanges the positions of two numbers arr[i] and arr[j]). If it cannot be done, then return the same array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [3,2,1]
 * Output: [3,1,2]
 * Explanation: Swapping 2 and 1.
 *
 * Example 2:
 *
 * Input: arr = [1,1,5]
 * Output: [1,1,5]
 * Explanation: This is already the smallest permutation.
 *
 * Example 3:
 *
 * Input: arr = [1,9,4,6,7]
 * Output: [1,7,4,6,9]
 * Explanation: Swapping 9 and 7.
 *
 *
 *
 * Constraints:
 *
 *     1 <= arr.length <= 104
 *     1 <= arr[i] <= 104
 */
public class PreviousPermutationWithOneSwap {

    public int[] prevPermOpt1(int[] arr) {
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Previous Permutation With One Swap.
         * Memory Usage: 55.7 MB, less than 77.60% of Java online submissions for Previous Permutation With One
         */
        if(arr.length == 1){
            return arr;
        }
        int max = 0;
        int indexA = -1;
        int indexB = 0;
        for(int i = arr.length-1; i >= 0; i--){
            indexB = i;
            for(int j = arr.length-1; j >= i+1; j--){
                if(arr[j] < arr[i]){
                    if(arr[j] >= max){
                        max = arr[j];
                        indexA = j;
                    }
                }
            }
            if(indexA != -1){
                break;
            }
        }
        //swap
        if(indexA == -1){
            return arr;
        }
        int t = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = t;
        return arr;
    }

}
