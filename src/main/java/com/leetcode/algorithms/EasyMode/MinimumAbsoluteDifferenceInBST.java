package com.leetcode.algorithms.EasyMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [4,2,6,1,3]
 * Output: 1
 *
 * Example 2:
 *
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [2, 104].
 *     0 <= Node.val <= 105
 */
public class MinimumAbsoluteDifferenceInBST {

    TreeNode prev;
    int min = Integer.MAX_VALUE;

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

    public int getMinimumDifference(TreeNode root) {
        /**
         * Runtime: 3 ms, faster than 30.42% of Java online submissions for Minimum Absolute Difference in BST.
         * Memory Usage: 45.4 MB, less than 51.83% of Java online submissions for Minimum Absolute Difference in BST.
         */
        Integer ans = -1;
        List<Integer> list = new ArrayList<>();
        recursion(root, list);
        for(int i = 1; i < list.size(); i++){
            if(ans<0){
                ans = list.get(i) - list.get(i-1);
            } else {
                ans = Math.min(list.get(i) - list.get(i-1), ans);
            }
        }
        return ans;

        /*
        prev = null;
        inorder(root);
        return min;
         */
    }

    public void recursion(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        recursion(root.left, list);
        list.add(root.val);
        recursion(root.right, list);

    }
    /*
    void inorder(TreeNode root) {
        if(root == null) return;

        inorder(root.left);

        if(prev!=null) min = Math.min(min, Math.abs(prev.val- root.val));
        prev = root;

        inorder(root.right);
    }
     */

}
