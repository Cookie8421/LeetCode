package com.leetcode.algorithms.MediumMode;

/**
 * @Author JoeyYoung
 * @ClassName: Trim a Binary Search Tree
 * @Date 2021/11/23 9:43
 * @Description:
 * Given the root of a binary search tree and the lowest and highest boundaries as low and high,
 * trim the tree so that all its elements lies in [low, high].
 * Trimming the tree should not change the relative structure of the elements that will remain in the tree
 * (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.
 *
 * Return the root of the trimmed binary search tree.
 * Note that the root may change depending on the given bounds.
 *
 * Constraints:
 *
 *     The number of nodes in the tree in the range [1, 104].
 *     0 <= Node.val <= 104
 *     The value of each node in the tree is unique.
 *     root is guaranteed to be a valid binary search tree.
 *     0 <= low <= high <= 104
 *
 */
public class TrimABinarySearchTree {

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
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Trim a Binary Search Tree.
     * Memory Usage: 38.6 MB, less than 64.25% of Java online submissions for Trim a Binary Search Tree.
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return null;
        }
        if(root.val >= high){
            root.right = null;
            root.left = trimBST(root.left, low, high);
            return root.val == high ? root : trimBST(root.left, low, high);
        } else if(root.val <= low) {
            root.left = null;
            root.right = trimBST(root.right, low, high);
            return root.val == low ? root : trimBST(root.right, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
