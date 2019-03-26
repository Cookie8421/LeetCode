package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YHW
 * @ClassName: LetterCombinationsOfAPhoneNumber
 * @Description:
 * Share
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * 思路：BackTracking
 * @date 2019/3/8 16:44
 */
public class LetterCombinationsOfAPhoneNumber {


    /*
        重点算法思想：回溯法
     */
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    static int count = 0;

    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
            count++;
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0){
            backtrack("", digits);
        }
        return output;
    }

    public static void main(String[] args){
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("29353"));
        System.out.println("共有：" + count + "种组合");
    }
}
