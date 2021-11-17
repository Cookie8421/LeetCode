package com.leetcode.algorithms.EasyMode;

import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

/**
 * @Author JoeyYoung
 * @ClassName: Minimum Depth of Binary Tree
 * @Date 2021/11/17 15:38
 * @Description:
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [0, 105].
 *     -1000 <= Node.val <= 1000
 */
public class MinimumDepthOfBinaryTree {

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
     * Runtime: 5 ms, faster than 68.00% of Java online submissions for Minimum Depth of Binary Tree.
     * Memory Usage: 59.4 MB, less than 82.05% of Java online submissions for Minimum Depth of Binary Tree.
     */
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        Queue<TreeNode> frontQueue = new LinkedTransferQueue();
        Queue<TreeNode> backQueue = new LinkedTransferQueue();
        int currentLevel = 0;
        frontQueue.add(root);
        while(!frontQueue.isEmpty() || !backQueue.isEmpty()){
            if(backQueue.isEmpty()){
                backQueue.addAll(frontQueue);
                frontQueue.clear();
                currentLevel++;
            } else {
                TreeNode tmp = backQueue.poll();
                if(tmp.left == null & tmp.right == null){
                    break;
                } else {
                    if(tmp.left != null){
                        frontQueue.add(tmp.left);
                    }
                    if(tmp.right != null){
                        frontQueue.add(tmp.right);
                    }
                }
            }
        }
        return currentLevel;
    }
}
