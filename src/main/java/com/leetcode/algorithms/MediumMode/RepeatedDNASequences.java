package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
 *
 * For example, "ACGAATTCCG" is a DNA sequence.
 * When studying DNA, it is useful to identify repeated sequences within the DNA.
 *
 * Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC","CCCCCAAAAA"]
 * Example 2:
 *
 * Input: s = "AAAAAAAAAAAAA"
 * Output: ["AAAAAAAAAA"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is either 'A', 'C', 'G', or 'T'.
 */
public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        /**
         * Runtime: 33 ms, faster than 77.86% of Java online submissions for Repeated DNA Sequences.
         * Memory Usage: 48 MB, less than 98.15% of Java online submissions for Repeated DNA Sequences.
         */
        if(s.length() < 10){
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        String temp = s.substring(0,10);
        Double count = new Double(0);
        Double sum = new Double(0);
        for(int i = 9; i >= 0; i--){
            if(temp.charAt(i) == 'A'){
                sum = Double.sum(sum, 0*Math.pow(4.00, count));
            } else if(temp.charAt(i) == 'C'){
                sum = Double.sum(sum, 1*Math.pow(4.00, count));
            } else if(temp.charAt(i) == 'G'){
                sum = Double.sum(sum, 2*Math.pow(4.00, count));
            } else if(temp.charAt(i) == 'T'){
                sum = Double.sum(sum, 3*Math.pow(4.00, count));
            }
            count++;
        }
        set.add(sum.intValue());
        for(int i = 1; i < s.length()-9; i++){
            temp = s.substring(i, i+10);
            if(s.charAt(i-1) == 'C'){
                sum = Double.sum(sum, -1*Math.pow(4.00, 9));
            } else if(s.charAt(i-1) == 'G'){
                sum = Double.sum(sum, -2*Math.pow(4.00, 9));
            } else if(s.charAt(i-1) == 'T'){
                sum = Double.sum(sum, -3*Math.pow(4.00, 9));
            }
            sum*=4;
            if(s.charAt(i+9) == 'C'){
                sum = Double.sum(sum, 1);
            } else if(s.charAt(i+9) == 'G'){
                sum = Double.sum(sum, 2);
            } else if(s.charAt(i+9) == 'T'){
                sum = Double.sum(sum, 3);
            }
            if(set.contains(sum.intValue())){
                if(!ans.contains(temp)){
                    ans.add(temp);
                }
            } else {
                set.add(sum.intValue());
            }
        }
        return ans;
    }

}
