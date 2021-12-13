package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author JoeyYoung
 * @ClassName: All Elements in Two Binary Search Trees
 * @Date 2021/12/10 17:16
 * @Description:
 * Given two binary search trees root1 and root2.
 *
 * Return a list containing all the integers from both trees sorted in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Input: root1 = [2,1,4], root2 = [1,0,3]
 * Output: [0,1,1,2,3,4]
 *
 * Example 2:
 *
 * Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * Output: [-10,0,0,1,2,5,7,10]
 *
 * Example 3:
 *
 * Input: root1 = [], root2 = [5,1,7,0,2]
 * Output: [0,1,2,5,7]
 *
 * Example 4:
 *
 * Input: root1 = [0,-10,10], root2 = []
 * Output: [-10,0,10]
 *
 * Example 5:
 *
 * Input: root1 = [1,null,8], root2 = [8,1]
 * Output: [1,1,8,8]
 *
 *
 *
 * Constraints:
 *
 *     Each tree has at most 5000 nodes.
 *     Each node's value is between [-10^5, 10^5].
 */
public class AllElementsInTwoBinarySearchTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Runtime: 8 ms, faster than 98.31% of Java online submissions for All Elements in Two Binary Search Trees.
     * Memory Usage: 42.5 MB, less than 46.99% of Java online submissions for All Elements in Two Binary Search Trees.
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList();
        dps(root1, stack);
        dps(root2, list, stack);
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    public static void dps(TreeNode root, Stack<Integer> stack){
        if(root == null){
            return;
        }
        dps(root.right, stack);
        stack.push(root.val);
        dps(root.left, stack);
    }
    public static void dps(TreeNode root, List<Integer> list, Stack<Integer> stack){
        if(root == null){
            return;
        }
        dps(root.left, list, stack);
        while(!stack.isEmpty()){
            if(stack.peek() < root.val){
                list.add(stack.pop());
            } else {
                list.add(root.val);
                break;
            }
        }
        if(stack.isEmpty()){
            list.add(root.val);
        }
        dps(root.right, list, stack);
    }


}
