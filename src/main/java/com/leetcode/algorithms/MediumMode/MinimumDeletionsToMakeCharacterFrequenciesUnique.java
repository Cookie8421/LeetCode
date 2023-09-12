package com.leetcode.algorithms.MediumMode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * A string s is called good if there are no two different characters in s that have the same frequency.
 *
 * Given a string s, return the minimum number of characters you need to delete to make s good.
 *
 * The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: 0
 * Explanation: s is already good.
 * Example 2:
 *
 * Input: s = "aaabbbcc"
 * Output: 2
 * Explanation: You can delete two 'b's resulting in the good string "aaabcc".
 * Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
 * Example 3:
 *
 * Input: s = "ceabaacb"
 * Output: 2
 * Explanation: You can delete both 'c's resulting in the good string "eabaab".
 * Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s contains only lowercase English letters.
 */
public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

    /**
     * Runtime
     * 8 ms
     * Beats
     * 82.34%
     * Memory
     * 44.5 MB
     * Beats
     * 65.10%
     */
    public int minDeletions(String s) {
        int res = 0;
        int[] arr = new int[26];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>()
        {
            public int compare(Integer a,Integer b)
            {
                return b-a;
            }
        });
        for(char c : s.toCharArray()){
            arr[c - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(arr[i] > 0){
                queue.offer(arr[i]);
            }
        }
        Integer last = -1;
        while(!queue.isEmpty()){
            int i = queue.poll();
            if(last == -1){
                last = i;
            } else {
                if(last == i){
                    res++;
                    last--;
                } else if(last < i){
                    if(last == 0){
                        last = 0;
                        res+=i;
                    } else if(i == 0){
                        last = 0;
                        res+=last;
                    } else {
                        res+=(i-last+1);
                        last--;
                    }
                } else {
                    last = i;
                }
            }
        }
        return res;
    }

}
