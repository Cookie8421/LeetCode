package com.leetcode.algorithms.MediumMode;
/**
 * @author YHW
 * @ClassName: AddTwoNumbers
 * @Description:
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * @date 2019/6/1 13:52
 */
public class SearchInRotatedSortedArray {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
    //Memory Usage: 35.8 MB, less than 99.98% of Java online submissions for Search in Rotated Sorted Array.
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        return binarySearchOptimized(nums, 0, nums.length-1, target);
    }
    public int binarySearchOptimized(int[] a, int fromIndex, int toIndex, int key){
        if(key == a[fromIndex]) {
            return fromIndex;
        }else if(key == a[toIndex]) {
            return toIndex;
        }
        int medium = fromIndex + (toIndex - fromIndex)/2;
        if(key == a[medium]){
            return medium;
        }
        int leftResult = -1;
        if(contain(a[fromIndex], a[medium], key)){
            leftResult = binarySearchOptimized(a, fromIndex, medium, key);
        }

        if(leftResult == -1 && contain(a[medium], a[toIndex], key)){
            return binarySearchOptimized(a, medium+1, toIndex, key);
        }
        return leftResult;
    }

    public boolean contain(int min, int max, int key){
        if(min < max){
            if(key > min && key < max){
                return true;
            }
        }else if(min > max){
            if(key < min || key > max){
                return true;
            }
            return false;
        }else{
            if(key == min){
                return true;
            }
            return false;
        }
        return false;
    }
    public static void main(String[] args) {
        SearchInRotatedSortedArray sirsa = new SearchInRotatedSortedArray();
        int[] a = {4, 5, 6, 7, 8, 9, 0, 1, 2};
        System.out.println(sirsa.search(a, 1));
    }
}
