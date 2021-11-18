package com.leetcode.algorithms.MediumMode;

/**
 * @Author JoeyYoung
 * @ClassName: Rotate List
 * @Date 2021/11/18 14:43
 * @Description:
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 * Constraints:
 *
 *     The number of nodes in the list is in the range [0, 500].
 *     -100 <= Node.val <= 100
 *     0 <= k <= 2 * 109
 *
 */
public class RotateList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate List.
     * Memory Usage: 38.5 MB, less than 61.11% of Java online submissions for Rotate List.
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        if(head.next == null || k == 0){
            return head;
        }
        int count = 1;
        int tail = 0;
        ListNode tmpNode = head;
        ListNode tailNode = head;
        while(tailNode.next != null){
            tailNode = tailNode.next;
            count++;
        }
        if(k % count == 0){
            return head;
        } else if(count > k){
            tail = count - k;
        } else if (count < k){
            tail = count - (k % count);
        }
        while(tail > 1){
            tmpNode = tmpNode.next;
            tail--;
        }
        ListNode result = tmpNode.next;
        tmpNode.next = null;
        tailNode.next = head;
        return result;
    }


}
