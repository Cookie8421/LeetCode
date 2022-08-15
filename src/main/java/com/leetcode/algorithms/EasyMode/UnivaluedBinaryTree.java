package com.leetcode.algorithms.EasyMode;

/**
 * A binary tree is uni-valued if every node in the tree has the same value.
 *
 * Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,1,1,1,1,null,1]
 * Output: true
 *
 * Example 2:
 *
 * Input: root = [2,2,2,5,2]
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [1, 100].
 *     0 <= Node.val < 100
 */
public class UnivaluedBinaryTree {


    public boolean isUnivalTree(TreeNode root) {
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Univalued Binary Tree.
         * Memory Usage: 41.6 MB, less than 64.36% of Java online submissions for Univalued Binary Tree.
         */
        if(dfs(root.left, root.val) && dfs(root.right, root.val)){
            return true;
        } else {
            return false;
        }
    }

    public boolean dfs(TreeNode root, int val){
        if(root == null){
            return true;
        }
        if(root.val != val){
            return false;
        }
        if(dfs(root.left, root.val) && dfs(root.right, root.val)){
            return true;
        } else {
            return false;
        }
    }

}
class TreeNode {
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
