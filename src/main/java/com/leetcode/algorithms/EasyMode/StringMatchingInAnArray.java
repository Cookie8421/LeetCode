package com.leetcode.algorithms.EasyMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of string words. Return all strings in words which is substring of another word in any order.
 *
 * String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["mass","as","hero","superhero"]
 * Output: ["as","hero"]
 * Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
 * ["hero","as"] is also a valid answer.
 *
 * Example 2:
 *
 * Input: words = ["leetcode","et","code"]
 * Output: ["et","code"]
 * Explanation: "et", "code" are substring of "leetcode".
 *
 * Example 3:
 *
 * Input: words = ["blue","green","bu"]
 * Output: []
 *
 *
 *
 * Constraints:
 *
 *     1 <= words.length <= 100
 *     1 <= words[i].length <= 30
 *     words[i] contains only lowercase English letters.
 *     It's guaranteed that words[i] will be unique.
 */
public class StringMatchingInAnArray {

    public List<String> stringMatching(String[] words) {
        /**
         * Runtime: 122 ms, faster than 5.26% of Java online submissions for String Matching in an Array.
         * Memory Usage: 72.8 MB, less than 5.10% of Java online submissions for String Matching in an Array.
         */
        List<String> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            for(int j = i+1; j < words.length; j++){
                if(words[i].length() >= words[j].length()){
                    if(words[i].matches("\\S*" + words[j] + "\\S*") && !res.contains(words[j])){
                        res.add(words[j]);
                    }
                } else {
                    if(words[j].matches("\\S*" + words[i] + "\\S*") && !res.contains(words[i])){
                        res.add(words[i]);
                    }
                }
            }
        }
        return res;


        /**
         * Runtime: 3 ms, faster than 99.69% of Java online submissions for String Matching in an Array.
         * Memory Usage: 42.8 MB, less than 64.91% of Java online submissions for String Matching in an Array.
         */
        /*
        var matchedWords = new ArrayList<String>();
          for(var i = 0; i < words.length; i++)
            for(var j = 0; j < words.length; j++)
              if(j != i)
                if(words[j].contains(words[i])) {
                  matchedWords.add(words[i]);
                  break;
                }

          return matchedWords;
         */
    }

}
