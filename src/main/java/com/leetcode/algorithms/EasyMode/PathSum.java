package com.leetcode.algorithms.EasyMode;

/**
 * @author JoeyYoung
 * @ClassName: PathSum
 * @Description:
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 * A leaf is a node with no children.
 * @date 2021/11/6 15:45
 */
public class PathSum {

    public static class TreeNode {
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
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
     * Memory Usage: 38.8 MB, less than 86.25% of Java online submissions for Path Sum.
     *
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null && root.val == targetSum){
            return true;
        }
        if(root.left != null && check(root.left, targetSum, root.val)){
            return true;
        }
        if(root.right != null && check(root.right, targetSum, root.val)){
            return true;
        }
        return false;
    }

    public static boolean check(TreeNode current, int targetSum, int sum){
        sum += current.val;
        if(current.left == null && current.right == null && sum == targetSum){
            return true;
        }
        if(current.left != null && check(current.left, targetSum, sum)){
            return true;
        }
        if(current.right != null && check(current.right, targetSum, sum)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
