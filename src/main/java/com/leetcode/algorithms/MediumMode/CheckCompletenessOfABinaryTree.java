package com.leetcode.algorithms.MediumMode;

import com.sun.scenario.effect.impl.state.LinearConvolveKernel;

import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

/**
 * @Author JoeyYoung
 * @ClassName: Check Completeness of a Binary Tree
 * @Date 2021/11/29 10:09
 * @Description:
 * Given the root of a binary tree, determine if it is a complete binary tree.
 *
 * In a complete binary tree, every level, except possibly the last, is completely filled,
 * and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4,5,6]
 * Output: true
 * Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}),
 * and all nodes in the last level ({4, 5, 6}) are as far left as possible.
 *
 * Example 2:
 *
 * Input: root = [1,2,3,4,5,null,7]
 * Output: false
 * Explanation: The node with value 7 isn't as far left as possible.
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [1, 100].
 *     1 <= Node.val <= 1000
 *
 */
public class CheckCompletenessOfABinaryTree {

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
     * Runtime: 4 ms, faster than 7.83% of Java online submissions for Check Completeness of a Binary Tree.
     * Memory Usage: 38.4 MB, less than 55.38% of Java online submissions for Check Completeness of a Binary Tree.
     */
    public boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedTransferQueue<>();
        queue.add(root);
        boolean isLast = false;
        while(true){
            if(queue.isEmpty()){
                break;
            }
            TreeNode tmp = queue.poll();
            if(tmp.left == null && tmp.right != null) return false;
            if(isLast){
                if(tmp.left != null || tmp.right != null) return false;
            }
            if(tmp.left == null || tmp.right == null ) isLast = true;
            if(tmp.left != null) queue.add(tmp.left);
            if(tmp.right != null) queue.add(tmp.right);
        }
        return true;
    }

    //Better Solution:
    /*public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

			// Trick here is that if you encounter  null between two non-null values, it ain't complete binary tree.
            if (node == null && queue.peek() != null) return false;

            if (node != null)  {
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return true;
    }*/

}
