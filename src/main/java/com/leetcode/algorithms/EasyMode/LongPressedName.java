package com.leetcode.algorithms.EasyMode;

/**
 * Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
 *
 * You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
 *
 *
 *
 * Example 1:
 *
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 *
 * Example 2:
 *
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Explanation: 'e' must have been pressed twice, but it was not in the typed output.
 *
 *
 *
 * Constraints:
 *
 *     1 <= name.length, typed.length <= 1000
 *     name and typed consist of only lowercase English letters.
 */
public class LongPressedName {

    /**
     * Runtime: 1 ms, faster than 92.56% of Java online submissions for Long Pressed Name.
     * Memory Usage: 41.1 MB, less than 85.96% of Java online submissions for Long Pressed Name.
     */
    public boolean isLongPressedName(String name, String typed) {
        int length = typed.length();
        int nameIndex = 0;
        for(int i = 0; i < length; i++){
            if(nameIndex == name.length() && typed.charAt(i) == typed.charAt(i-1)){
                continue;
            } else if(nameIndex == name.length() && typed.charAt(i) != typed.charAt(i-1)){
                return false;
            }
            if(name.charAt(nameIndex) == typed.charAt(i)){
                nameIndex++;
                continue;
            } else {
                if(i == 0){
                    return false;
                } else {
                    if(name.charAt(nameIndex) != name.charAt(nameIndex-1) && typed.charAt(i) == typed.charAt(i-1)){
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        if(nameIndex == name.length()){
            return true;
        } else {
            return false;
        }
    }

}
