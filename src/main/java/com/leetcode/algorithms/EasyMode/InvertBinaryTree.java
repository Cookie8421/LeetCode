package com.leetcode.algorithms.EasyMode;

/**
 * @Author JoeyYoung
 * @ClassName: Invert Binary Tree
 * @Date 2021/11/25 15:06
 * @Description:
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class InvertBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;     TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
     * Memory Usage: 36.5 MB, less than 61.29% of Java online submissions for Invert Binary Tree.
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
