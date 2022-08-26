package com.leetcode.algorithms.EasyMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
 *
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
 *
 *     a, b are from arr
 *     a < b
 *     b - a equals to the minimum absolute difference of any two elements in arr
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [4,2,1,3]
 * Output: [[1,2],[2,3],[3,4]]
 * Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
 *
 * Example 2:
 *
 * Input: arr = [1,3,6,10,15]
 * Output: [[1,3]]
 *
 * Example 3:
 *
 * Input: arr = [3,8,-10,23,19,-4,-14,27]
 * Output: [[-14,-10],[19,23],[23,27]]
 *
 *
 *
 * Constraints:
 *
 *     2 <= arr.length <= 105
 *     -106 <= arr[i] <= 106
 */
public class MinimumAbsoluteDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        /**
         * Runtime: 76 ms, faster than 5.14% of Java online submissions for Minimum Absolute Difference.
         * Memory Usage: 78.1 MB, less than 5.02% of Java online submissions for Minimum Absolute Difference.
         */
        Arrays.sort(arr);
        TreeMap<Integer, List<List<Integer>>> treeMap = new TreeMap();
        for(int i = 0; i < arr.length-1; i++){
            int dis = arr[i+1] - arr[i];
            if(treeMap.containsKey(dis)){
                List<List<Integer>> ans = treeMap.get(dis);
                List<Integer> t = new ArrayList<>();
                t.add(arr[i]);
                t.add(arr[i+1]);
                ans.add(t);
                treeMap.replace(dis,ans);
            } else {
                List<List<Integer>> ans = new ArrayList<>();
                List<Integer> t = new ArrayList<>();
                t.add(arr[i]);
                t.add(arr[i+1]);
                ans.add(t);
                treeMap.put(dis,ans);
            }
        }
        return treeMap.get(treeMap.firstKey());


        /**
         * Runtime: 23 ms, faster than 71.44% of Java online submissions for Minimum Absolute Difference.
         * Memory Usage: 61.4 MB, less than 66.05% of Java online submissions for Minimum Absolute Difference.
         */
        /*
        Arrays.sort(arr);
        int l=arr.length;
        int i;
        List<List<Integer>> res=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        for(i=1;i<l;i++)
        {
            min=Math.min(min,arr[i]-arr[i-1]);
        }


        for(i=0;i<l-1;i++)
        {
            if(arr[i+1]-arr[i]==min)
            {
                res.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }
        return res;
         */
    }

}
