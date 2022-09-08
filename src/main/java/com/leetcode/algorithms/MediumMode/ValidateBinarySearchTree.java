package com.leetcode.algorithms.MediumMode;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 *     The left subtree of a node contains only nodes with keys less than the node's key.
 *     The right subtree of a node contains only nodes with keys greater than the node's key.
 *     Both the left and right subtrees must also be binary search trees.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [2,1,3]
 * Output: true
 *
 * Example 2:
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [1, 104].
 *     -231 <= Node.val <= 231 - 1
 */
public class ValidateBinarySearchTree {

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

    int current = Integer.MIN_VALUE;
    boolean flag = false;

    public boolean isValidBST(TreeNode root) {
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
         * Memory Usage: 42 MB, less than 91.67% of Java online submissions for Validate Binary Search Tree.
         */
        if(root.left != null){
            if(!isValidBST(root.left)){
                return false;
            }
        }
        if(root.val <= current && flag){
            return false;
        }
        if(!flag){
            flag = true;
        }
        current = root.val;
        if(root.right != null){
            if(!isValidBST(root.right)){
                return false;
            }
        }
        return true;
    }

}
