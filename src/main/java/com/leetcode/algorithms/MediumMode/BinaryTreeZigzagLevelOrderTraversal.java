package com.leetcode.algorithms.MediumMode;

import java.util.*;

/**
 * @Author JoeyYoung
 * @ClassName: Binary Tree Zigzag Level Order Traversal
 * @Date 2021/12/22 13:55
 * @Description:
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
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
 *     -100 <= Node.val <= 100
 */
public class BinaryTreeZigzagLevelOrderTraversal {

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
     * Runtime: 1 ms, faster than 76.46% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
     * Memory Usage: 39 MB, less than 71.05% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> tmpList = new ArrayList<>();
        boolean reverse = false;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if(root == null){
            return result;
        }
        stack1.add(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if(!reverse){
                TreeNode tmp = stack1.pop();
                if(tmp.left != null) stack2.push(tmp.left);
                if(tmp.right != null) stack2.push(tmp.right);
                tmpList.add(tmp.val);
                if(stack1.isEmpty()){
                    result.add(tmpList);
                    tmpList = new ArrayList<>();
                    reverse = true;
                }
            } else {
                TreeNode tmp = stack2.pop();
                if(tmp.right != null) stack1.add(tmp.right);
                if(tmp.left != null) stack1.add(tmp.left);
                tmpList.add(tmp.val);
                if(stack2.isEmpty()){
                    result.add(tmpList);
                    tmpList = new ArrayList<>();
                    reverse = false;
                }
            }
        }
        return result;
    }

}
