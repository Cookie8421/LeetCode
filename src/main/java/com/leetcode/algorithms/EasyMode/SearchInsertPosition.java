package com.leetcode.algorithms.EasyMode;

/**
 * @author YHW
 * @ClassName: SearchInsertPosition
 * @Description:
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * @date 2019/3/1 9:48
 */
public class SearchInsertPosition {

    /**
     * @Status:Accepted
     * @Runtime:2 ms
     * @Memory:39.1 MB MB
     */
    public int searchInsert(int[] nums, int target) {
        int position = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < target){
                position++;
            }else{
                break;
            }
        }
        return position;
    }
    public static void main(String[] args){

    }
}
