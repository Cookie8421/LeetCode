package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author JoeyYoung
 * @ClassName: Flatten Binary Tree to Linked List
 * @Date 2021/11/18 9:06
 * @Description:
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 *     The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 *     The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 *
 *      Input: root = [1,2,5,3,4,null,6]
 *      Output: [1,null,2,null,3,null,4,null,5,null,6]
 *
 *      Constraints:
 *
 *     The number of nodes in the tree is in the range [0, 2000].
 *     -100 <= Node.val <= 100
 *
 */
public class FlattenBinaryTreeToLinkedList {

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
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.
     * Memory Usage: 38.6 MB, less than 53.55% of Java online submissions for Flatten Binary Tree to Linked List.
     */
    TreeNode curr= null;
    public void flatten(TreeNode root) {
        //TreeNode curr= null;

        traverse(root);
        //return root;
    }
    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        traverse(root.right);
        traverse(root.left);
        root.right= curr;
        curr= root;
        root.left=null;
    }

}
