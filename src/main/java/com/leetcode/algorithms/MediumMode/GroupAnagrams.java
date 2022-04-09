package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author JoeyYoung
 * @version 1.0.0
 * @ClassName GroupAnagrams
 * @Description
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 *
 *
 * Constraints:
 *
 *     1 <= strs.length <= 104
 *     0 <= strs[i].length <= 100
 *     strs[i] consists of lowercase English letters.
 * @createTime 2022/4/9 10:32
 */
public class GroupAnagrams {

    /**
     * Runtime: 10 ms, faster than 82.80% of Java online submissions for Group Anagrams.
     * Memory Usage: 56.2 MB, less than 39.97% of Java online submissions for Group Anagrams.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            String hashCode = decoding(s);
            if(!map.containsKey(hashCode)) map.put(hashCode,new ArrayList<>());
            map.get(hashCode).add(s);
        }

        return new ArrayList<>(map.values());
    }
    //Method 1 : Sorting the strs and return.
    private String decoding(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

}
