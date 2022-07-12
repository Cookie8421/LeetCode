package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JoeyYoung
 * @version 1.0.0
 * @ClassName ThreeSum
 * @Description Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 *
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 *
 *
 *
 * Constraints:
 *
 *     0 <= nums.length <= 3000
 *     -105 <= nums[i] <= 105
 * @createTime 2022/4/7 9:17
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        /**
         * Runtime: 32 ms, faster than 55.20% of Java online submissions for 3Sum.
         * Memory Usage: 58.8 MB, less than 59.53% of Java online submissions for 3Sum.
         */
        Arrays.sort(nums);

        List < List < Integer >> result = new ArrayList < > ();
        for (int num1Idx = 0; num1Idx + 2 < nums.length; num1Idx++) {
            // Skip all duplicates from left
            // num1Idx>0 ensures this check is made only from 2nd element onwards
            if (num1Idx > 0 && nums[num1Idx] == nums[num1Idx - 1]) {
                continue;
            }

            int num2Idx = num1Idx + 1;
            int num3Idx = nums.length - 1;
            while (num2Idx < num3Idx) {
                int sum = nums[num2Idx] + nums[num3Idx] + nums[num1Idx];
                if (sum == 0) {
                    // Add triplet to result
                    result.add(Arrays.asList(nums[num1Idx], nums[num2Idx], nums[num3Idx]));

                    num3Idx--;

                    // Skip all duplicates from right
                    while (num2Idx < num3Idx && nums[num3Idx] == nums[num3Idx + 1]) num3Idx--;
                } else if (sum > 0) {
                    // Decrement num3Idx to reduce sum value
                    num3Idx--;
                } else {
                    // Increment num2Idx to increase sum value
                    num2Idx++;
                }
            }
        }
        return result;
        /**
         * brute force O(n3)
         */
        /*if(nums.length < 3){
            return new ArrayList<>();
        }
        int i = 0, j = 1, k = 2;
        List<List<Integer>> result = new ArrayList<>();
        while(k < nums.length){
            while(j < k){
                while(i < j){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        //non-mapping check
                        boolean flag = true;
                        for(List<Integer> item : result){
                            if(item.containsAll(temp) && temp.containsAll(item)){
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            result.add(temp);
                        }

                    }
                    i++;
                }
                i=0;
                j++;
            }
            i=0;
            j=1;
            k++;
        }
        return result;*/
    }

}
