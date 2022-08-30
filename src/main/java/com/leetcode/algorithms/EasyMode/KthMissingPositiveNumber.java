package com.leetcode.algorithms.EasyMode;

import java.util.Arrays;

/**
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 *
 * Return the kth positive integer that is missing from this array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,3,4,7,11], k = 5
 * Output: 9
 * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
 *
 * Example 2:
 *
 * Input: arr = [1,2,3,4], k = 2
 * Output: 6
 * Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 *
 *
 *
 * Constraints:
 *
 *     1 <= arr.length <= 1000
 *     1 <= arr[i] <= 1000
 *     1 <= k <= 1000
 *     arr[i] < arr[j] for 1 <= i < j <= arr.length
 *
 *
 *
 * Follow up:
 *
 * Could you solve this problem in less than O(n) complexity?
 */
public class KthMissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {
        /**
         * Runtime: 1 ms, faster than 52.44% of Java online submissions for Kth Missing Positive Number.
         * Memory Usage: 43 MB, less than 68.92% of Java online submissions for Kth Missing Positive Number.
         */
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end-start) / 2; //checking how many numbers are missing upto mid index
            if(arr[mid]-(mid+1)<k) //if the quantity elements missing is less than k,the search is done one right side(start=mid+1)
                start = mid +1;
            else //if the quantity of elements missing is larger than k,the search is done on left side
                end = mid -1;
        }
        return start + k; // when start > end, start+k will give the Kth missing number
    }

}
