package com.leetcode.algorithms.EasyMode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JoeyYoung
 * @ClassName: preorderTraversal
 * @Date 2021/11/15 14:49
 * @Description:
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 */
public class PreorderTraversal {

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
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
     * Memory Usage: 37.4 MB, less than 47.56% of Java online submissions for Binary Tree Preorder Traversal.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> resultList = new ArrayList<>();
        resultList.add(root.val);
        if(root.left != null){
            recurse(root.left, resultList);
        }
        if(root.right != null){
            recurse(root.right, resultList);
        }
        return resultList;
    }
    public static void recurse(TreeNode current, List<Integer> resultList){
        resultList.add(current.val);
        if(current.left != null){
            recurse(current.left, resultList);
        }
        if(current.right != null){
            recurse(current.right, resultList);
        }
    }

}
