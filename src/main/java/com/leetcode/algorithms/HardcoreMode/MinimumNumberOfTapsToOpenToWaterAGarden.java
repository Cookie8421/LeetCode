package com.leetcode.algorithms.HardcoreMode;

/**
 * There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n. (i.e The length of the garden is n).
 *
 * There are n + 1 taps located at points [0, 1, ..., n] in the garden.
 *
 * Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.
 *
 * Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 5, ranges = [3,4,1,1,0,0]
 * Output: 1
 * Explanation: The tap at point 0 can cover the interval [-3,3]
 * The tap at point 1 can cover the interval [-3,5]
 * The tap at point 2 can cover the interval [1,3]
 * The tap at point 3 can cover the interval [2,4]
 * The tap at point 4 can cover the interval [4,4]
 * The tap at point 5 can cover the interval [5,5]
 * Opening Only the second tap will water the whole garden [0,5]
 * Example 2:
 *
 * Input: n = 3, ranges = [0,0,0,0]
 * Output: -1
 * Explanation: Even if you activate all the four taps you cannot water the whole garden.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 104
 * ranges.length == n + 1
 * 0 <= ranges[i] <= 100
 */
public class MinimumNumberOfTapsToOpenToWaterAGarden {

    public int minTaps(int n, int[] ranges) {
        int res = -1;
        int left = 0;
        int right = n;
        int left_ = left;
        int right_ = right;
        while(left <= right){
            int _left = left;
            int leftMax = 0;
            int leftIndex = 0;
            for(int i = left; i <= right; i++){
                if(i+ranges[i] >= leftIndex+leftMax && i - left <= ranges[i] && ranges[i] != 0){
                    leftMax = ranges[i];
                    leftIndex = i;
                }
            }
            left = leftIndex + leftMax + 1;
            res = res < 0 ? 1 : res+1;
            if(left > right){
                break;
            }

            int rightMax = 0;
            int rightIndex = n;
            for(int i = right; i >= _left; i--){
                if(i-ranges[i] <= rightIndex-rightMax && right - i <= ranges[i] && ranges[i] != 0){
                    rightMax = ranges[i];
                    rightIndex = i;
                }
            }
            right = rightIndex - rightMax - 1;
            if(right < _left){
                break;
            }
            res = res < 0 ? 1 : res+1;
            if(left == left_ && right == right_){
                return -1;
            } else {
                left_ = left;
                right_ = right;
            }
        }
        return res;
    }

}
