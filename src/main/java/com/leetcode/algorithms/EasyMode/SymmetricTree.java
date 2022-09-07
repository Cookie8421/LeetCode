package com.leetcode.algorithms.EasyMode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 *
 * Example 2:
 *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [1, 1000].
 *     -100 <= Node.val <= 100
 *
 *
 * Follow up: Could you solve it both recursively and iteratively?
 */
public class SymmetricTree {

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

    public boolean isSymmetric(TreeNode root) {
        /**
         * Runtime: 1 ms, faster than 63.81% of Java online submissions for Symmetric Tree.
         * Memory Usage: 41.9 MB, less than 79.05% of Java online submissions for Symmetric Tree.
         */
        int count = 1;
        ArrayDeque<TreeNode> deque = new ArrayDeque();
        deque.add(root);
        while(!deque.isEmpty()){
            if(count == 1){
                count = 0;
                TreeNode current = deque.poll();
                if(current.left == null && current.right == null){
                    break;
                } else if((current.left == null && current.right != null) || (current.left != null && current.right == null)){
                    return false;
                }
                deque.add(current.left);
                deque.add(current.right);
            } else {
                TreeNode first = deque.pollFirst();
                TreeNode last = deque.pollLast();
                if((first.right == null && last.left != null) || (first.right != null && last.left == null)){
                    return false;
                } else if((first.left == null && last.right != null) || (first.left != null && last.right == null)){
                    return false;
                } else if(first.val != last.val){
                    return false;
                }
                if(first.right != null && last.left != null){
                    deque.addFirst(first.right);
                    deque.addLast(last.left);
                }
                if(first.left != null && last.right != null){
                    deque.addFirst(first.left);
                    deque.addLast(last.right);
                }
            }
        }
        return true;
    }


}
