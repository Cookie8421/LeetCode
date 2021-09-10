package com.leetcode.algorithms.MediumMode;
/**
 * @author YHW
 * @ClassName: FindFirstandLastPositionofElementinSortedArray
 * @Description:
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 * Runtime: 1 ms, faster than 17.47% of Java online submissions for Find First and Last Position of Element in Sorted Array.
 * Memory Usage: 44.4 MB, less than 5.12% of Java online submissions for Find First and Last Position of Element in Sorted Array.
 */
public class FindFirstandLastPositionofElementinSortedArray {
    int begin = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
    public int[] searchRange(int[] nums, int target) {
        search(nums, target, 0, nums.length -1);
        return new int[]{begin == Integer.MAX_VALUE ? -1 : begin, end == Integer.MIN_VALUE ? -1 : end};
    }

    public void search(int[] nums, int target, int i, int j) {
        int mid = i + ((j - i) / 2);
        if(i > j) return;
        if(nums[mid] == target){
            begin = Math.min(begin, mid);
            end = Math.max(end, mid);
            search(nums, target, mid + 1, j);
            search(nums, target, i, mid - 1);
        } else {
            i = nums[mid] > target ? i : mid + 1;
            j = nums[mid] > target ? mid -1 : j;
            search(nums, target, i, j);
        }

    }

    public static void main(String[] args) {
        FindFirstandLastPositionofElementinSortedArray f = new FindFirstandLastPositionofElementinSortedArray();
        int[] result = f.searchRange(new int[]{1, 2, 3, 5}, 5);
        System.out.println(result[0]);
        System.out.println(result[1]);

    }
}
