package com.leetcode.algorithms.MediumMode;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 *
 * Example 2:
 *
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 *
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the list is in the range [0, 5 * 104].
 *     -105 <= Node.val <= 105
 *
 *
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 */
public class SortList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        /**
         * Merge Sort
         * Runtime: 16 ms, faster than 71.81% of Java online submissions for Sort List.
         * Memory Usage: 78.5 MB, less than 42.09% of Java online submissions for Sort List.
         */

        if (head == null)
            return null;

        ListNode last = head;

        while (last.next != null)
            last = last.next;

        return sort(head, last);
    }

    public ListNode sort(ListNode first, ListNode last) {

        if (first == last)
            return new ListNode(first.val);

        ListNode m = mid(first, last);
        ListNode a = sort(first, m);
        ListNode b = sort(m.next, last);
        ListNode result = merge(a, b);

        return result;

    }

    public ListNode merge(ListNode first, ListNode second) {

        ListNode result = null;
        ListNode current = null;

        while(first != null && second != null) {
            if (first.val < second.val) {
                if (result == null) {
                    result = first;
                    current = first;
                } else {
                    current.next = first;
                }

                current = first;
                first = first.next;

            } else {
                if (result == null) {
                    result = second;
                    current = second;
                } else {
                    current.next = second;
                }

                current = second;
                second = second.next;
            }
        }

        if (first != null) {
            current.next = first;
        }
        if (second != null) {
            current.next = second;
        }

        return result;

    }

    public ListNode mid(ListNode value, ListNode last) {

        ListNode first = value;
        ListNode second = value;

        while (second != last && second.next != last) {
            first = first.next;
            second = second.next.next;
        }

        return first;

    }

}
