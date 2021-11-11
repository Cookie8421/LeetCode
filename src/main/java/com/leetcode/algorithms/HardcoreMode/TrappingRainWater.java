package com.leetcode.algorithms.HardcoreMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author JoeyYoung
 * @ClassName: Trapping Rain Water
 * @Date 2021/11/10 9:29
 * @Description:
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 */
public class TrappingRainWater {

    /**
     * Dynamic Programming
     * Runtime: 1 ms, faster than 90.04% of Java online submissions for Trapping Rain Water.
     * Memory Usage: 38.8 MB, less than 52.87% of Java online submissions for Trapping Rain Water.
     */
    public static int trap(int[] height) {
        if(height.length == 0 || height.length == 1 || height.length == 2){
            return 0;
        }
        int currentMax = -1;
        int[] positiveArray = new int[height.length];
        int[] inverseArray = new int[height.length];
        int result = 0;
        for(int i = 0; i < height.length; i++){
            if(currentMax == -1){
                positiveArray[0] = 0;
                currentMax = height[i];
                continue;
            }
            if(currentMax < height[i]){
                currentMax = height[i];
                positiveArray[i] = 0;
            } else if(currentMax > height[i]){
                positiveArray[i] = currentMax - height[i];
            }
        }
        currentMax = -1;
        for(int i = height.length - 1; i > -1; i--){
            if(currentMax == -1){
                inverseArray[i] = 0;
                currentMax = height[i];
                continue;
            }
            if(currentMax < height[i]){
                currentMax = height[i];
                inverseArray[i] = 0;
            } else if(currentMax > height[i]){
                inverseArray[i] = currentMax - height[i];
            }
        }
        for(int i = 0; i < positiveArray.length; i++){
            result += Math.min(positiveArray[i],inverseArray[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,3,2,1,2,3};
        System.out.println(trap(test));
    }
}
