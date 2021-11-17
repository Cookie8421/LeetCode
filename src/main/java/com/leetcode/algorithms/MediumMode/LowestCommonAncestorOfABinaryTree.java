package com.leetcode.algorithms.MediumMode;

/**
 * @Author JoeyYoung
 * @ClassName: Lowest Common Ancestor of a Binary Tree
 * @Date 2021/11/17 8:48
 * @Description:
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestorOfABinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    /**
     *
     * Runtime: 4 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     * Memory Usage: 41 MB, less than 83.75% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        TreeNode left = lowestCommonAncestor(root.left, p ,q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);
        if(root.val != q.val && root.val != p.val){
            if(left != null && right != null){
                return root;
            } else if (left == null && right == null){
                return null;
            } else if(left != null) {
                return left;
            } else if(right != null){
                return right;
            }
            return null;
        } else {
            return root;
        }
    }

}
