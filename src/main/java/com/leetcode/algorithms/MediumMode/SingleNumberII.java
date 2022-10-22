package com.leetcode.algorithms.MediumMode;

import java.util.*;

/**
 * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,3,2]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * Each element in nums appears exactly three times except for one element which appears once.
 */
public class SingleNumberII {

    public int singleNumber(int[] nums) {
        /**
         * Runtime: 113 ms, faster than 5.05% of Java online submissions for Single Number II.
         * Memory Usage: 45.8 MB, less than 6.25% of Java online submissions for Single Number II.
         */
        /*if(nums.length == 1){
            return nums[0];
        }
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int temp = nums[i];
            if(set.contains(temp)){
                list.remove(new Integer(temp));
            } else {
                list.add(temp);
            }
            set.add(temp);
        }
        for(Integer i : list){
            return i;
        }
        return nums[0];*/


        /**
         * Runtime: 4 ms, faster than 80.22% of Java online submissions for Single Number II.
         * Memory Usage: 41.5 MB, less than 98.95% of Java online submissions for Single Number II.
         */
        int res = 0;
        int x;
        for(int i = 0; i < 32; ++i){
            int sum = 0;
            x = (1 << i);
            for(int j = 0; j < nums.length; ++j){
                if((nums[j] & x) != 0)
                    ++sum;
            }
            if((sum % 3) != 0)
                res |= x;
        }
        return res;
    }

}
