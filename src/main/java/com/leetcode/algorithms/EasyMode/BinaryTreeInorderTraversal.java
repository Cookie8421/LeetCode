package com.leetcode.algorithms.EasyMode;

import java.util.*;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [0, 100].
 *     -100 <= Node.val <= 100
 *
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {

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

    public List<Integer> inorderTraversal(TreeNode root) {
        /**
         * Runtime: 2 ms, faster than 50.10% of Java online submissions for Binary Tree Inorder Traversal.
         * Memory Usage: 42.8 MB, less than 9.83% of Java online submissions for Binary Tree Inorder Traversal.
         */
        List<Integer>list=new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();
        while(!stack.empty() || root!=null){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.peek();
            stack.pop();
            list.add(root.val);
            root=root.right;
        }
        return list;
    }
}
