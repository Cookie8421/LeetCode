package com.leetcode.algorithms.MediumMode;

/**
 * Given the head of a linked list and a value x,
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 *
 * Example 2:
 *
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the list is in the range [0, 200].
 *     -100 <= Node.val <= 100
 *     -200 <= x <= 200
 */
public class PartitionList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    /**
     * Runtime: 1 ms, faster than 69.53% of Java online submissions for Partition List.
     * Memory Usage: 42.5 MB, less than 61.84% of Java online submissions for Partition List.
     */
    public ListNode partition(ListNode head, int x) {
        ListNode less = null , moreOrEq = null;
        ListNode lcurr = null, mcurr = null;
        while(head != null){
            if(head.val < x){
                if(less == null){
                    less = new ListNode(head.val);
                    lcurr = less;
                } else {
                    lcurr.next = new ListNode(head.val);
                    lcurr = lcurr.next;
                }
            } else {
                if(moreOrEq == null){
                    moreOrEq = new ListNode(head.val);
                    mcurr = moreOrEq;
                } else {
                    mcurr.next = new ListNode(head.val);
                    mcurr = mcurr.next;
                }
            }
            head = head.next;
        }
        if(less != null){
            if(moreOrEq != null){
                lcurr.next = moreOrEq;
            }
            return less;
        } else {
            if(moreOrEq != null){
                return moreOrEq;
            }
        }
        return null;
    }
}
