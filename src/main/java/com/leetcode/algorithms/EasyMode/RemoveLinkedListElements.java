package com.leetcode.algorithms.EasyMode;

/**
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 *
 * Example 2:
 *
 * Input: head = [], val = 1
 * Output: []
 *
 * Example 3:
 *
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the list is in the range [0, 104].
 *     1 <= Node.val <= 50
 *     0 <= val <= 50
 */
public class RemoveLinkedListElements {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements(ListNode head, int val) {
        /**
         * Runtime: 1 ms, faster than 99.05% of Java online submissions for Remove Linked List Elements.
         * Memory Usage: 43.4 MB, less than 88.33% of Java online submissions for Remove Linked List Elements.
         */
        ListNode ans = head;
        while(head != null && head.val == val){
            head = head.next;
            ans = head;
        }
        while(head != null){
            while(head.next != null && head.next.val == val){
                head.next = head.next.next;
            }
            head = head.next;
        }
        return ans;
    }

}
