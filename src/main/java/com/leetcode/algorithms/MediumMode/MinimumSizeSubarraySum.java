package com.leetcode.algorithms.MediumMode;

public class MinimumSizeSubarraySum {


    /**
     *
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Minimum Size Subarray Sum.
     * Memory Usage: 41.4 MB, less than 47.98% of Java online submissions for Minimum Size Subarray Sum.
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int leftIndex = 0;
        int rightIndex = 0;
        int tmpAcc = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= target){
                return 1;
            }
            tmpAcc += nums[i];
            rightIndex = i;
            if(tmpAcc >= target){
                break;
            }
        }
        if(tmpAcc < target){
            return 0;
        }
        return getMinSubArrayLen(target, tmpAcc, leftIndex, rightIndex, nums);
    }

    public static int getMinSubArrayLen(int target, int tmpAcc, int leftIndex, int rightIndex, int[] nums){
        while(true){
            if(nums[leftIndex] >= nums[rightIndex] && tmpAcc - nums[rightIndex] >= target){
                rightIndex--;
                tmpAcc -= nums[rightIndex];
            } else if(nums[rightIndex] > nums[leftIndex] && tmpAcc - nums[leftIndex] >= target){
                tmpAcc -= nums[leftIndex++];
            } else {
                break;
            }
        }
        if(rightIndex >= nums.length - 1){
            return rightIndex - leftIndex + 1;
        }
        tmpAcc -= nums[leftIndex++];
        tmpAcc += nums[++rightIndex];
        return getMinSubArrayLen(target, tmpAcc, leftIndex, rightIndex, nums);
    }

    public static void main(String[] args) {
        System.out.println(MinimumSizeSubarraySum.minSubArrayLen(15,new int[]{5,1,3,5,10,7,4,9,2,8}));
    }
}
