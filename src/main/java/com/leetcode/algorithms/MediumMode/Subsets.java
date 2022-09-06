package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 10
 *     -10 <= nums[i] <= 10
 *     All the numbers of nums are unique.
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        /**
         * Runtime: 1 ms, faster than 89.73% of Java online submissions for Subsets.
         * Memory Usage: 43.3 MB, less than 62.38% of Java online submissions for Subsets.
         */
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans.add(new ArrayList<Integer>());
        for(int n : nums){
            int size = ans.size();
            for(int i =0 ; i < size ; i++){
                List<Integer> sub = new ArrayList<Integer>(ans.get(i));
                sub.add(n);
                ans.add(sub);
            }
        }
        return ans;
    }

}
