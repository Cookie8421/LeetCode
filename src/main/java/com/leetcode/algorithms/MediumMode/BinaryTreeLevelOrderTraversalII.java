package com.leetcode.algorithms.MediumMode;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[15,7],[9,20],[3]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 */
public class BinaryTreeLevelOrderTraversalII {

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

    /*public List<List<Integer>> levelOrderBottom(TreeNode root) {
        *//**
         * Runtime: 4 ms, faster than 6.11% of Java online submissions for Binary Tree Level Order Traversal II.
         * Memory Usage: 43.3 MB, less than 72.08% of Java online submissions for Binary Tree Level Order Traversal II.
         *//*
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> temp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int current = 1;
        int next = 0;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.left != null){
                queue.offer(cur.left);
                next++;
            }
            if(cur.right != null){
                queue.offer(cur.right);
                next++;
            }
            current--;
            temp.add(cur.val);
            if(current == 0){
                current = next;
                next = 0;
                stack.push(temp);
                temp = new ArrayList<>();
            }
        }
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }*/

    /**
     * Runtime: 1 ms, faster than 98.81% of Java online submissions for Binary Tree Level Order Traversal II.
     * Memory Usage: 43.3 MB, less than 66.56% of Java online submissions for Binary Tree Level Order Traversal II.
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        travelTree(0, root, result);
        List<List<Integer>> reverseRst = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            reverseRst.add(result.get(result.size() - i - 1));
        }
        return reverseRst;
    }

    private void travelTree(int level, TreeNode root, List<List<Integer>> result) {
        if (root == null) return;
        if (result.size() <= level) result.add(new ArrayList<>());
        result.get(level).add(root.val);
        travelTree(level + 1, root.left, result);
        travelTree(level + 1, root.right, result);
    }

}
