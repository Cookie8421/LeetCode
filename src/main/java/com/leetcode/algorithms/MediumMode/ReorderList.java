package com.leetcode.algorithms.MediumMode;

/**
 * @Author JoeyYoung
 * @ClassName: Reorder List
 * @Date 2021/11/19 10:21
 * @Description:
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 *
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 *
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 * Constraints:
 *
 *     The number of nodes in the list is in the range [1, 5 * 104].
 *     1 <= Node.val <= 1000
 *
 */
public class ReorderList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Runtime: 1 ms, faster than 99.90% of Java online submissions for Reorder List.
     * Memory Usage: 42.6 MB, less than 37.41% of Java online submissions for Reorder List.
     */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode midNode = head;
        ListNode tailNode = head;
        while(tailNode != null && tailNode.next != null){
            tailNode = tailNode.next.next;
            midNode = midNode.next;
        }
        reorder(midNode.next, head);
        midNode.next = null;
    }

    public ListNode reorder(ListNode current, ListNode front) {
        if(current == null){
            return front;
        }
        front = reorder(current.next, front);
        if(current != null){
            ListNode tmpNode = front.next;
            current.next = front.next;
            front.next = current;
        }
        return front;
    }

    /**
     * Runtime: 1 ms, faster than 99.90% of Java online submissions for Reorder List.
     * Memory Usage: 42.7 MB, less than 36.38% of Java online submissions for Reorder List.
     */
    /*
    public void reorderList(ListNode head) {
        //Here is part with Floyd's fast/slow algorithm
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        //here we have two part of list, head(from start to middle)
        //and second part(from middle(exclusive) to end)
        rec(head, second);
    }

    //first -> 1 -> 2 -> 3
    //second -> 4 -> 5 -> 6
    //from bottom to top:
    //rec(first ->1, second-> 6) returns ->1, make 1->6->2
    //rec(first ->1, second-> 5) returns ->2, make 2->5->3
    //rec(first ->1, second-> 4) returns ->3, make 3->4->null
    private ListNode rec(final ListNode first, ListNode second) {
        if(second == null) return first;

        ListNode currentFirst = rec(first, second.next);

        ListNode nextAfterCurrent = currentFirst.next;
        currentFirst.next = second;
        second.next = nextAfterCurrent;

        return nextAfterCurrent;
    }
    */
}
