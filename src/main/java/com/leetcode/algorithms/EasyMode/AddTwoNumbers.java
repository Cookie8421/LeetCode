package com.leetcode.algorithms.EasyMode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author YHW
 * @ClassName: AddTwoNumbers
 * @Description:
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * @date 2019/2/22 13:52
 */
public class AddTwoNumbers {

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
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);

            ListNode ret = new Solution().addTwoNumbers(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(1);
        double i1 = 0D;
        double i2 = 0D;
        double aux = 1D;
        while(l1 != null){
            i1 += l1.val * aux;
            aux *= 10D;
            l1 = l1.next;
        }
        aux = 1D;
        while(l2 != null){
            i2 += l2.val * aux;
            aux *= 10D;
            l2 = l2.next;
        }
        aux = 10D;
        Double temp = i1 + i2;
        System.out.println(temp);
        ListNode head = result;
        while(temp / aux >= 1D){
            Double val = temp % aux;
            result.next = new ListNode(val.intValue());
            temp /= aux;
            result = result.next;
        }
        result.next = new ListNode(temp.intValue());
        return head.next;
    }


}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
