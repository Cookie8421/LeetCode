package com.leetcode.algorithms.MediumMode;

/**
 * @Author JoeyYoung
 * @ClassName: Distribute Coins in Binary Tree
 * @Date 2021/12/2 9:23
 * @Description:
 * You are given the root of a binary tree with n nodes where each node in the tree has node.val coins.
 * There are n coins in total throughout the whole tree.
 *
 * In one move, we may choose two adjacent nodes and move one coin from one node to another.
 * A move may be from parent to child, or from child to parent.
 *
 * Return the minimum number of moves required to make every node have exactly one coin.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,0,0]
 * Output: 2
 * Explanation: From the root of the tree, we move one coin to its left child,
 * and one coin to its right child.
 *
 * Example 2:
 *
 * Input: root = [0,3,0]
 * Output: 3
 * Explanation: From the left child of the root, we move two coins to the root [taking two moves].
 * Then, we move one coin from the root of the tree to the right child.
 *
 * Example 3:
 *
 * Input: root = [1,0,2]
 * Output: 2
 *
 * Example 4:
 *
 * Input: root = [1,0,0,null,3]
 * Output: 4
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is n.
 *     1 <= n <= 100
 *     0 <= Node.val <= n
 *     The sum of all Node.val is n.
 *
 */
public class DistributeCoinsInBinaryTree {

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
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Distribute Coins in Binary Tree.
     * Memory Usage: 38.5 MB, less than 51.73% of Java online submissions for Distribute Coins in Binary Tree.
     */
    int count = 0;

    public int distributeCoins(TreeNode root) {
        distribute(root);
        return count;
    }

    public int distribute(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = distribute(root.left);
        int right = distribute(root.right);
        int tmp = root.val - 1;
        count+=Math.abs(left) + Math.abs(right);

        return left + right + tmp;
    }

}
