package com.leetcode.algorithms.MediumMode;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Stack;

/**
 * @author JoeyYoung
 * @ClassName: PathSum
 * @Description:
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * @date 2021/11/6 15:45
 */

public class RemoveNthFromEnd {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        public int[] toArray(){
            int[] result = new int[]{val};
            return next == null ? result : ArrayUtils.addAll(result, next.toArray());
        }
    }

    /**
     *
     * Runtime: 1 ms, faster than 35.36% of Java online submissions for Remove Nth Node From End of List.
     * Memory Usage: 37 MB, less than 73.87% of Java online submissions for Remove Nth Node From End of List.
     *
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Stack stack = new Stack();
        ListNode current = head;
        stack.push(head);
        while(current.next != null){
            stack.push(current.next);
            current = current.next;
        }

        while(!stack.empty() && n > 1){
            stack.pop();
            n--;
        }
        ListNode targetNode = (ListNode) stack.pop();
        if(stack.empty()){
            head = targetNode.next;
        } else {
            ListNode targetNodeFront = (ListNode) stack.pop();
            targetNodeFront.next = targetNode.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int[] nodeArray = listNode.toArray();
        for(int i = 0; i < nodeArray.length; i++){
            System.out.println(nodeArray[i] + ",");
        }
        listNode = removeNthFromEnd(listNode, 2);
        nodeArray = listNode.toArray();
        for(int i = 0; i < nodeArray.length; i++){
            System.out.println(nodeArray[i] + ",");
        }
    }
}
