package com.leetcode.algorithms.MediumMode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.
 *
 *     For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].
 *
 * Return the root of the reversed tree.
 *
 * A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.
 *
 * The level of a node is the number of edges along the path between it and the root node.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [2,3,5,8,13,21,34]
 * Output: [2,5,3,8,13,21,34]
 * Explanation:
 * The tree has only one odd level.
 * The nodes at level 1 are 3, 5 respectively, which are reversed and become 5, 3.
 *
 * Example 2:
 *
 * Input: root = [7,13,11]
 * Output: [7,11,13]
 * Explanation:
 * The nodes at level 1 are 13, 11, which are reversed and become 11, 13.
 *
 * Example 3:
 *
 * Input: root = [0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]
 * Output: [0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]
 * Explanation:
 * The odd levels have non-zero values.
 * The nodes at level 1 were 1, 2, and are 2, 1 after the reversal.
 * The nodes at level 3 were 1, 1, 1, 1, 2, 2, 2, 2, and are 2, 2, 2, 2, 1, 1, 1, 1 after the reversal.
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [1, 214].
 *     0 <= Node.val <= 105
 *     root is a perfect binary tree.
 */
public class ReverseOddLevelsofBinaryTree {

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

    public TreeNode reverseOddLevels(TreeNode root) {
        /**
         * Runtime: 2 ms, faster than 91.53% of Java online submissions for Reverse Odd Levels of Binary Tree.
         * Memory Usage: 71.8 MB, less than 77.41% of Java online submissions for Reverse Odd Levels of Binary Tree.
         */
        reverseTreeExceptRoot(root.left, root.right, 1);
        return root;
    }

    private void reverseTreeExceptRoot(TreeNode root1, TreeNode root2, int height) {
        if(root1 == null) return;

        reverseTreeExceptRoot(root1.left, root2.right, height + 1);
        reverseTreeExceptRoot(root1.right, root2.left, height + 1);

        if(height % 2 == 1) {
            int temp = root1.val;
            root1.val = root2.val;
            root2.val = temp;
        }
    }
}
