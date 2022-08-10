package com.leetcode.algorithms.EasyMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two strings first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.
 *
 * Return an array of all the words third for each occurrence of "first second third".
 *
 *
 *
 * Example 1:
 *
 * Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
 * Output: ["girl","student"]
 *
 * Example 2:
 *
 * Input: text = "we will we will rock you", first = "we", second = "will"
 * Output: ["we","rock"]
 *
 *
 *
 * Constraints:
 *
 *     1 <= text.length <= 1000
 *     text consists of lowercase English letters and spaces.
 *     All the words in text a separated by a single space.
 *     1 <= first.length, second.length <= 10
 *     first and second consist of lowercase English letters.
 */
public class OccurrencesAfterBigram {

    /**
     * Runtime: 1 ms, faster than 73.84% of Java online submissions for Occurrences After Bigram.
     * Memory Usage: 42.6 MB, less than 8.87% of Java online submissions for Occurrences After Bigram.
     */
    public String[] findOcurrences(String text, String first, String second) {
        String[] ar =  text.split(" ");
        List<String> ls  =  new ArrayList<>();
        int i=0;
        while(i<ar.length-2) {
            if(ar[i].equals(first) && ar[i+1].equals(second))
                ls.add(ar[i+2]);
            i++;
        }
        return ls.toArray(new String[0]);
    }

}
