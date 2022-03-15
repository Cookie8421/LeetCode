package com.leetcode.algorithms.MediumMode;


/**
 * Given the root of a binary tree,
 * find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
 *
 * A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.
 */
public class MaximumDifferenceBetweenNodeAndAncestor {

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
     * Runtime: 1 ms, faster than 62.67% of Java online submissions for Maximum Difference Between Node and Ancestor.
     * Memory Usage: 42.4 MB, less than 42.20% of Java online submissions for Maximum Difference Between Node and Ancestor.
     */
    public int maxAncestorDiff(TreeNode root) {
        return helper(root, root.val, root.val);
    }

    public int helper(TreeNode root, int min, int max) {
        if(root == null)
            return 0;
        int diff = Math.max(Math.abs(root.val - min), Math.abs(root.val-max));
        int leftDiff = helper(root.left,Math.min(root.val,min), Math.max(root.val,max));
        int rightDiff = helper(root.right,Math.min(root.val,min), Math.max(root.val,max));

        return Math.max(diff, Math.max(leftDiff,rightDiff));
    }
}
