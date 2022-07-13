package com.leetcode.algorithms.MediumMode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree,
 * return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 *
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 *
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [0, 2000].
 *     -1000 <= Node.val <= 1000
 */
public class BinaryTreeLevelOrderTraversal {

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
     * Runtime: 1 ms, faster than 92.53% of Java online submissions for Binary Tree Level Order Traversal.
     * Memory Usage: 43.1 MB, less than 75.99% of Java online submissions for Binary Tree Level Order Traversal.
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        if(root != null){
            genLevel(queue, 1, res);
        }
        return res;
    }

    public void genLevel(Queue<TreeNode> queue, int count, List<List<Integer>> res){
        int curLevelCount = 0;
        List<Integer> list = new ArrayList<>();
        while(count > 0){
            TreeNode tmp = queue.poll();
            list.add(tmp.val);
            if(tmp.left != null){
                queue.offer(tmp.left);
                curLevelCount++;
            }
            if(tmp.right != null){
                queue.offer(tmp.right);
                curLevelCount++;
            }
            count--;
        }
        res.add(list);
        if(queue.size() > 0){
            genLevel(queue, curLevelCount, res);
        }
    }

}
