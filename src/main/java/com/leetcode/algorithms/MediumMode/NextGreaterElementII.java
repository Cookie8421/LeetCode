package com.leetcode.algorithms.MediumMode;

import java.util.*;

/**
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
 *
 * The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number.
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Example 2:
 *
 * Input: nums = [1,2,3,4,3]
 * Output: [2,3,4,-1,4]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 */
public class NextGreaterElementII {

    /**
     * Runtime
     * 457 ms
     * Memory
     * 55.4 MB
     */
    /*public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        for(int i = 0; i < length; i++){
           int j = (i+1)%length;
           for(; j != i; j = (j+1)%length){
                if(nums[j] > nums[i]){
                    ans[i] = nums[j];
                    break;
                }
           }
           if(j == i){
               ans[i] = -1;
           }
        }
        return ans;
    }*/

    /**
     * O(n) Using Deque & 2 Loops
     * Runtime
     * 6 ms
     * Memory
     * 54.8 MB
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        if(nums.length<2) return res;
        Deque<Integer> s = new LinkedList();
        for(int i=0; i<nums.length; i++){
            if(s.isEmpty() || nums[s.peekLast()]>=nums[i]){
                s.addLast(i);
            }
            else{
                while(!s.isEmpty() && nums[s.peekLast()]<nums[i]){
                    res[s.peekLast()] = nums[i];
                    s.removeLast();
                }
                s.addLast(i);
            }
        }

        int i=0;
        while(i<nums.length && !s.isEmpty()){
            int next = s.peekLast();
            if(i<next && nums[i]>nums[next]){
                res[next] = nums[i];
                s.removeLast();
            }
            else{
                i++;
            }
        }
        return res;
    }

}
