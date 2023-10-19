package com.leetcode.algorithms.EasyMode;

import com.leetcode.algorithms.Custom.effective.ObjectReference.Stack;
import java.util.ArrayDeque;

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 *
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * Example 3:
 *
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 *
 *
 * Follow up: Can you solve it in O(n) time and O(1) space?
 */
public class BackspaceStringCompare {

    /**
     * Runtime
     * 2 ms
     * Beats
     * 62%
     * Memory
     * 41.2 MB
     * Beats
     * 6.26%
     */
    public boolean backspaceCompare(String s, String t) {
        ArrayDeque stack = new ArrayDeque<Character>();
        for(char c : s.toCharArray()){
            if(c != '#'){
                stack.push(c);
            } else if(!stack.isEmpty()){
                stack.pop();
            }
        }
        StringBuilder s1 = new StringBuilder();
        while(!stack.isEmpty()){
            s1.append(stack.pop());
        }
        for(char c : t.toCharArray()){
            if(c != '#'){
                stack.push(c);
            } else if(!stack.isEmpty()){
                stack.pop();
            }
        }
        StringBuilder t1 = new StringBuilder();
        while(!stack.isEmpty()){
            t1.append(stack.pop());
        }
        return s1.toString().equals(t1.toString());
    }

}
