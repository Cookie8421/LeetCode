package com.leetcode.algorithms.EasyMode;

/**
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 *
 * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
 * Output: true
 * Explanation: sentence contains at least one of every letter of the English alphabet.
 *
 * Example 2:
 *
 * Input: sentence = "leetcode"
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *     1 <= sentence.length <= 1000
 *     sentence consists of lowercase English letters.
 */
public class CheckIfTheSentenceIsPangram {

    public boolean checkIfPangram(String sentence) {
        /**
         * Runtime: 9 ms, faster than 15.40% of Java online submissions for Check if the Sentence Is Pangram.
         * Memory Usage: 42.2 MB, less than 35.65% of Java online submissions for Check if the Sentence Is Pangram.
         */
        int[] alphabet = new int[26];
        int count = 0;
        for(int i = 0; i < sentence.length(); i++){
            int index = sentence.charAt(i) - 'a';
            if(alphabet[index] == 0){
                alphabet[index] = 1;
                count++;
            }
        }
        return count == 26;

        /**
         * Runtime: 3 ms, faster than 54.57% of Java online submissions for Check if the Sentence Is Pangram.
         * Memory Usage: 41.7 MB, less than 78.82% of Java online submissions for Check if the Sentence Is Pangram.
         */
        /*
        boolean[] letters  = new boolean[26];

        for(char c : sentence.toCharArray()) {
            letters[c - 'a'] = true;
        }

        //find any letter that not exist
        for(boolean existLetter : letters) {
            if(!existLetter) return false;
        }

        return true;
         */
    }

}
