package com.leetcode.algorithms.MediumMode;

/**
 * @author JoeyYoung
 * @version 1.0.0
 * @ClassName FindTheDuplicateNumber
 * @Description TODO
 * @createTime 2022/3/30 19:25
 */
public class FindTheDuplicateNumber {

    /**
     * Runtime: 3 ms, faster than 98.68% of Java online submissions for Find the Duplicate Number.
     * Memory Usage: 78.1 MB, less than 15.81% of Java online submissions for Find the Duplicate Number.
     */
    public static int findDuplicate(int[] nums) {
        int[] tmp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(tmp[nums[i]] == nums[i]){
                return nums[i];
            }
            tmp[nums[i]] = nums[i];
        }
        return 0;
    }

}
