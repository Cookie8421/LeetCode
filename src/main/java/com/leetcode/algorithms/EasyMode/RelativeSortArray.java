package com.leetcode.algorithms.EasyMode;

import java.util.Arrays;

/**
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 *
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 *
 * Example 2:
 *
 * Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
 * Output: [22,28,8,6,17,44]
 *
 *
 *
 * Constraints:
 *
 *     1 <= arr1.length, arr2.length <= 1000
 *     0 <= arr1[i], arr2[i] <= 1000
 *     All the elements of arr2 are distinct.
 *     Each arr2[i] is in arr1.
 */
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        /**
         * Runtime: 2 ms, faster than 75.30% of Java online submissions for Relative Sort Array.
         * Memory Usage: 42.9 MB, less than 43.89% of Java online submissions for Relative Sort Array.
         */
        int current = 0;
        for(int i = 0; i < arr2.length; i++){
            while(current < arr1.length && arr1[current] == arr2[i]){
                current++;
            }
            for(int j = current; j < arr1.length; j++){
                if(arr1[j] == arr2[i] && arr1[current] != arr2[i]){
                    //switch
                    int t = arr1[j];
                    arr1[j] = arr1[current];
                    arr1[current++] = t;
                }
            }
        }
        quickSortPri(arr1, current, arr1.length-1);
        return arr1;
    }

    private static void quickSortPri(int arr[],int _left,int _right){
        int left = _left;
        int right = _right;
        int temp = 0;
        if(left <= right){
            temp = arr[left];
            while(left != right){

                while(right > left && arr[right] >= temp)
                    right --;
                arr[left] = arr[right];

                while(left < right && arr[left] <= temp)
                    left ++;
                arr[right] = arr[left];

            }
            arr[right] = temp;
            quickSortPri(arr,_left,left-1);
            quickSortPri(arr, right+1,_right);
        }
    }
}
