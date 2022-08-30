package com.leetcode.algorithms.Custom;

public class Sort {

    public static void quickSort(int arr[]){
        quickSortPri(arr,0,arr.length-1);
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
