package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author JoeyYoung
 * @ClassName: Path Sum II
 * @Date 2021/11/17 16:15
 * @Description:
 * Given the root of a binary tree and an integer targetSum,
 * return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
 * Each path should be returned as a list of the node values, not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending at any leaf node.
 * A leaf is a node with no children.
 *
 */
public class PathSumII {

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
     * Runtime: 2 ms, faster than 41.41% of Java online submissions for Path Sum II.
     * Memory Usage: 42.5 MB, less than 6.62% of Java online submissions for Path Sum II.
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> resutlList = new ArrayList<>();
        List<Integer> pathList = new ArrayList<>();
        pathAcc(root, targetSum, resutlList, pathList, 0);
        return resutlList;
    }
    public static void pathAcc(TreeNode root, int targetSum, List<List<Integer>> resultList, List<Integer> pathList,int currentSum){
        if(root == null){
            return;
        }
        List<Integer> tmpList = new ArrayList<>();
        tmpList.addAll(pathList);
        tmpList.add(root.val);
        currentSum += root.val;
        if(currentSum == targetSum && root.left == null && root.right == null){
            resultList.add(tmpList);
            return;
        } else {
            pathAcc(root.left, targetSum, resultList, tmpList, currentSum);
            pathAcc(root.right, targetSum, resultList, tmpList, currentSum);
        }
    }
}
