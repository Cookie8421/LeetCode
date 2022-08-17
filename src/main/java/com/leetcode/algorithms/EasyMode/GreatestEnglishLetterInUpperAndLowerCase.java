package com.leetcode.algorithms.EasyMode;

/**
 * Given a string of English letters s, return the greatest English letter which occurs as both a lowercase and uppercase letter in s. The returned letter should be in uppercase. If no such letter exists, return an empty string.
 *
 * An English letter b is greater than another letter a if b appears after a in the English alphabet.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "lEeTcOdE"
 * Output: "E"
 * Explanation:
 * The letter 'E' is the only letter to appear in both lower and upper case.
 *
 * Example 2:
 *
 * Input: s = "arRAzFif"
 * Output: "R"
 * Explanation:
 * The letter 'R' is the greatest letter to appear in both lower and upper case.
 * Note that 'A' and 'F' also appear in both lower and upper case, but 'R' is greater than 'F' or 'A'.
 *
 * Example 3:
 *
 * Input: s = "AbCdEfGhIjK"
 * Output: ""
 * Explanation:
 * There is no letter that appears in both lower and upper case.
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 1000
 *     s consists of lowercase and uppercase English letters.
 */
public class GreatestEnglishLetterInUpperAndLowerCase {

    public String greatestLetter(String s) {
        /**
         * Runtime: 3 ms, faster than 90.32% of Java online submissions for Greatest English Letter in Upper and Lower Case.
         * Memory Usage: 40.7 MB, less than 95.33% of Java online submissions for Greatest English Letter in Upper and Lower Case.
         */
        int[] alphabetLow = new int[26];
        int[] alphabetUp = new int[26];
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(temp >= 65 && temp <= 90){
                alphabetUp[temp - 'A']++;
            } else if(temp >= 97 && temp <= 122){
                alphabetLow[temp - 'a']++;
            }
        }
        int maxIndex = -1;
        for(int j = 0; j < 26; j++){
            if(alphabetLow[j] > 0 && alphabetUp[j] > 0){
                maxIndex = j;
            }
        }
        return maxIndex == -1 ? "" : new Character((char)(maxIndex + 65)).toString();
    }

}
