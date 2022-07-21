package com.leetcode.algorithms.MediumMode;

import java.util.*;

/**
 * Given a string s and an array of strings words,
 * return the number of words[i] that is a subsequence of s.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 *     For example, "ace" is a subsequence of "abcde".
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcde", words = ["a","bb","acd","ace"]
 * Output: 3
 * Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
 *
 * Example 2:
 *
 * Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * Output: 2
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 5 * 104
 *     1 <= words.length <= 5000
 *     1 <= words[i].length <= 50
 *     s and words[i] consist of only lowercase English letters.
 */
public class NumberOfMatchingSubsequences {

    /**
     * Runtime: 56 ms, faster than 94.54% of Java online submissions for Number of Matching Subsequences.
     * Memory Usage: 72.8 MB, less than 64.21% of Java online submissions for Number of Matching Subsequences.
     */
    public int numMatchingSubseq(String s, String[] words) {
        int i, j, size, w = words.length;
        int remaining = w;
        char ch;

        LinkedList<WordNode>[] list = new LinkedList[26];
        for(i = 0; i < 26; i++){
            list[i] = new LinkedList<WordNode>();
        }

        for(i = 0; i < w; i++){
            ch = words[i].charAt(0);
            list[ch - 'a'].addLast(new WordNode(words[i]));
        }

        int length = s.length();
        WordNode current;

        for(i = 0; (i < length) && (remaining != 0); i++){
            ch = s.charAt(i);
            size = list[ch - 'a'].size();
            for(j = 0; j < size; j++){
                current = list[ch - 'a'].pollFirst();
                current.increment();
                if(current.isDone()){
                    --remaining;
                }else{
                    list[current.getDesiredCharcter() - 'a'].addLast(current);
                }
            }
        }

        return w - remaining;
    }

}

class WordNode{
    private int index;
    private String word;
    private int length;

    public WordNode(String word){
        this.word = word;
        this.index = 0;
        this.length = this.word.length();
    }

    public void increment(){
        ++this.index;
    }

    public char getDesiredCharcter(){
        return this.word.charAt(this.index);
    }

    public boolean isDone(){
        return this.index >= this.length;
    }
}
