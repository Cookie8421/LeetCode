package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;

/**
 * @Author JoeyYoung
 * @ClassName: Add One Row to Tree
 * @Date 2021/12/1 14:47
 * @Description:
 * Given the root of a binary tree and two integers val and depth,
 * add a row of nodes with value val at the given depth depth.
 *
 * Note that the root node is at depth 1.
 *
 * The adding rule is:
 *
 *     Given the integer depth, for each not null tree node cur at the depth depth - 1,
 *     create two tree nodes with value val as cur's left subtree root and right subtree root.
 *     cur's original left subtree should be the left subtree of the new left subtree root.
 *     cur's original right subtree should be the right subtree of the new right subtree root.
 *     If depth == 1 that means there is no depth depth - 1 at all,
 *     then create a tree node with value val as the new root of the whole original tree,
 *     and the original tree is the new root's left subtree.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [4,2,6,3,1,5], val = 1, depth = 2
 * Output: [4,1,1,2,null,null,6,3,1,5]
 *
 * Example 2:
 *
 * Input: root = [4,2,null,3,1], val = 1, depth = 3
 * Output: [4,2,null,1,1,3,null,null,1]
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [1, 104].
 *     The depth of the tree is in the range [1, 104].
 *     -100 <= Node.val <= 100
 *     -105 <= val <= 105
 *     1 <= depth <= the depth of tree + 1
 */
public class AddOneRow2Tree {

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
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Add One Row to Tree.
     * Memory Usage: 38.6 MB, less than 95.73% of Java online submissions for Add One Row to Tree.
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode tmp = new TreeNode(val);
            tmp.left = root;
            return tmp;
        }
        helper(root, val ,depth);
        return root;
    }

    public void helper(TreeNode root, int val, int depth){
        if(root == null){
            return;
        }
        if(depth == 2){
            TreeNode tmpLeft = new TreeNode(val);
            TreeNode tmpRight = new TreeNode(val);
            tmpLeft.left = root.left;
            tmpRight.right = root.right;
            root.left = tmpLeft;
            root.right = tmpRight;
            return;
        }
        if(root.left != null){
            helper(root.left, val, depth - 1);
        }
        if(root.right != null){
            helper(root.right, val ,depth - 1);
        }
    }

}
