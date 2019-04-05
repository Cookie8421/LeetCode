package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YHW
 * @ClassName: UniqueTriplets
 * @Description:
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 * @date 2019/3/6 17:11
 */
public class UniqueTriplets {


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> appeared = new ArrayList<Integer>();
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                for(int k = j + 1; k < nums.length; k++){
                    int acc = 0;
                    int temp = nums[i] + nums[j] + nums[k];
                    if(temp == 0){
                        for(int a = 0; a < appeared.size(); a++){
                            if(appeared.contains(nums[i])){
                                Arrays.sort(nums);
                            }
                        }
                        List<Integer> tList = new ArrayList<Integer>();
                        tList.add(nums[i]);
                        tList.add(nums[j]);
                        tList.add(nums[k]);
                        result.add(tList);
                    }
                }
            }
        }


        return result;
    }

    public static void main(String[] args){
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum(arr);
        for(List<Integer> item : list){
            for(Integer in : item){
                System.out.print(in+" ");
            }
            System.out.println(" ");
        }
    }
}
