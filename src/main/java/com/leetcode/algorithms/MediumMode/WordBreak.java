package com.leetcode.algorithms.MediumMode;

import java.util.*;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 */
public class WordBreak {

    /**
     * Time Limit Exceeded
     */
    /*public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0){
            return true;
        }
        List<Integer> tmp = new ArrayList<>();
        for(String str : wordDict){
            if(s.startsWith(str)){
                if(str.length() == s.length()){
                    return true;
                }
                tmp.add(str.length());
            }
        }
        for(Integer i : tmp){
            if(wordBreak(s.substring(i), wordDict)){
                return true;
            }
        }
        return false;
    }*/


    /**
     * Runtime: 1 ms, faster than 99.98% of Java online submissions for Word Break.
     * Memory Usage: 40.2 MB, less than 99.79% of Java online submissions for Word Break.
      */
    Set<String> set = new HashSet<>();
    int[] lens;
    public boolean wordBreak(String s, List<String> wordDict) {
        // create unique and ascending word length array
        int n = s.length(), j;
        prep(set, wordDict, n);
        boolean[] dp = new boolean[n+1];

        // start dp
        dp[0] = true;
        for (int i = 1; i <= n; i++) for (int x : lens) { // inner loop: iterate over len
            if ((j = i - x) < 0) break; // key: early termination on len
            if (dp[j] && set.contains(s.substring(j, i))) {
                dp[i] = true;
                break;
            }
        }
        return dp[n];
    }

    private void prep(Set<String> set, List<String> wordDict, int n) {
        Set<Integer> lenSet = new HashSet<>();
        for (String w : wordDict) {
            set.add(w);
            lenSet.add(w.length());
        }

        // convert lenSet to int[] and sort it for speed and early termination
        lens = new int[lenSet.size()]; int k = 0;
        for (int x : lenSet) lens[k++] = x;
        Arrays.sort(lens);
    }

}
