package com.leetcode.algorithms.MediumMode;

import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class MiniParser {

    /**
     * Runtime: 6 ms, faster than 76.28% of Java online submissions for Mini Parser.
     * Memory Usage: 46 MB, less than 43.43% of Java online submissions for Mini Parser.
     */
    public NestedInteger deserialize(String s) {
        Deque<NestedInteger> stack = new ArrayDeque<>();
        NestedInteger cur = new NestedInteger();
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++) {
            if(c[i] == '-' || c[i] >= '0' && c[i] <= '9') {
                boolean sign = c[i] == '-';
                int val = sign ? 0 : c[i] - '0';
                while(i+1 < c.length && c[i+1] >= '0' && c[i+1] <= '9') val = val * 10 + c[++i] - '0';
                cur.add(new NestedInteger(sign ? -val : val));
            } else if(c[i] == '[') {
                stack.push(cur);
                cur = new NestedInteger();
            } else if(c[i] == ']') {
                stack.peek().add(cur);
                cur = stack.pop();
            }
        }
        return cur.getList().iterator().next();
    }

    public class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger() {

        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {

        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return false;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return 0;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {

        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return null;
        }
    }

}
