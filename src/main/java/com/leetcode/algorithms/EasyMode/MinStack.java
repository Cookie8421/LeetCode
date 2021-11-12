package com.leetcode.algorithms.EasyMode;

import java.util.Stack;

/**
 * @Author JoeyYoung
 * @ClassName: Min Stack
 * @Date 2021/11/12 10:02
 * @Description:
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 *     MinStack() initializes the stack object.
 *     void push(int val) pushes the element val onto the stack.
 *     void pop() removes the element on the top of the stack.
 *     int top() gets the top element of the stack.
 *     int getMin() retrieves the minimum element in the stack.
 *
 *
 *  * Your MinStack object will be instantiated and called as such:
 *  * MinStack obj = new MinStack();
 *  * obj.push(val);
 *  * obj.pop();
 *  * int param_3 = obj.top();
 *  * int param_4 = obj.getMin();
 *
 */
public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    /**
     * Runtime: 5 ms, faster than 75.30% of Java online submissions for Min Stack.
     * Memory Usage: 40.6 MB, less than 81.98% of Java online submissions for Min Stack.
     */

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(!minStack.isEmpty()){
            minStack.push(Math.min(minStack.peek(), val));
        } else {
            minStack.push(val);
        }
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {

    }
}


