package com.leetcode.algorithms.EasyMode;

/**
 * @author YHW
 * @ClassName: TwoSum
 * @Description:
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * @date 2019/2/22 9:28
 */
public class TwoSum {

    /**
     * @Status:Accepted
     * @Runtime:37 ms
     * @Memory:39.9 MB
     */
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++){
            int first = nums[i];
            for(int j = i+1; j < nums.length; j++){
                int second = nums[j];
                if(first+second == target){
                    int[] result = {i, j};
                    return result;
                }
            }
        }
        return null;
    }
    public static void main(String[] args){
        int[] nums = {-3, 4, 3, 66};
        int[] result = twoSum(nums, 0);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
