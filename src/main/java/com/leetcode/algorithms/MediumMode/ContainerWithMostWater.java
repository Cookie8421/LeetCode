package com.leetcode.algorithms.MediumMode;

/**
 * @author YHW
 * @ClassName: ContainerWithMostWater
 * @Description:
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 * @date 2019/3/6 8:27
 */
public class ContainerWithMostWater {




    /**
     * @Status:Accepted
     * @Runtime:208 ms
     * @Memory:40.9 MB
     * 时间复杂度：n*n
     */
    /*
    public static int maxArea(int[] height) {

        int maxArea = Integer.min(height[0], height[height.length-1]);

        for(int i = 0; i < height.length - 1; i++){
            for(int j = i; j < height.length; j++){
                int length = j - i;
                int temp = length * Integer.min(height[i], height[j]);
                if(temp > maxArea){
                    maxArea = temp;
                }
            }
        }
        return maxArea;
    }
    */

    public static void main(String[] args){
        int[] container = {1, 5, 1, 1, 1, 5, 1};
        //System.out.println(maxArea(container));
    }
}
