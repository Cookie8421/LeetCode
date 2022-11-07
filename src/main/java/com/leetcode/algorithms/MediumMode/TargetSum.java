package com.leetcode.algorithms.MediumMode;

/**
 * You are given an integer array nums and an integer target.
 *
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 *
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * Example 2:
 *
 * Input: nums = [1], target = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 */
public class TargetSum {

    /**
     * Runtime: 657 ms, faster than 29.83% of Java online submissions for Target Sum.
     * Memory Usage: 42 MB, less than 65.70% of Java online submissions for Target Sum.
     */
    /*private int ans = 0;

    public int findTargetSumWays(int[] nums, int target) {

        backingTrack(nums, target, 0, 0);
        return ans;
    }

    private void backingTrack(int[] nums, int target, int index, int sum){
        if(index >= nums.length){
            return;
        }
        if(index == nums.length - 1){
            if(sum + nums[index] == target){
                ans++;
            }
            if(sum - nums[index] == target){
                ans++;
            }
        } else {
            backingTrack(nums, target, index+1, sum+nums[index]);
            backingTrack(nums, target, index+1, sum-nums[index]);
        }
    }*/


    /**
     * Runtime: 14 ms, faster than 77.33% of Java online submissions for Target Sum.
     * Memory Usage: 44.8 MB, less than 35.27% of Java online submissions for Target Sum.
     * This problem is equal to "find all ways to partition the array into two groups so that the difference of the sum of the two groups is Math.abs(S)".
     * Assume the sum of the two subsets is s1 and s2 (s1 >= s2), the sum of the array is sum:
     *
     * s1 + s2 = sum;
     * s1 - s2 = Math.abs(S)
     * So, s1 = (sum + Math.abs(S)) / 2.
     * Now what we need to do is finding all subsets whose sum is s1, which is a typical 0-1 knapsack problem.
     * We use dp[i][j] to denote the number of subsets whose sum is i for the first j elements in the array.
     * Note that there could be zero in the array, dp[0][i] is no longer 0 as the normal knapsack problem,
     * which means we need to process empty knapsack specially.
     */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        S = Math.abs(S);
        for(int i = 0; i < nums.length; i++)
            sum += nums[i];
        // Invalid S, just return 0
        if( S > sum || (sum + S) % 2 != 0 )
            return 0;

        int dp[][] = new int[(sum + S) / 2 + 1][nums.length + 1];
        dp[0][0] = 1;
        for(int i = 0; i < nums.length; i++) { // empty knapsack must be processed specially
            if( nums[i] == 0 )
                dp[0][i + 1] = dp[0][i] * 2;
            else
                dp[0][i + 1] = dp[0][i];
        }
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                dp[i][j + 1] += dp[i][j];
                if( nums[j] <= i )
                    dp[i][j + 1] += dp[i - nums[j]][j];
            }
        }
        return dp[(sum + S) / 2][nums.length];
    }

}
