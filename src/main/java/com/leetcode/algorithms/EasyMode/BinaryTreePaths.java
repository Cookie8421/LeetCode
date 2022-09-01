package com.leetcode.algorithms.EasyMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 *
 * A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 *
 * Example 2:
 *
 * Input: root = [1]
 * Output: ["1"]
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [1, 100].
 *     -100 <= Node.val <= 100
 */
public class BinaryTreePaths {

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

    boolean flag = false;

    public List<String> binaryTreePaths(TreeNode root) {
        /**
         * Runtime: 1 ms, faster than 100.00% of Java online submissions for Binary Tree Paths.
         * Memory Usage: 43 MB, less than 68.72% of Java online submissions for Binary Tree Paths.
         */
        List<String> ans = new ArrayList<>();
        dfs(root, "", ans);
        return ans;
    }

    public void dfs(TreeNode current, String s, List<String> ans){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);
        if(flag){
            stringBuilder.append("->");
        } else {
            flag = true;
        }
        stringBuilder.append(current.val);
        s = stringBuilder.toString();
        if(current.left == null && current.right == null){
            ans.add(s);
            return;
        }
        if(current.left != null){
            dfs(current.left, s, ans);
        }
        if(current.right != null){
            dfs(current.right, s, ans);
        }
    }

}
