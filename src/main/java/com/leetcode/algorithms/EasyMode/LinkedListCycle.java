package com.leetcode.algorithms.EasyMode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JoeyYoung
 * @ClassName: Linked List Cycle
 * @Date 2021/12/7 16:45
 * @Description:
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 * Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 *
 *
 * Constraints:
 *
 *     The number of the nodes in the list is in the range [0, 104].
 *     -105 <= Node.val <= 105
 *     pos is -1 or a valid index in the linked-list.
 *
 *
 *
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    List<ListNode> tmpList = new ArrayList<>();

    /**
     * Runtime: 495 ms, faster than 5.18% of Java online submissions for Linked List Cycle.
     * Memory Usage: 43.8 MB, less than 5.72% of Java online submissions for Linked List Cycle.
     */
    public boolean hasCycle(ListNode head) {
        while(true){
            if(head == null || head.next == null){
                return false;
            }
            if(tmpList.contains(head.next)){
                return true;
            }
            tmpList.add(head);
            head = head.next;
        }
    }


    /*
    public boolean hasCycle(ListNode head) {
        if(head == null){
         return false;
        }
        if(head.val == Integer.MAX_VALUE){
             return true;
        }
        head.val = Integer.MAX_VALUE;
        return hasCycle(head.next);
    }
    */

}
