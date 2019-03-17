package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.List;
/**
 * @author YHW
 * @ClassName: ValidParentheses
 * @Description:
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * @date 2019/3/17 10:59
 */
public class GenerateParentheses {


    /**
     * @Status:Accepted
     * @Runtime:1 ms
     * @Memory:37.9 MB
     */
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }

    public static void main(String[] args){

        for(String item : generateParenthesis(3)){
            System.out.println(item);
        }
    }
}
