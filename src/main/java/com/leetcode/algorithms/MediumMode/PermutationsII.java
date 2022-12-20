package com.leetcode.algorithms.MediumMode;


import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class PermutationsII {

    /**
     * Runtime
     * 8 ms
     * Memory
     * 47.7 MB
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length==0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        permuteRecursive(nums, result, new ArrayList<Integer>(),new ArrayList<Integer>());
        return result;

    }
    private void permuteRecursive(int[] nums, List<List<Integer>> result, List<Integer> usedIndex, List<Integer> usedNums){
        if(usedIndex.size()==nums.length){
            List<Integer> temp = new ArrayList<>(usedNums);
            result.add(temp);
            return;
        }
        int removed=-999999;
        for(int index=0; index<nums.length; index++){
            if(removed==nums[index]){
                continue;
            }
            if(!usedIndex.contains(index)){
                // usedNums and usedIndex are Stacks in disguise.
                usedIndex.add(index);
                usedNums.add(nums[index]);
                permuteRecursive(nums, result, usedIndex,usedNums);
                usedIndex.remove(usedIndex.size()-1);
                removed=usedNums.remove(usedNums.size()-1);
            }
        }
    }
}
