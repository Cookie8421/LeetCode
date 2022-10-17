package com.leetcode.algorithms.MediumMode;

/**
 * Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.
 *
 * The steps of the insertion sort algorithm:
 *
 *     Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
 *     At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
 *     It repeats until no input elements remain.
 *
 * The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.
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
 *
 *
 * Constraints:
 *
 *     The number of nodes in the list is in the range [1, 5000].
 *     -5000 <= Node.val <= 5000
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        /**
         * Runtime: 3 ms, faster than 98.14% of Java online submissions for Insertion Sort List.
         * Memory Usage: 41.6 MB, less than 97.78% of Java online submissions for Insertion Sort List.
         */
        ListNode start = new ListNode(-5001);
        start.next = head;
        ListNode prev = start;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            if (current.val < prev.val) {
                prev.next = next;             // prev stays the same
                putInRightPlace(start, current);
            } else {
                prev = current;               // prev moves forward
            }
            current = next;
        }
        return start.next;
    }

    private void putInRightPlace(ListNode head, ListNode node) {
        while (head.next != null && node.val > head.next.val) {
            head = head.next;
        }

        ListNode next = head.next;
        head.next = node;
        node.next = next;
    }

}
