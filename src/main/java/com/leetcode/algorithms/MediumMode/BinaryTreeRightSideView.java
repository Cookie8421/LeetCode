package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 *
 * Example 2:
 *
 * Input: root = [1,null,3]
 * Output: [1,3]
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
 *     The number of nodes in the tree is in the range [0, 100].
 *     -100 <= Node.val <= 100
 */
public class BinaryTreeRightSideView {

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

    public List<Integer> rightSideView(TreeNode root) {
        /**
         * Runtime: 2 ms, faster than 52.96% of Java online submissions for Binary Tree Right Side View.
         * Memory Usage: 42.8 MB, less than 39.39% of Java online submissions for Binary Tree Right Side View.
         */
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int count = 1;
        int nextCount = 0;

        while(!queue.isEmpty()){
            count--;
            TreeNode current = queue.poll();
            if(current.left != null){
                nextCount++;
                queue.offer(current.left);
            }
            if(current.right != null){
                nextCount++;
                queue.offer(current.right);
            }
            if(count == 0){
                ans.add(new Integer(current.val));
                count = nextCount;
                nextCount = 0;
            }
        }
        return ans;
    }

}
