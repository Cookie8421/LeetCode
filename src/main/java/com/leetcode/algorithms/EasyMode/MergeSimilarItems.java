package com.leetcode.algorithms.EasyMode;

import lombok.var;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * You are given two 2D integer arrays, items1 and items2, representing two sets of items. Each array items has the following properties:
 *
 *     items[i] = [valuei, weighti] where valuei represents the value and weighti represents the weight of the ith item.
 *     The value of each item in items is unique.
 *
 * Return a 2D integer array ret where ret[i] = [valuei, weighti], with weighti being the sum of weights of all items with value valuei.
 *
 * Note: ret should be returned in ascending order by value.
 *
 *
 *
 * Example 1:
 *
 * Input: items1 = [[1,1],[4,5],[3,8]], items2 = [[3,1],[1,5]]
 * Output: [[1,6],[3,9],[4,5]]
 * Explanation:
 * The item with value = 1 occurs in items1 with weight = 1 and in items2 with weight = 5, total weight = 1 + 5 = 6.
 * The item with value = 3 occurs in items1 with weight = 8 and in items2 with weight = 1, total weight = 8 + 1 = 9.
 * The item with value = 4 occurs in items1 with weight = 5, total weight = 5.
 * Therefore, we return [[1,6],[3,9],[4,5]].
 *
 * Example 2:
 *
 * Input: items1 = [[1,1],[3,2],[2,3]], items2 = [[2,1],[3,2],[1,3]]
 * Output: [[1,4],[2,4],[3,4]]
 * Explanation:
 * The item with value = 1 occurs in items1 with weight = 1 and in items2 with weight = 3, total weight = 1 + 3 = 4.
 * The item with value = 2 occurs in items1 with weight = 3 and in items2 with weight = 1, total weight = 3 + 1 = 4.
 * The item with value = 3 occurs in items1 with weight = 2 and in items2 with weight = 2, total weight = 2 + 2 = 4.
 * Therefore, we return [[1,4],[2,4],[3,4]].
 *
 * Example 3:
 *
 * Input: items1 = [[1,3],[2,2]], items2 = [[7,1],[2,2],[1,4]]
 * Output: [[1,7],[2,4],[7,1]]
 * Explanation:
 * The item with value = 1 occurs in items1 with weight = 3 and in items2 with weight = 4, total weight = 3 + 4 = 7.
 * The item with value = 2 occurs in items1 with weight = 2 and in items2 with weight = 2, total weight = 2 + 2 = 4.
 * The item with value = 7 occurs in items2 with weight = 1, total weight = 1.
 * Therefore, we return [[1,7],[2,4],[7,1]].
 *
 *
 *
 * Constraints:
 *
 *     1 <= items1.length, items2.length <= 1000
 *     items1[i].length == items2[i].length == 2
 *     1 <= valuei, weighti <= 1000
 *     Each valuei in items1 is unique.
 *     Each valuei in items2 is unique.
 */
public class MergeSimilarItems {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {

        /**
         * Runtime: 4 ms, faster than 100.00% of Java online submissions for Merge Similar Items.
         * Memory Usage: 43.2 MB, less than 100.00% of Java online submissions for Merge Similar Items.
         */
        List<List<Integer>> res = new ArrayList<>();
        //sort
        quickSort(items1);
        quickSort(items2);
        //itorate
        int items1Index=0,items2Index=0;
        while(items1Index < items1.length || items2Index < items2.length){
            List<Integer> temp = new ArrayList<>();
            if(items1Index == items1.length){
                temp.add(items2[items2Index][0]);
                temp.add(items2[items2Index++][1]);
                res.add(temp);
            } else if(items2Index == items2.length){
                temp.add(items1[items1Index][0]);
                temp.add(items1[items1Index++][1]);
                res.add(temp);
            } else {
                if(items1[items1Index][0] == items2[items2Index][0]){
                    temp.add(items1[items1Index][0]);
                    temp.add(items1[items1Index++][1] + items2[items2Index++][1]);
                    res.add(temp);
                } else if(items1[items1Index][0] < items2[items2Index][0]){
                    temp.add(items1[items1Index][0]);
                    temp.add(items1[items1Index++][1]);
                    res.add(temp);
                } else {
                    temp.add(items2[items2Index][0]);
                    temp.add(items2[items2Index++][1]);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    public static void quickSort(int arr[][]){
        quickSortPri(arr,0,arr.length-1);
    }

    private static void quickSortPri(int arr[][],int _left,int _right){
        int left = _left;
        int right = _right;
        int[] temp;
        if(left <= right){
            temp = arr[left];
            while(left != right){

                while(right > left && arr[right][0] >= temp[0])
                    right --;
                arr[left] = arr[right];

                while(left < right && arr[left][0] <= temp[0])
                    left ++;
                arr[right] = arr[left];

            }
            arr[right] = temp;
            quickSortPri(arr,_left,left-1);
            quickSortPri(arr, right+1,_right);
        }
    }

    //more simple: TreeMap
    public List<List<Integer>> mergeSimilarItemsUsingTreeMap(int[][] items1, int[][] items2) {
        List<List<Integer>> l = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i<items1.length; i++){
            map.put(items1[i][0],items1[i][1]);
        }
        for(int i = 0; i<items2.length; i++){
            int index = items2[i][0];
            int val = items2[i][1];
            map.put(index,map.getOrDefault(index,0)+val);
        }
        for(var i: map.entrySet()){
            l.add(Arrays.asList(i.getKey(), i.getValue()));
        }
        return l;
    }

}
