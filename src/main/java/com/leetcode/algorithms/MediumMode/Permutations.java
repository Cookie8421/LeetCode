package com.leetcode.algorithms.MediumMode;


import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 *
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 6
 *     -10 <= nums[i] <= 10
 *     All the integers of nums are unique.
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<> ();
        backtrack (nums, 0, nums.length,res);
        return res;
    }


    /**
     * Runtime: 1 ms, faster than 93.57% of Java online submissions for Permutations.
     * Memory Usage: 45.2 MB, less than 14.71% of Java online submissions for Permutations.
     */
    private static void backtrack(int[] nums, int start, int end,List<List<Integer>> res) {
        if (start == end) {
            List<Integer> tempres = new ArrayList ();
            for(int i:nums){
                tempres.add (i);
            }
            res.add (tempres);
            return;
        }
        for (int i = start; i < end; i++) {
            swap (nums, start, i);
            backtrack (nums, start + 1, end,res);
            swap (nums, start, i);
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
