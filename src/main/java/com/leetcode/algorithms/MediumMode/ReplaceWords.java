package com.leetcode.algorithms.MediumMode;

import java.util.List;

/**
 * In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word successor. For example, when the root "an" is followed by the successor word "other", we can form a new word "another".
 *
 * Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the successors in the sentence with the root forming it. If a successor can be replaced by more than one root, replace it with the root that has the shortest length.
 *
 * Return the sentence after the replacement.
 *
 *
 *
 * Example 1:
 *
 * Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 *
 * Example 2:
 *
 * Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * Output: "a a b c"
 *
 *
 *
 * Constraints:
 *
 *     1 <= dictionary.length <= 1000
 *     1 <= dictionary[i].length <= 100
 *     dictionary[i] consists of only lower-case letters.
 *     1 <= sentence.length <= 106
 *     sentence consists of only lower-case letters and spaces.
 *     The number of words in sentence is in the range [1, 1000]
 *     The length of each word in sentence is in the range [1, 1000]
 *     Every two consecutive words in sentence will be separated by exactly one space.
 *     sentence does not have leading or trailing spaces.
 */

class Trie{
    Trie arr[];
    String s;
    Trie(){
        this.arr=new Trie[26];
    }
}
public class ReplaceWords {

    /*public String replaceWords(List<String> dictionary, String sentence) {
        *//**
         * Time Limit Exceeded
         *//*
        StringBuilder stringBuilder = new StringBuilder();
        String[] arr = sentence.split(" ");
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < dictionary.size(); j++){
                String t = dictionary.get(j);
                if(t.length() >= arr[i].length()){
                    continue;
                }
                if(arr[i].indexOf(t) == 0){
                    arr[i] = dictionary.get(j);
                }
            }
        }
        for(int i = 0; i < arr.length; i++){
            stringBuilder.append(arr[i]);
            if(i < arr.length-1){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }*/


    private void addTrie(Trie root,String s){
        for(int i=0;i<s.length();i++){
            int c=s.charAt(i)-97;
            if(root.arr[c]==null)
                root.arr[c]=new Trie();
            root=root.arr[c];
        }
        root.s=s;
    }
    private String getRoot(Trie root,String s){
        for(int i=0;i<s.length();i++){
            int c=s.charAt(i)-97;
            if(root.arr[c]==null)
                break;
            root=root.arr[c];
            if(root.s!=null)
                return root.s;
        }
        return s;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        /**
         * Runtime: 8 ms, faster than 99.93% of Java online submissions for Replace Words.
         * Memory Usage: 59.7 MB, less than 88.41% of Java online submissions for Replace Words.
         */
        Trie root=new Trie();
        for(String s:dictionary)
            addTrie(root,s);
        String arr[]=sentence.split(" ");
        StringBuilder sb=new StringBuilder(getRoot(root,arr[0]));
        for(int i=1;i<arr.length;i++){
            sb.append(" ");
            sb.append(getRoot(root,arr[i]));
        }
        return sb.toString();
    }

}
