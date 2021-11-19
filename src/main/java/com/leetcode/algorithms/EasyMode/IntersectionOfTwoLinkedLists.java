package com.leetcode.algorithms.EasyMode;

import java.util.Stack;

/**
 * @Author JoeyYoung
 * @ClassName: Intersection of Two Linked Lists
 * @Date 2021/11/18 16:26
 * @Description:
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 *
 * For example, the following two linked lists begin to intersect at node c1:
 *
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 *
 * Note that the linked lists must retain their original structure after the function returns.
 *
 * Custom Judge:
 *
 * The inputs to the judge are given as follows (your program is not given these inputs):
 *
 *     intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
 *     listA - The first linked list.
 *     listB - The second linked list.
 *     skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
 *     skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
 *
 * The judge will then create the linked structure based on these inputs and pass the two heads,
 * headA and headB to your program. If you correctly return the intersected node,
 * then your solution will be accepted.
 *
 *
 * Constraints:
 *
 *     The number of nodes of listA is in the m.
 *     The number of nodes of listB is in the n.
 *     0 <= m, n <= 3 * 104
 *     1 <= Node.val <= 105
 *     0 <= skipA <= m
 *     0 <= skipB <= n
 *     intersectVal is 0 if listA and listB do not intersect.
 *     intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
 *
 *
 */
public class IntersectionOfTwoLinkedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Runtime: 2 ms, faster than 43.57% of Java online submissions for Intersection of Two Linked Lists.
     * Memory Usage: 41.9 MB, less than 67.42% of Java online submissions for Intersection of Two Linked Lists.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode currentA = headA;
        ListNode currentB = headB;
        ListNode result = null;
        Stack<ListNode> stackA = new Stack();
        Stack<ListNode> stackB = new Stack();
        while(currentA != null){
            stackA.push(currentA);
            currentA = currentA.next;
        }
        while(currentB != null){
            stackB.push(currentB);
            currentB = currentB.next;
        }
        while(true){
            if(!stackA.isEmpty() && !stackB.isEmpty()){
                ListNode tmpA = stackA.pop();
                ListNode tmpB = stackB.pop();
                if(tmpA  == tmpB){
                    result = tmpA;
                } else {
                    return result;
                }
            } else {
                return result;
            }
        }

        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Intersection of Two Linked Lists.
         * Memory Usage: 41.6 MB, less than 85.91% of Java online submissions for Intersection of Two Linked Lists.
         */
        /*  ListNode a=headA;
            ListNode b=headB;

            int a1=0;
            int b1=0;
            while(a!=null)
            {
                a1++;
                a=a.next;
            }

            while(b!=null)
            {
                b1++;
                b=b.next;
            }

            int size=0;

            if(a1<b1)
            {
                size=b1-a1;

            }
            else
            {
                size=a1-b1;
            }

            for(int i=0;i<size;i++)
            {
                if(a1<b1)
                {
                    headB=headB.next;
                }
                else
                {
                    headA=headA.next;
                }

            }

            while(headA!=headB )
            {

                headA=headA.next;
                headB=headB.next;
            }

            return headA;
        */
    }

}
