package com.leetcode.algorithms.MediumMode;

/**
 * @Author JoeyYoung
 * @ClassName: Convert BST to Greater Tree
 * @Date 2021/11/23 10:26
 * @Description:
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
 *
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 *
 *     The left subtree of a node contains only nodes with keys less than the node's key.
 *     The right subtree of a node contains only nodes with keys greater than the node's key.
 *     Both the left and right subtrees must also be binary search trees.
 *
 * Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [0, 104].
 *     -104 <= Node.val <= 104
 *     All the values in the tree are unique.
 *     root is guaranteed to be a valid binary search tree.
 */
public class ConvertBSTToGreaterTree {

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
     * Runtime: 1 ms, faster than 40.63% of Java online submissions for Convert BST to Greater Tree.
     * Memory Usage: 46.9 MB, less than 5.36% of Java online submissions for Convert BST to Greater Tree.
     */
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }
        int sum = 0;
        if(root.right != null){
            sum = handle(root.right, sum);
        }
        root.val += root.right == null ? 0 : sum;
        sum = root.val;
        if(root.left != null){
            handle(root.left, sum);
        }
        return root;
    }

    public int handle(TreeNode root, int sum){
        if(root == null){
            return sum;
        }
        if(root.right != null){
            sum = handle(root.right, sum);
        }
        root.val += sum;
        sum = root.val;
        if(root.left != null){
            sum = handle(root.left, sum);
        }
        return sum;
    }

    //Better Solution:
    /*int max = 0;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }

    void helper(TreeNode root) {
        if(root == null)
            return;
        helper(root.right);
        root.val = root.val+max;
        max = root.val;
        helper(root.left);
    }*/
}
