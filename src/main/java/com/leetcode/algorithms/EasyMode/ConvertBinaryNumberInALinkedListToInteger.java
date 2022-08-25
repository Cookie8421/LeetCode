package com.leetcode.algorithms.EasyMode;

import com.leetcode.algorithms.Custom.ListNode;

import java.util.Stack;

/**
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 *
 * The most significant bit is at the head of the linked list.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 *
 * Example 2:
 *
 * Input: head = [0]
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *     The Linked List is not empty.
 *     Number of nodes will not exceed 30.
 *     Each node's value is either 0 or 1.
 */
public class ConvertBinaryNumberInALinkedListToInteger {

    public int getDecimalValue(ListNode head) {
        /**
         * Runtime: 2 ms, faster than 16.56% of Java online submissions for Convert Binary Number in a Linked List to Integer.
         * Memory Usage: 42.5 MB, less than 7.55% of Java online submissions for Convert Binary Number in a Linked List to Integer.
         */
        int ans = 0;
        Stack<Integer> stack = new Stack();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        int i = 0;
        while(!stack.isEmpty()){
            ans+=stack.pop()*Math.pow(2,i++);
        }
        return ans;

        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
         * Memory Usage: 42.2 MB, less than 18.99% of Java online submissions for Convert Binary Number in a Linked List to Integer.
         */
        /*
        int sum = 0;
        while(head!=null) {
            sum = sum*2;
            // normally we do sum*10 like in palindrome but its base 2 not base 10;
            sum = sum + head.val;
            head = head.next;
        }
        return sum;
         */
    }
}




