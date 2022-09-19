package com.leetcode.algorithms.MediumMode;

/**
 * You are given two integer arrays nums and multipliers of size n and m respectively, where n >= m. The arrays are 1-indexed.
 *
 * You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:
 *
 *     Choose one integer x from either the start or the end of the array nums.
 *     Add multipliers[i] * x to your score.
 *     Remove x from the array nums.
 *
 * Return the maximum score after performing m operations.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3], multipliers = [3,2,1]
 * Output: 14
 * Explanation: An optimal solution is as follows:
 * - Choose from the end, [1,2,3], adding 3 * 3 = 9 to the score.
 * - Choose from the end, [1,2], adding 2 * 2 = 4 to the score.
 * - Choose from the end, [1], adding 1 * 1 = 1 to the score.
 * The total score is 9 + 4 + 1 = 14.
 *
 * Example 2:
 *
 * Input: nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]
 * Output: 102
 * Explanation: An optimal solution is as follows:
 * - Choose from the start, [-5,-3,-3,-2,7,1], adding -5 * -10 = 50 to the score.
 * - Choose from the start, [-3,-3,-2,7,1], adding -3 * -5 = 15 to the score.
 * - Choose from the start, [-3,-2,7,1], adding -3 * 3 = -9 to the score.
 * - Choose from the end, [-2,7,1], adding 1 * 4 = 4 to the score.
 * - Choose from the end, [-2,7], adding 7 * 6 = 42 to the score.
 * The total score is 50 + 15 - 9 + 4 + 42 = 102.
 *
 *
 *
 * Constraints:
 *
 *     n == nums.length
 *     m == multipliers.length
 *     1 <= m <= 103
 *     m <= n <= 105
 *     -1000 <= nums[i], multipliers[i] <= 1000
 */
public class MaximumScoreFromPerformingMultiplicationOperations {

    public int maximumScore(int[] nums, int[] multipliers) {
        /**
         * Runtime: 71 ms, faster than 76.98% of Java online submissions for Maximum Score from Performing Multiplication Operations.
         * Memory Usage: 99.4 MB, less than 78.93% of Java online submissions for Maximum Score from Performing Multiplication Operations.
         */
        int n = nums.length;
        int m = multipliers.length;
        int[][] dp = new int[m + 1][m + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int left = i; left >= 0; left--) {
                int mult = multipliers[i];
                int right = n - 1 - (i - left);
                dp[i][left] = Math.max(mult * nums[left] + dp[i + 1][left + 1],
                        mult * nums[right] + dp[i + 1][left]);
            }
        }

        return dp[0][0];
    }

    /*public int maximumScore(int[] nums, int[] multipliers) {
        *//**
         * Time Limit Exceeded
         *//*
        int ans = 0;
        int index = 0;
        int left = 0;
        int right = nums.length-1;
        ans = Math.max(dfs(nums,multipliers,left+1,right,index+1,ans+nums[left]*multipliers[index]), dfs(nums,multipliers,left,right-1,index+1,ans+nums[right]*multipliers[index]));
        return ans;
    }

    private int dfs(int[] nums,int[] multipliers, int left, int right, int index, int current){
        if(index >= multipliers.length){
            return current;
        } else {
            return Math.max(dfs(nums,multipliers,left+1,right,index+1,current+nums[left]*multipliers[index]), dfs(nums,multipliers,left,right-1,index+1,current+nums[right]*multipliers[index]));
        }
    }*/

}
