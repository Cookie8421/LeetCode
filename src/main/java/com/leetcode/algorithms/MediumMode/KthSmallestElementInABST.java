package com.leetcode.algorithms.MediumMode;

import java.util.Stack;

/**
 * @Author JoeyYoung
 * @ClassName: Kth Smallest Element in a BST
 * @Date 2021/12/3 14:25
 * @Description:
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 *
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is n.
 *     1 <= k <= n <= 104
 *     0 <= Node.val <= 104
 */
public class KthSmallestElementInABST {

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
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Kth Smallest Element in a BST.
     * Memory Usage: 39 MB, less than 60.39% of Java online submissions for Kth Smallest Element in a BST.
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        getLeftest(root, stack);
        TreeNode leftest = stack.pop();
        if(k == 1){
            return leftest.val;
        }
        while(k > 1){
            if(leftest.right != null){
                getLeftest(leftest.right, stack);
                leftest = stack.pop();
            } else {
                leftest = stack.pop();
            }
            k--;
        }
        return leftest.val;
    }

    public void getLeftest(TreeNode root, Stack stack) {
        stack.push(root);
        if(root.left != null){
            getLeftest(root.left, stack);
        }
        return;
    }

}
