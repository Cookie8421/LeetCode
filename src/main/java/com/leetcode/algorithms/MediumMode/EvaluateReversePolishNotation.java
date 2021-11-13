package com.leetcode.algorithms.MediumMode;

import java.util.Stack;

/**
 * @Author JoeyYoung
 * @ClassName: Evaluate Reverse Polish Notation
 * @Date 2021/11/13 8:55
 * @Description:
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 *
 * Note that division between two integers should truncate toward zero.
 *
 * It is guaranteed that the given RPN expression is always valid.
 * That means the expression would always evaluate to a result,
 * and there will not be any division by zero operation.
 *
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 */
public class EvaluateReversePolishNotation {


    /**
     *
     * Runtime: 5 ms, faster than 50.94% of Java online submissions for Evaluate Reverse Polish Notation.
     * Memory Usage: 38.7 MB, less than 79.64% of Java online submissions for Evaluate Reverse Polish Notation.
     */
    public static int evalRPN(String[] tokens) {
        Stack<String> tmpStack = new Stack<>();

        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-")|| tokens[i].equals("*")|| tokens[i].equals("/")){
                int right = Integer.parseInt(tmpStack.pop());
                int left = Integer.parseInt(tmpStack.pop());
                Integer result = 0;
                if(tokens[i].equals("+")){
                    result = left + right;
                } else if (tokens[i].equals("-")){
                    result = left - right;
                } else if (tokens[i].equals("*")){
                    result = left * right;
                } else if (tokens[i].equals("/")){
                    result = left / right;
                }
                tmpStack.push(result.toString());
            } else {
                tmpStack.push(tokens[i]);
            }
        }

        return Integer.parseInt(tmpStack.pop());
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"1", "2", "+"}));
    }
}
