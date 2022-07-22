package com.leetcode.algorithms.MediumMode;


/**
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 *
 * Example 2:
 *
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the list is n.
 *     1 <= n <= 500
 *     -500 <= Node.val <= 500
 *     1 <= left <= right <= n
 *
 *
 * Follow up: Could you do it in one pass?
 */
public class ReverseLinkedListII {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rev(ListNode head)
    {
        ListNode curr=head,prev=null,next=null;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
     * Memory Usage: 42.4 MB, less than 13.41% of Java online submissions for Reverse Linked List II.
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right)
            return head;
        ListNode l=null,r=null,curr=head;
        int c=0;
        while(curr!=null)
        {
            c++;
            if(c==left)
                break;
            l=curr;
            curr=curr.next;
        }
        ListNode lt=curr;
        while(curr!=null)
        {

            if(c==right)
                break;
            c++;
            curr=curr.next;
        }
        r=curr.next;
        curr.next=null;
        lt=rev(lt);
        if(l==null)
            head=lt;
        else
            l.next=lt;
        while(lt.next!=null)
        {
            lt=lt.next;
        }
        lt.next=r;
        return head;
    }
}
