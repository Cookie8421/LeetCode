package com.leetcode.algorithms.MediumMode;

import cn.hutool.core.lang.hash.Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Two strings are considered close if you can attain one from the other using the following operations:
 *
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 *
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "abc", word2 = "bca"
 * Output: true
 * Explanation: You can attain word2 from word1 in 2 operations.
 * Apply Operation 1: "abc" -> "acb"
 * Apply Operation 1: "acb" -> "bca"
 * Example 2:
 *
 * Input: word1 = "a", word2 = "aa"
 * Output: false
 * Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
 * Example 3:
 *
 * Input: word1 = "cabbba", word2 = "abbccc"
 * Output: true
 * Explanation: You can attain word2 from word1 in 3 operations.
 * Apply Operation 1: "cabbba" -> "caabbb"
 * Apply Operation 2: "caabbb" -> "baaccc"
 * Apply Operation 2: "baaccc" -> "abbccc"
 *
 *
 * Constraints:
 *
 * 1 <= word1.length, word2.length <= 105
 * word1 and word2 contain only lowercase English letters.
 */
public class DetermineIfTwoStringsAreClose {


    /**
     * Runtime
     * 16 ms
     * Memory
     * 60.3 MB
     */
    public boolean closeStrings(String word1, String word2) {

        int freq1[] = new int[26];
        int freq2[] = new int[26];
        int []visited1 = new int[26];
        int []visited2 = new int[26];

        for(char ch : word1.toCharArray()){
            freq1[ch-'a']++;
            visited1[ch-'a'] = 1;
        }

        for(char ch : word2.toCharArray()){
            freq2[ch-'a']++;
            visited2[ch-'a'] = 1;
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(visited1, visited2) && Arrays.equals(freq1, freq2);
    }


    /**
     * Runtime
     * 698 ms
     * Memory
     * 218.8 MB
     */
    /*public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        Map<Character, Integer> word1Map = new HashMap<>();
        Map<Integer, Integer> w1Map = new HashMap<>();
        Map<Character, Integer> word2Map = new HashMap<>();
        Map<Integer, Integer> w2Map = new HashMap<>();
        for(int i = 0; i < word1.length(); i++){
            if(word1Map.containsKey(word1.charAt(i))){
                int replace = word1Map.get(word1.charAt(i))+1;
                word1Map.replace(word1.charAt(i), replace);
                if(w1Map.containsKey(replace)){
                    w1Map.replace(replace, w1Map.get(replace)+1);
                } else {
                    w1Map.put(replace, 0);
                }
                if(w1Map.containsKey(replace-1)){
                    w1Map.replace(replace-1, w1Map.get(replace-1)-1);
                }
            } else {
                word1Map.put(word1.charAt(i), 0);
                if(w1Map.containsKey(0)){
                    w1Map.replace(0, w1Map.get(0)+1);
                } else {
                    w1Map.put(0, 0);
                }
            }
            if(word2Map.containsKey(word2.charAt(i))){
                int replace = word2Map.get(word2.charAt(i))+1;
                word2Map.replace(word2.charAt(i), replace);
                if(w2Map.containsKey(replace)){
                    w2Map.replace(replace, w2Map.get(replace)+1);
                } else {
                    w2Map.put(replace, 0);
                }
                if(w2Map.containsKey(replace-1)){
                    w2Map.replace(replace-1, w2Map.get(replace-1)-1);
                }
            } else {
                word2Map.put(word2.charAt(i), 0);
                if(w2Map.containsKey(0)){
                    w2Map.replace(0, w2Map.get(0)+1);
                } else {
                    w2Map.put(0, 0);
                }
            }
        }
        if(word1Map.keySet().size() != word2Map.keySet().size()){
            return false;
        }
        if(w1Map.keySet().size() != w2Map.keySet().size()){
            return false;
        }
        for(Character c : word1Map.keySet()){
            if(!word2Map.containsKey(c)){
                return false;
            }
        }
        for(Integer i : w1Map.keySet()){
            Integer w1 = w1Map.get(i);
            Integer w2 = w2Map.get(i);
            if(w1 != w2){
                return false;
            }
        }

        return true;
    }*/

}
