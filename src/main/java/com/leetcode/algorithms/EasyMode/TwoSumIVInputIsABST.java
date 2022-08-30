package com.leetcode.algorithms.EasyMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [5,3,6,2,4,null,7], k = 9
 * Output: true
 *
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,7], k = 28
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [1, 104].
 *     -104 <= Node.val <= 104
 *     root is guaranteed to be a valid binary search tree.
 *     -105 <= k <= 105
 */
public class TwoSumIVInputIsABST {

    List<Integer> expectList = new ArrayList<>();

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

    public boolean findTarget(TreeNode root, int k) {
        /**
         * Runtime: 34 ms, faster than 5.11% of Java online submissions for Two Sum IV - Input is a BST.
         * Memory Usage: 51.3 MB, less than 63.27% of Java online submissions for Two Sum IV - Input is a BST.
         */
        if(root == null){
            return false;
        }
        if(expectList.contains(root.val)){
            return true;
        }
        int expect = k - root.val;
        expectList.add(expect);
        return findTarget(root.left, k) || findTarget(root.right, k);


        /**
         * Runtime: 3 ms, faster than 96.08% of Java online submissions for Two Sum IV - Input is a BST.
         * Memory Usage: 50.4 MB, less than 74.89% of Java online submissions for Two Sum IV - Input is a BST.
         */
        /*
        public boolean findTarget(TreeNode root, int k) {
            if (root == null) return false;

            return findTar(root, root, k);
        }

        private boolean findTar(TreeNode root, TreeNode child, int k) {
            if (child == null) return false;

            return findVale(root, child, k - child.val)
                || findTar(root, child.left, k)
                || findTar(root, child.right, k);
        }

        private boolean findVale(TreeNode root, TreeNode child, int k) {
            if (root == null) return false;

            if(root.val == k && root != child) return true;
            if (root.val < k) return findVale(root.right, child, k);
            return findVale(root.left, child, k);
        }
         */
    }

}
