package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**You are given two string arrays words1 and words2.

 A string b is a subset of string a if every letter in b occurs in a including multiplicity.

 For example, "wrr" is a subset of "warrior" but is not a subset of "world".
 A string a from words1 is universal if for every string b in words2, b is a subset of a.

 Return an array of all the universal strings in words1. You may return the answer in any order.



 Example 1:

 Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
 Output: ["facebook","google","leetcode"]
 Example 2:

 Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
 Output: ["apple","google","leetcode"]


 Constraints:

 1 <= words1.length, words2.length <= 104
 1 <= words1[i].length, words2[i].length <= 10
 words1[i] and words2[i] consist only of lowercase English letters.
 All the strings of words1 are unique.
 *
 */
public class WordSubsets {

    /**
     * Runtime
     * 16 ms
     * Memory
     * 50.2 MB
     */
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] arr = new int[26];
        int[] tmp = null;
        //create a single frequency array for all elements of array B
        for(String str2 : words2) {
            tmp = new int[26];
            for(char ch : str2.toCharArray()) {
                tmp[ch - 'a']++;
            }
            for(int i = 0 ; i < 26; i++) {
                arr[i] = Math.max(arr[i], tmp[i]);
            }
        }

        List<String> res = new ArrayList<>();
        //compare frequency array of each element of A with combined frequency array of B
        for(String str1 : words1) {
            if(contains(str1, arr)) {
                res.add(str1);
            }
        }
        return res;
    }

    public boolean contains(String str1, int[] arr2) {
        int[] arr1 = new int[26];

        for(char ch : str1.toCharArray()) {
            arr1[ch - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(arr2[i] > 0 && arr1[i] < arr2[i]) {
                return false;
            }
        }
        return true;
    }

}
