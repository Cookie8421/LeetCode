package com.leetcode.algorithms.EasyMode;

/**
 * @Author JoeyYoung
 * @ClassName: Remove Duplicates from Sorted List
 * @Date 2021/11/18 14:11
 * @Description:
 *
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 *
 * Constraints:
 *
 *     The number of nodes in the list is in the range [0, 300].
 *     -100 <= Node.val <= 100
 *     The list is guaranteed to be sorted in ascending order.
 *
 */
public class RemoveDuplicatesFromSortedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
     * Memory Usage: 38.6 MB, less than 47.23% of Java online submissions for Remove Duplicates from Sorted List.
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        int current = head.val;
        ListNode currentNode = head;
        ListNode tmpNode = head;
        while(currentNode != null){
            if(current != currentNode.val){
                tmpNode.next = currentNode;
                tmpNode = currentNode;
                current = currentNode.val;
                currentNode = currentNode.next;
            } else {
                currentNode = currentNode.next;
                if(currentNode == null){
                    tmpNode.next = null;
                }
            }
        }
        return head;
    }

}
