package com.leetcode.algorithms.EasyMode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree,
 * return the average value of the nodes on each level in the form of an array.
 * Answers within 10-5 of the actual answer will be accepted.
 */
public class AverageOfLevelsInBinaryTree {

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
     * Runtime: 3 ms, faster than 67.75% of Java online submissions for Average of Levels in Binary Tree.
     * Memory Usage: 47.9 MB, less than 22.54% of Java online submissions for Average of Levels in Binary Tree.
     */
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        queue.offer(root);
        recursion(result, queue, queue.size());
        return result;
    }

    public void recursion(List<Double> result, Queue<TreeNode> queue, int count){
        if(count == 0){
            return;
        }
        int sum = count;
        Double acc = 0.00;
        while(count > 0){
            TreeNode current = queue.poll();
            if(current.left != null){
                queue.offer(current.left);
            }
            if(current.right != null){
                queue.offer(current.right);
            }
            acc = Double.sum(acc, current.val);
            count--;
        }
        result.add(acc / sum);
        recursion(result, queue, queue.size());
    }
}

