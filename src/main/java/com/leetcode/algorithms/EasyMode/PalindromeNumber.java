package com.leetcode.algorithms.EasyMode;

import java.util.*;

/**
 * @author JoeyYoung
 * @version 1.0.0
 * @ClassName PalindromeNumber
 * @Description
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward.
 *
 *     For example, 121 is a palindrome while 123 is not.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 *
 *
 * Constraints:
 *
 *     -231 <= x <= 231 - 1
 *
 *
 * Follow up: Could you solve it without converting the integer to a string?
 * @createTime 2022/4/2 10:44
 *
 */
public class PalindromeNumber {

    /**
     * Runtime: 26 ms, faster than 11.52% of Java online submissions for Palindrome Number.
     * Memory Usage: 47.6 MB, less than 8.46% of Java online submissions for Palindrome Number.
     */
    public boolean isPalindrome(int x) {
        if(0 <= x && x < 10){
            return true;
        } else if(x < 0){
            return false;
        }
        List list = new ArrayList();
        Stack stack = new Stack();
        int t = 10;
        while(x > 0){
            int tmp = x%t;
            list.add(tmp);
            stack.push(tmp);
            x/=t;
        }
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            if(iterator.next() != stack.pop()){
                return false;
            }
        }
        return true;
    }

}
