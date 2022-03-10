package com.leetcode.algorithms.EasyMode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:
 *
 *     'a' maps to ".-",
 *     'b' maps to "-...",
 *     'c' maps to "-.-.", and so on.
 *
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 *
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 *
 * Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.
 *
 *     For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the transformation of a word.
 *
 * Return the number of different transformations among all words we have.
 */
public class UniqueMorseCodeWords {

    private static final String[] FULL_TABLE = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    /**
     * Runtime: 2 ms, faster than 89.38% of Java online submissions for Unique Morse Code Words.
     * Memory Usage: 41.7 MB, less than 52.40% of Java online submissions for Unique Morse Code Words.
     */
    public static int uniqueMorseRepresentations(String[] words) {
        Set<String> result = new HashSet<>();
        for(int i = 0; i < words.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < words[i].length(); j++){
                int current = words[i].charAt(j);
                sb.append(FULL_TABLE[current - 97]);
            }
            result.add(sb.toString());
        }
        return result.size();
    }

    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
