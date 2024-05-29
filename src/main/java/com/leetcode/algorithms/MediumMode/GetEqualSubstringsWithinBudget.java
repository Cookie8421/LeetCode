package com.leetcode.algorithms.MediumMode;


/*
 * You are given two strings s and t of the same length and an integer maxCost.

You want to change s to t. Changing the ith character of s to ith character of t costs |s[i] - t[i]| (i.e., the absolute difference between the ASCII values of the characters).

Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of t with a cost less than or equal to maxCost. If there is no substring from s that can be changed to its corresponding substring from t, return 0.

 

Example 1:

Input: s = "abcd", t = "bcdf", maxCost = 3
Output: 3
Explanation: "abc" of s can change to "bcd".
That costs 3, so the maximum length is 3.
Example 2:

Input: s = "abcd", t = "cdef", maxCost = 3
Output: 1
Explanation: Each character in s costs 2 to change to character in t,  so the maximum length is 1.
Example 3:

Input: s = "abcd", t = "acde", maxCost = 0
Output: 1
Explanation: You cannot make any change, so the maximum length is 1.
 

Constraints:

1 <= s.length <= 105
t.length == s.length
0 <= maxCost <= 106
s and t consist of only lowercase English letters.
 */
public class GetEqualSubstringsWithinBudget {

    public int equalSubstring(String s, String t, int maxCost) {
        int[] prefixDiffSum = new int[s.length() + 1];
        int Max = 0;
        for (int i = 1; i < s.length() + 1; i++) {
            prefixDiffSum[i] = prefixDiffSum[i - 1] + Math.abs(s.charAt(i - 1) - t.charAt(i - 1));   // Stores sum of differences from beginning till i
            int start = 0;
            int end = i;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (prefixDiffSum[i] - prefixDiffSum[mid] <= maxCost) {
                    Max = Math.max(Max, i - mid);
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return Max;
    }

}