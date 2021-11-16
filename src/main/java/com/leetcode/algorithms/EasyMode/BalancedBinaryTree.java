package com.leetcode.algorithms.EasyMode;

/**
 * @Author JoeyYoung
 * @ClassName: Balanced Binary Tree
 * @Date 2021/11/16 8:54
 * @Description:
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */
public class BalancedBinaryTree {
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
     * Runtime: 1 ms, faster than 57.94% of Java online submissions for Balanced Binary Tree.
     * Memory Usage: 39.1 MB, less than 61.22% of Java online submissions for Balanced Binary Tree.
     */
    public static class ResultStruct {
        int depth;
        boolean isBalanced;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return isBalancedBranch(root).isBalanced ? true : false;
    }
    public static ResultStruct isBalancedBranch(TreeNode current) {
        ResultStruct leftResult = null;
        ResultStruct rightResult = null;
        ResultStruct currentResult = new ResultStruct();
        if(current.left != null){
            leftResult = isBalancedBranch(current.left);
            if(!leftResult.isBalanced){
                currentResult.isBalanced = false;
                return currentResult;
            }
        } else {
            leftResult = new ResultStruct();
            leftResult.depth = 0;
            leftResult.isBalanced = true;
        }
        if(current.right != null){
            rightResult = isBalancedBranch(current.right);
            if(!rightResult.isBalanced){
                currentResult.isBalanced = false;
                return currentResult;
            }
        } else {
            rightResult = new ResultStruct();
            rightResult.depth = 0;
            rightResult.isBalanced = true;
        }
        currentResult.depth = Math.max(leftResult.depth, rightResult.depth) + 1;
        currentResult.isBalanced = Math.abs(leftResult.depth - rightResult.depth) > 1 ? false : true;
        return currentResult;
    }


    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Balanced Binary Tree.
     * Memory Usage: 39.2 MB, less than 61.22% of Java online submissions for Balanced Binary Tree.
     */
    /*public boolean isBalanced(TreeNode root) {
        return checkBalance(root)==-1 ? false: true;
    }


    int checkBalance(TreeNode root){
        if (root == null)
            return 0;
        int left = checkBalance(root.left);
        if (left == -1)
            return -1;
        left += 1;
        int right = checkBalance(root.right);
        if (right == -1)
            return -1;
        right += 1;
        if (Math.abs(right - left) > 1)
            return -1;
        return Math.max(left, right);
    }*/
}
