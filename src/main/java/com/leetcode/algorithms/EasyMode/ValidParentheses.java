package com.leetcode.algorithms.EasyMode;

import java.util.Stack;

/**
 * @author YHW
 * @ClassName: ValidParentheses
 * @Description:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * @date 2019/2/22 9:31
 */
public class ValidParentheses {

    /**
     * @Status:Accepted
     * @Runtime:4 ms
     * @Memory:37.1 MB
     */
    public static boolean isValid(String s) {
        Stack stack = new Stack();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else if(c == ']' && !stack.empty()){
                if((char)stack.peek() == '['){
                    stack.pop();
                }else{
                    return false;
                }
            }
            else if(c == '}' && !stack.empty()){
                if((char)stack.peek() == '{'){
                    stack.pop();
                }else{
                    return false;
                }
            }
            else if(c == ')' && !stack.empty()){
                if((char)stack.peek() == '('){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }


    public static void main(String[] args){
        String model = "{(})";
        System.out.println(isValid(model));
    }
}
