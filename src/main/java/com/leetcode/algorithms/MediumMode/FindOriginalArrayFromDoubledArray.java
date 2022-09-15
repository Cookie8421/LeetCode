package com.leetcode.algorithms.MediumMode;

import java.util.Arrays;

/**
 * An integer array original is transformed into a doubled array changed by appending twice the value of every element in original, and then randomly shuffling the resulting array.
 *
 * Given an array changed, return original if changed is a doubled array. If changed is not a doubled array, return an empty array. The elements in original may be returned in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: changed = [1,3,4,2,6,8]
 * Output: [1,3,4]
 * Explanation: One possible original array could be [1,3,4]:
 * - Twice the value of 1 is 1 * 2 = 2.
 * - Twice the value of 3 is 3 * 2 = 6.
 * - Twice the value of 4 is 4 * 2 = 8.
 * Other original arrays could be [4,3,1] or [3,1,4].
 *
 * Example 2:
 *
 * Input: changed = [6,3,0,1]
 * Output: []
 * Explanation: changed is not a doubled array.
 *
 * Example 3:
 *
 * Input: changed = [1]
 * Output: []
 * Explanation: changed is not a doubled array.
 *
 *
 *
 * Constraints:
 *
 *     1 <= changed.length <= 105
 *     0 <= changed[i] <= 105
 */
public class FindOriginalArrayFromDoubledArray {


    int[] res;
    int index=0;
    public int[] findOriginalArray(int[] changed) {
        /**
         * Runtime: 15 ms, faster than 94.01% of Java online submissions for Find Original Array From Doubled Array.
         * Memory Usage: 124.1 MB, less than 85.48% of Java online submissions for Find Original Array From Doubled Array.
         */
        if(changed.length%2==1) return new int[0];
        res = new int[changed.length/2];

        int max = 0;
        for(int num: changed) max = Math.max(max, num);
        int[] nums = new int[max+1];
        for(int num: changed) nums[num]++;

        if(nums[0]%2==1) return new int[0];
        fill(0, nums[0]/2);

        for(int i=1; i<=max/2; i++){
            if(nums[2*i] < nums[i]) return new int[0];
            nums[2*i] -= nums[i];
            fill(i, nums[i]);
        }
        return index != res.length ? new int[0] : res;
    }

    private void fill(int num, int count){
        while(count-->0)
            res[index++] = num;
    }

    /*public int[] findOriginalArray(int[] changed) {
        *//**
         * 	Time Limit Exceeded
         *//*
        if((changed.length & 1) == 1){
            return new int[]{};
        }
        int[] ans = new int[changed.length/2];
        int index = 0;
        int[] flagArr = new int[changed.length];
        for(int i = 0; i < changed.length-1; i++){
            if(flagArr[i] == 1){
                continue;
            }
            boolean found = false;
            for(int j = i+1; j < changed.length; j++){
                if(flagArr[j] == 1){
                    continue;
                }
                if(changed[j] > changed[i]*2){
                    break;
                }
                if(changed[j] == changed[i]*2){
                    flagArr[j] = 1;
                    ans[index++] = changed[i];
                    found = true;
                    break;
                }
            }
            if(!found){
                return new int[]{};
            }
        }
        return ans;
    }*/

}
