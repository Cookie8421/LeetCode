package com.leetcode.algorithms.MediumMode;

/**
 * There is only one character 'A' on the screen of a notepad. You can perform one of two operations on this notepad for each step:
 *
 *     Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
 *     Paste: You can paste the characters which are copied last time.
 *
 * Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: Initially, we have one character 'A'.
 * In step 1, we use Copy All operation.
 * In step 2, we use Paste operation to get 'AA'.
 * In step 3, we use Paste operation to get 'AAA'.
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *     1 <= n <= 1000
 */
public class TwoKeysKeyboard {



    public int minSteps(int n) {
        /**
         * Greedy
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for 2 Keys Keyboard.
         * Memory Usage: 41.2 MB, less than 44.18% of Java online submissions for 2 Keys Keyboard.
         */
        int res = 0;
        for(int i = 2;i*i<=n;){
            if(n%i == 0){
                res+=i;
                n/=i;
            } else {
                i++;
            }
        }
        if(n!= 1)
            res+=n;
        return res;
    }


    /**
     * DP
     * Runtime: 9 ms, faster than 50.20% of Java online submissions for 2 Keys Keyboard.
     * Memory Usage: 41 MB, less than 59.30% of Java online submissions for 2 Keys Keyboard.
     */
    /*
    // DP
    public int minSteps(int n) {
        if(n==1) return 0;

        int dp[] = new int[n+1];
        dp[1]=0;

        for(int i=2; i<=n; i++){
			// for even, we can copy and paste the half of number
			// for example dp[4] = dp[2] + (copy + paste = 2 operations)
			// for example dp[50] = dp[25] + (copy + paste = 2 operations)
            if(i%2==0)
                dp[i] = dp[i/2] + 2;
            else{
			// for odd we need to find highest_factor
                int hf = get_hf(i);
                // for example dp[9] = dp[3] + (copy 1 + paste 2 = 3 operations i.e 9/3)
                // for example dp[27] = dp[9] + (copy 1 + paste 2 = 3 operations i.e 27/3)
                // for example dp[81] = dp[27] + (copy 1 + paste 2 = 3 operations i.e 81/27)
                dp[i] = dp[hf] + (i/hf);
            }
        }
        return dp[n];
    }

    public int get_hf(int n){
		// we start to find the highest factor from n/3 to 1 and not n/2
		// because we only calculate highest factor for odd numbers
        for(int i = n/3; i>=1; i--)
            if(n%i == 0)
                return i;
        return 1;
    }
     */

}
