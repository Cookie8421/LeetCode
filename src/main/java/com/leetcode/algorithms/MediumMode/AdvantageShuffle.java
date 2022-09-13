package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given two integer arrays nums1 and nums2 both of the same length. The advantage of nums1 with respect to nums2 is the number of indices i for which nums1[i] > nums2[i].
 *
 * Return any permutation of nums1 that maximizes its advantage with respect to nums2.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * Output: [2,11,7,15]
 *
 * Example 2:
 *
 * Input: nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * Output: [24,32,8,12]
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums1.length <= 105
 *     nums2.length == nums1.length
 *     0 <= nums1[i], nums2[i] <= 109
 */
public class AdvantageShuffle {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        /**
         * Runtime: 135 ms, faster than 45.43% of Java online submissions for Advantage Shuffle.
         * Memory Usage: 83.2 MB, less than 20.19% of Java online submissions for Advantage Shuffle.
         */
        int n = nums1.length;
        int arr[][] = new int[n][2];
        for(int i = 0 ; i<n ; i++){
            arr[i][0] = nums2[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a,b)->a[0]-b[0]);
        Arrays.sort(nums1);
        int i = 0, j = 0, k = n-1;
        int res[] = new int[n];
        while(j<=k){
            while(j<=k && nums1[i]<=arr[j][0]){
                res[arr[k][1]] = nums1[i];
                k--;
                i++;
            }
            if(j<=k){
                res[arr[j][1]] = nums1[i];
                j++;
                i++;
            }
        }
        return res;
    }

}
