package com.leetcode.algorithms.EasyMode;

import java.util.Arrays;

/**
 * @Author JoeyYoung
 * @ClassName: Convert Sorted Array to Binary Search Tree
 * @Date 2021/11/23 8:49
 * @Description:
 *
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 *
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 */
public class ConvertSortedArrayToBinarySearchTree {
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
     * Runtime: 2 ms, faster than 13.76% of Java online submissions for Convert Sorted Array to Binary Search Tree.
     * Memory Usage: 41.2 MB, less than 6.69% of Java online submissions for Convert Sorted Array to Binary Search Tree.
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode result;
        TreeNode leftNode;
        TreeNode rightNode;
        if(nums.length == 1){
            result = new TreeNode();
            result.val = nums[0];
            return result;
        } else if(nums.length == 2){
            result = new TreeNode();
            rightNode = new TreeNode();
            result.val = nums[0];
            rightNode.val = nums[1];
            result.right = rightNode;
            return result;
        }
        int mid = nums.length / 2;
        result = new TreeNode();
        result.val = nums[mid];
        int[] leftArray = Arrays.copyOfRange(nums, 0, mid);
        int[] rightArray = Arrays.copyOfRange(nums, mid + 1, nums.length);
        leftNode = sortedArrayToBST(leftArray);
        rightNode = sortedArrayToBST(rightArray);
        if(leftNode != null && leftNode.val != result.val){
            result.left = leftNode;
        }
        if(rightNode != null && rightNode.val != result.val){
            result.right = rightNode;
        }
        return result;
    }


    //Better Solution:
    /*public TreeNode createTree(int[] nums, int st, int end){
        if(st>=end)
            return null;
        int mid = st+((end-st)/2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(nums,st,mid);
        root.right = createTree(nums,mid+1,end);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int st = 0;
        int end = nums.length;
        return createTree(nums,st,end);
    }*/

}
