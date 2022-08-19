package com.leetcode.algorithms.EasyMode;

import lombok.var;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * Given an array of integers arr, replace each element with its rank.
 *
 * The rank represents how large the element is. The rank has the following rules:
 *
 *     Rank is an integer starting from 1.
 *     The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
 *     Rank should be as small as possible.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [40,10,20,30]
 * Output: [4,1,2,3]
 * Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.
 *
 * Example 2:
 *
 * Input: arr = [100,100,100]
 * Output: [1,1,1]
 * Explanation: Same elements share the same rank.
 *
 * Example 3:
 *
 * Input: arr = [37,12,28,9,100,56,80,5,12]
 * Output: [5,3,4,2,8,6,7,1,3]
 *
 *
 *
 * Constraints:
 *
 *     0 <= arr.length <= 105
 *     -109 <= arr[i] <= 109
 */
public class RankTransformOfAnArray {

    public int[] arrayRankTransform(int[] arr) {
        /**
         * Runtime: 99 ms, faster than 17.75% of Java online submissions for Rank Transform of an Array.
         * Memory Usage: 68.1 MB, less than 84.50% of Java online submissions for Rank Transform of an Array.
         */
        int[] res = new int[arr.length];
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap();
        int count = 1;
        for(int i = 0; i < arr.length; i++){
            if(!treeMap.containsKey(arr[i])){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                treeMap.put(arr[i], list);
            } else {
                List<Integer> list = treeMap.get(arr[i]);
                list.add(i);
                treeMap.replace(arr[i], list);
            }
        }
        for(Integer map : treeMap.keySet()){
            List<Integer> list = treeMap.get(map);
            for(int i : list){
                res[i] = count;
            }
            count++;
        }
        return res;


        /**
         * Runtime: 24 ms, faster than 99.49% of Java online submissions for Rank Transform of an Array.
         * Memory Usage: 61.1 MB, less than 87.83% of Java online submissions for Rank Transform of an Array.
         */
        /*int nums[] = new int[arr.length];
        int ans[] = new int[arr.length];
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<nums.length;i++) nums[i]=arr[i];
        Arrays.sort(nums);
        int index=1;
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i]))
                continue;
            else{
                hm.put(nums[i],index);
                index++;
            }
        }
        for(int i=0;i<ans.length;i++){
            ans[i]=hm.get(arr[i]);
        }
        return ans;*/
    }

}
