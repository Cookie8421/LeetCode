package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JoeyYoung
 * @ClassName: Unique Binary Search Trees II
 * @Date 2021/11/16 11:30
 * @Description:
 * Given an integer n, return all the structurally unique BST's (binary search trees),
 * which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 *
 */
public class UniqueBinarySearchTreesII {

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
     *
     * Runtime: 1 ms, faster than 92.93% of Java online submissions for Unique Binary Search Trees II.
     * Memory Usage: 39.9 MB, less than 39.27% of Java online submissions for Unique Binary Search Trees II.
     *
     */
    public List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> res = new ArrayList<>();

        if(start > end){
            res.add(null);
            return res;
        }

        for(int i = start; i <= end; i++){
            for(TreeNode left: generateTree(start, i-1)){
                for(TreeNode right: generateTree(i+1, end)){
                    TreeNode Tree = new TreeNode(i);
                    Tree.left = left;
                    Tree.right = right;
                    res.add(Tree);
                }
            }
        }
        return res;
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTree(1, n);
    }

}
