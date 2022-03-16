package com.leetcode.algorithms.MediumMode;


/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 *
 *
 * Constraints:
 *
 *     nums1.length == m
 *     nums2.length == n
 *     0 <= m <= 1000
 *     0 <= n <= 1000
 *     1 <= m + n <= 2000
 *     -106 <= nums1[i], nums2[i] <= 106
 */
public class MedianOfTwoSortedArrays {

    private int[] mergedArray;

    /**
     * Runtime: 2 ms, faster than 93.11% of Java online submissions for Median of Two Sorted Arrays.
     * Memory Usage: 43 MB, less than 91.47% of Java online submissions for Median of Two Sorted Arrays.
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int nums1Cur = 0, nums2Cur = 0;
        mergedArray = new int[length];
        for(int i = 0; i < length; i++){
            if(nums1Cur == nums1.length){
                mergedArray[i] = nums2[nums2Cur++];
                continue;
            } else if(nums2Cur == nums2.length){
                mergedArray[i] = nums1[nums1Cur++];
                continue;
            }
            if(nums1[nums1Cur] <= nums2[nums2Cur]){
                mergedArray[i] = nums1[nums1Cur++];
            } else {
                mergedArray[i] = nums2[nums2Cur++];
            }
        }
        if(length % 2 == 0){
            return ((double)mergedArray[length / 2 - 1] + (double)mergedArray[length / 2]) / 2;
        }
        return mergedArray[length / 2];
    }

}
