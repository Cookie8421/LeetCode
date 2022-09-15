package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
 *
 * An integer a is closer to x than an integer b if:
 *
 *     |a - x| < |b - x|, or
 *     |a - x| == |b - x| and a < b
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 *
 * Example 2:
 *
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 *
 *
 *
 * Constraints:
 *
 *     1 <= k <= arr.length
 *     1 <= arr.length <= 104
 *     arr is sorted in ascending order.
 *     -104 <= arr[i], x <= 104
 */
public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        /**
         * Runtime: 19 ms, faster than 34.69% of Java online submissions for Find K Closest Elements.
         * Memory Usage: 62.4 MB, less than 55.33% of Java online submissions for Find K Closest Elements.
         */
        List<Integer> ans = new ArrayList<>();
        //find index
        int index = 0;
        for(; index < arr.length && x > arr[index]; index++){
        }
        int left = index == 0 ? -1 : index-1;
        int right = index;
        while(k-- > 0){
            if(left < 0){
                ans.add(arr[right++]);
                continue;
            }
            if(right >= arr.length){
                ans.add(arr[left--]);
                continue;
            }
            if(Math.abs(x-arr[left]) <= Math.abs(x-arr[right])){
                ans.add(arr[left--]);
            } else {
                ans.add(arr[right++]);
            }
        }

        ans.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        return ans;
    }

}
