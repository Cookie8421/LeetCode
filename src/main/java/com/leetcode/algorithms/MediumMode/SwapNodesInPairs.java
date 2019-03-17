package com.leetcode.algorithms.MediumMode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author YHW
 * @ClassName: ValidParentheses
 * @Description:
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * @date 2019/3/17 10:59
 */
public class SwapNodesInPairs {

    /**
     * @Status:Accepted
     * @Runtime:2 ms
     * @Memory:36.9 MB
     */
    //三指针法
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode t1 = head;
        ListNode t2 = head.next;
        ListNode t3 = t1;
        boolean isFirst = true;
        while(true){
            if(t1 == null || t2 == null){
                break;
            }
            t1.next = t2.next;
            t2.next = t1;
            if(isFirst){
                head = t2;
                isFirst = false;
            }else{
                t3.next = t2;
                t3 = t1;
            }
            if(t1.next == null){
                break;
            }else{
                t1 = t1.next.next;
                t2 = t2.next.next;
                //交换指针
                ListNode temp = t1;
                t1 = t2;
                t2 = temp;
            }
        }
        return head;
    }
}

class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            ListNode ret = new SwapNodesInPairs().swapPairs(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}
