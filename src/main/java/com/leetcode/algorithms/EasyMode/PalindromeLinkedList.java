package com.leetcode.algorithms.EasyMode;

import java.util.Stack;

/**
 * @Author JoeyYoung
 * @ClassName: Palindrome Linked List
 * @Date 2021/11/18 10:45
 * @Description:
 * Given the head of a singly linked list,
 * return true if it is a palindrome.
 *
 * Constraints:
 *
 *     The number of nodes in the list is in the range [1, 105].
 *     0 <= Node.val <= 9
 *
 */
public class PalindromeLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Runtime: 9 ms, faster than 37.81% of Java online submissions for Palindrome Linked List.
     * Memory Usage: 51.7 MB, less than 51.42% of Java online submissions for Palindrome Linked List.
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode current = head;
        Stack<ListNode> stack = new Stack();
        stack.push(head);
        while(current.next != null){
            stack.push(current.next);
            current = current.next;
        }
        current = head;
        while(!stack.isEmpty()){
            if(stack.pop().val != current.val){
                return false;
            }
            current = current.next;
        }
        return true;
    }

    /**
     * Runtime: 3 ms, faster than 99.98% of Java online submissions for Palindrome Linked List.
     * Memory Usage: 49 MB, less than 81.22% of Java online submissions for Palindrome Linked List.
     */
    /*public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        ListNode temp;
        while (fast != null && fast.next != null) {//Reversing till the middle element
            fast = fast.next.next;
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        if (fast != null) {//This checks odd length case,by default even case is executed
            slow = slow.next;
        }
        while (prev != null && slow != null) {
            if (prev.val != slow.val)
                return false;
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }*/

}
