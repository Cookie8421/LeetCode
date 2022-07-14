package com.leetcode.algorithms.MediumMode;


/**
 *
 * Given two integer arrays preorder and inorder
 * where preorder is the preorder traversal of a binary tree
 * and inorder is the inorder traversal of the same tree,
 * construct and return the binary tree.
 *
 *
 *
 * Example 1:
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * Example 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 *
 *
 * Constraints:
 *
 *     1 <= preorder.length <= 3000
 *     inorder.length == preorder.length
 *     -3000 <= preorder[i], inorder[i] <= 3000
 *     preorder and inorder consist of unique values.
 *     Each value of inorder also appears in preorder.
 *     preorder is guaranteed to be the preorder traversal of the tree.
 *     inorder is guaranteed to be the inorder traversal of the tree.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

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
     * Runtime: 4 ms, faster than 64.48% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
     * Memory Usage: 43.7 MB, less than 80.65% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
     */

    private int preStart = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursion(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode recursion(int[] preorder, int[] inorder, int left, int right) {
        if (preStart == preorder.length || left > right ) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        for (int i = left; i <= right; i++) {
            if (preorder[preStart] == inorder[i]) {
                preStart++;
                root.left = recursion(preorder, inorder, left, i - 1);
                root.right = recursion(preorder, inorder, i + 1, right);
                break;
            }
        }
        return root;
    }

}
