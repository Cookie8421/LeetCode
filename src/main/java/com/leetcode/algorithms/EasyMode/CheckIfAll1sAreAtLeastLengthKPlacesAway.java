package com.leetcode.algorithms.EasyMode;

/**
 * Given an binary array nums and an integer k, return true if all 1's are at least k places away from each other, otherwise return false.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,0,0,0,1,0,0,1], k = 2
 * Output: true
 * Explanation: Each of the 1s are at least 2 places away from each other.
 *
 * Example 2:
 *
 * Input: nums = [1,0,0,1,0,1], k = 2
 * Output: false
 * Explanation: The second 1 and third 1 are only one apart from each other.
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 105
 *     0 <= k <= nums.length
 *     nums[i] is 0 or 1
 */
public class CheckIfAll1sAreAtLeastLengthKPlacesAway {

    public boolean kLengthApart(int[] nums, int k) {
        /**
         * Runtime: 2 ms, faster than 83.75% of Java online submissions for Check If All 1's Are at Least Length K Places Away.
         * Memory Usage: 70.3 MB, less than 53.72% of Java online submissions for Check If All 1's Are at Least Length K Places Away.
         */
        if(k == 0){
            return true;
        }
        int count = 0;
        boolean start = false;
        boolean isOne = false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                if(isOne){
                    return false;
                }
                if(count != 0 && count < k){
                    return false;
                }
                start = true;
                isOne = true;
                count = 0;
            } else if(nums[i] == 0){
                isOne = false;
                if(start){
                    count++;
                }
            }
        }
        return true;
    }

}
