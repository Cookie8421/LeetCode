package com.leetcode.algorithms.EasyMode;

/**
 * @author YHW
 * @ClassName: MergeTwoSortedLists
 * @Description:
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * @date 2019/2/22 12:53
 */
public class MergeTwoSortedLists {
    ListNode result = new ListNode(1);

    /**
     * @方式:递归
     * @Status:Accepted
     * @Runtime:5 ms
     * @Memory:43.4 MB
     *
     * @方式:迭代
     * @Status:Accepted
     * @Runtime:6 ms
     * @Memory:40.2 MB
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //递归方式
        //manage(result, l1, l2);
        //迭代方式
        ListNode head = result;
        while(true){
            if(l1 == null){
                result.next = l2;
                return head.next;
            }else if(l2 == null){
                result.next = l1;
                return head.next;
            }
            if(l1.val > l2.val){
                result.next = l2;
                l2 = l2.next;
            }else{
                result.next = l1;
                l1 = l1.next;
            }
            result = result.next;
        }
    }

    /*public static void manage(ListNode result, ListNode l1, ListNode l2){
        if(l1 == null){
            result.next = l2;
            return ;
        }else if(l2 == null){
            result.next = l1;
            return ;
        }

        if(l1.val > l2.val){
            result.next = l2;
            manage(result.next, l1, l2.next);
        }else{
            result.next = l1;
            manage(result.next, l1.next, l2);
        }

    }*/

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args){

    }
}
