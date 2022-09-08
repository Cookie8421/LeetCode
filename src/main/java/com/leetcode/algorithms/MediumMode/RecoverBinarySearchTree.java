package com.leetcode.algorithms.MediumMode;

/**
 * You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,3,null,null,2]
 * Output: [3,1,null,null,2]
 * Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
 *
 * Example 2:
 *
 * Input: root = [3,1,4,null,null,2]
 * Output: [2,1,4,null,null,3]
 * Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [2, 1000].
 *     -231 <= Node.val <= 231 - 1
 *
 *
 * Follow up: A solution using O(n) space is pretty straight-forward. Could you devise a constant O(1) space solution?
 */
public class RecoverBinarySearchTree {

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

    private TreeNode first;
    private TreeNode prev;
    private TreeNode middle;
    private TreeNode last;
    public void recoverTree(TreeNode root) {
        /**
         * Runtime: 2 ms, faster than 99.94% of Java online submissions for Recover Binary Search Tree.
         * Memory Usage: 42.7 MB, less than 85.49% of Java online submissions for Recover Binary Search Tree.
         */
        first = null ;
        middle = null;
        last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(last != null){
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }else{
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(root.val < prev.val){
            if(first == null){
                first = prev;
                middle = root;
            }else{
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }

}
