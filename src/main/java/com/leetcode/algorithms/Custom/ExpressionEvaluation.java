package com.leetcode.algorithms.Custom;

import java.util.Stack;

/**
 * @author YHW
 * @ClassName: ExpressionEvaluation
 * @Description:
 * @date 2019/3/6 14:40
 */
public class ExpressionEvaluation {

    public static int eval(String expression){
        Stack<Integer> operandStack = new Stack<Integer>();
        Stack<Character> operatorStack = new Stack<Character>();

        int start = 0;
        int end = 0;
        int currentLevel = 1;
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '+'){
                if(currentLevel == 0){
                    if(!operatorStack.isEmpty()){

                    }
                }
            }else if(expression.charAt(i) == '-'
                    ||expression.charAt(i) == '/'
                    ||expression.charAt(i) == '*'){

            }else if(expression.charAt(i) > 47 && expression.charAt(i) < 58){
                end++;
            }else if(expression.charAt(i) == 40){
                operatorStack.push(expression.charAt(i));
            }else if(expression.charAt(i) == 41){

            }
            int temp = Integer.parseInt(expression.substring(start, end));
            operandStack.push(temp);
            operatorStack.push(expression.charAt(i));
            start = i + 1;
            end = start;
        }
        int temp = Integer.parseInt(expression.substring(start, end));
        operandStack.push(temp);
        return 1;
    }

    public static void main(String[] args){

    }
}
