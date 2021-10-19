package com.leetcode.algorithms.MediumMode;

import sun.reflect.generics.tree.Tree;

import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

/**
 * @author YHW
 * @ClassName: DeepestLeavesSum
 * @Description:
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 * @date 2021/10/19 15:13
 */
public class DeepestLeavesSum {
    int result = 0;

    /**
     * Runtime: 62 ms, faster than 5.07% of Java online submissions for Deepest Leaves Sum.
     * Memory Usage: 64.7 MB, less than 6.05% of Java online submissions for Deepest Leaves Sum.
     */
    public int deepestLeavesSum(TreeNode root) {
        return findMaxDepth(root);
    }

    private int findMaxDepth(TreeNode node) {
        LinkedTransferQueue q1 = new LinkedTransferQueue();
        LinkedTransferQueue q2 = new LinkedTransferQueue();
        q1.add(node);
        return findDeepestLeavesSum(q1, q2);
    }
    private int findDeepestLeavesSum(LinkedTransferQueue q1, LinkedTransferQueue q2){
        int count = 0;
        while(!q1.isEmpty()){
            TreeNode tmp = (TreeNode)q1.poll();
            count += tmp.val;
            if(tmp.left != null){
                q2.add(tmp.left);
            }
            if(tmp.right != null){
                q2.add(tmp.right);
            }
        }
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
        if(!q1.isEmpty()){
            return findDeepestLeavesSum(q1, q2);
        }
        return count;
    }

    /**
     * Java DFS Fast Solution:
     *
     * public int deepestLeavesSum(TreeNode root) {
     *         dfs(root, 1);
     *         return sum;
     *     }
     *     int deepest;
     *     int sum;
     *
     *     void dfs(TreeNode root, int level) {
     *         if(root == null) return;
     *         if(root.left == null && root.right == null) {
     *             if(level > deepest) {
     *                 deepest = level;
     *                 sum = root.val;
     *             } else if(level == deepest) {
     *                 sum += root.val;
     *             }
     *         }
     *
     *         dfs(root.left, level+1);
     *         dfs(root.right, level+1);
     *     }
     */


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
