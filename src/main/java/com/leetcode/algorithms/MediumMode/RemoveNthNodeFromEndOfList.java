package com.leetcode.algorithms.MediumMode;

import javax.tools.Diagnostic;
import java.util.Stack;

/**
 * @author YHW
 * @ClassName: RemoveNthNodeFromEndOfList
 * @Description:
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Given n will always be valid.
 *
 * Could you do this in one pass?
 * @date 2019/3/11 11:04
 */
public class RemoveNthNodeFromEndOfList {


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Stack nodeStack = new Stack();
        ListNode temp = head;
        ListNode precursor;
        ListNode successor;
        while(temp.next != null){
            nodeStack.push(temp);
            temp = temp.next;
        }
        nodeStack.push(temp);
        while(n > 1){
            temp = (ListNode)nodeStack.pop();
            n--;
        }
        if(!nodeStack.empty()){
            if(temp == nodeStack.peek()){
                if((temp = (ListNode) nodeStack.pop()) != null){
                    temp.next = null;
                    return head;
                }
                return null;
            }
            successor = temp;
            temp = (ListNode)nodeStack.pop();
            if(nodeStack.empty()){
                return head.next;
            }
            precursor = (ListNode)nodeStack.pop();
            precursor.next = successor;
        }else{
            return null;
        }
        return head;
    }



    public static void main(String[] args){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        ListNode li = removeNthFromEnd(listNode, 2);
        while(li != null){
            System.out.println(li.val);
            li = li.next;
        }
    }


}
