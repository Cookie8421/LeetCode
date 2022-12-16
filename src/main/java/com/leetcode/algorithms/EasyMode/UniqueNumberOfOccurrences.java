package com.leetcode.algorithms.EasyMode;

import lombok.var;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 * Example 2:
 *
 * Input: arr = [1,2]
 * Output: false
 * Example 3:
 *
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 */
public class UniqueNumberOfOccurrences {

    /**
     * Runtime
     * 2 ms
     * Memory
     * 40.3 MB
     */
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            int key = arr[i];
            if(map.containsKey(key)){
                map.replace(key, map.get(key)+1);
            } else {
                map.put(key, 1);
            }
        }
        for(Integer i : map.keySet()) {
            Integer value = map.get(i);
            if (set.contains(value)) {
                return false;
            } else {
                set.add(value);
            }
        }
        return true;
    }

}
